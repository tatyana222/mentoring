package com.epam.mentoring.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class CarRacing {

    private static final Logger LOG = LogManager.getLogger(CarRacing.class);

    private static final CountDownLatch startLatch = new CountDownLatch(5);
    private static final CountDownLatch finishLatch = new CountDownLatch(5);
    private static String winner;

    public static void main(String[] args) throws InterruptedException {
        Car car1 = new Car("Car1", 1000);
        Car car2 = new Car("Car2", 2000);
        Car car3 = new Car("Car3", 500);
        Car car4 = new Car("Car4", 3000);
        Car car5 = new Car("Car5", 100);

        Thread thread1 = new Thread(car1);
        Thread thread2 = new Thread(car2);
        Thread thread3 = new Thread(car3);
        Thread thread4 = new Thread(car4);
        Thread thread5 = new Thread(car5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        Thread.sleep(5000);
        thread2.interrupt();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        finishLatch.await();
        LOG.info("The winner is " + winner + "!");
    }

    public static class Car implements Runnable {

        private static final long MAX_DISTANCE = 10000;

        private static final Logger LOG = LogManager.getLogger(Car.class);

        private long friction;
        private long distance;
        private String name;
        private boolean disqualified;

        public Car(String name, long friction) {
            this.name = name;
            this.friction = friction;
        }

        @Override
        public void run() {
            try {
                startLatch.countDown();
                LOG.info("Current count = " + startLatch.getCount());
                startLatch.await();
                LOG.info(name + " has been started!");

                while (distance < MAX_DISTANCE) {
                    Thread.sleep(friction);
                    distance += 100;
                    LOG.info(name + " " + distance);
                }
            } catch (InterruptedException e) {
                LOG.error(e);
                LOG.info(name + " has been disqualified!");
                disqualified = true;
            } finally {
                finish(name, disqualified);
            }
        }
    }

    public static synchronized void finish(String carName, boolean disqualified) {
        if (winner == null && !disqualified) {
            winner = carName;
        }
        finishLatch.countDown();
        LOG.info(carName + " finished!");
        LOG.info(5 - finishLatch.getCount() + " cars have been finished");
    }
}




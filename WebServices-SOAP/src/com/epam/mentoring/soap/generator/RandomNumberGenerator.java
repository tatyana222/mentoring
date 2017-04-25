package com.epam.mentoring.soap.generator;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.concurrent.ThreadLocalRandom;

@WebService(name = "randomNumber")
public class RandomNumberGenerator {

    @WebMethod
    public int randomNumber(int lowerBound, int upperBound) {
        System.out.println("Random number generation is starting");
        return ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1);
    }
}
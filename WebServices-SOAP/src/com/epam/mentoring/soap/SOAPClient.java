package com.epam.mentoring.soap;

import com.epam.mentoring.soap.generator.RandomNumberGeneratorStub;
import com.epam.mentoring.soap.generator.RandomNumberGeneratorStub.RandomNumber;
import com.epam.mentoring.soap.generator.RandomNumberGeneratorStub.RandomNumberResponse;

import java.rmi.RemoteException;

public class SOAPClient {

    private static final String END_POINT = "http://localhost:8080/axis2/services/RandomNumberGenerator?wsdl";

    public static void main(String[] args) throws RemoteException {
        RandomNumberGeneratorStub stub = new RandomNumberGeneratorStub(END_POINT);
        RandomNumber operation = new RandomNumber();
        operation.setLowerBound(1);
        operation.setUpperBound(49);

        requestLotteryNumbers(stub, operation);
    }

    private static void requestLotteryNumbers(RandomNumberGeneratorStub stub, RandomNumber operation) throws RemoteException {
        for (int i = 1; i < 7; i++) {
            RandomNumberResponse randomNumberResponse = stub.randomNumber(operation);
            int randomNumber = randomNumberResponse.get_return();
            System.out.println(i + " random number is: " + randomNumber);
        }
    }
}
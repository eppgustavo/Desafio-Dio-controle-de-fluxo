package fluxo.controle.desafio.dio.counter;

import fluxo.controle.desafio.dio.counter.exception.InvalidParameterException;

import java.util.Scanner;

public class Accountant {

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        System.out.println("Type the first parameter: ");
        final int firstValue = sc.nextInt();

        System.out.println("Type the second parameter: ");
        final int secondValue = sc.nextInt();


        try {
            counter(firstValue, secondValue);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void counter(final int firstValue, final int secondValue) throws InvalidParameterException {

        if (firstValue < secondValue) {
            final int targetValue = secondValue - firstValue;
            for (int i = 0; i <= targetValue; i++) {
                System.out.println(i);
            }
        } else {
            throw new InvalidParameterException("The second parameter must be higher than the first");
        }
    }
}

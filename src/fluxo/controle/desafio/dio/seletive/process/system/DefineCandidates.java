package fluxo.controle.desafio.dio.seletive.process.system;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static fluxo.controle.desafio.dio.seletive.process.constants.Constants.BASE_SALARY;

public class DefineCandidates {

    private static boolean continueTrying;
    private static boolean answeredCall;

    public void selectingCandidates() {

        final String [] candidates = {"RAFAEL", "JOAO", "PATRICIA", "JULIANA", "CARLOS", "AMANDA", "SAMUEL", "EMILY", "RAQUEL", "JOEL", "BEATRIZ"};

        int selectedCandidates = 0;
        int actualCandidate = 0;

        while (selectedCandidates < 5 && actualCandidate < candidates.length) {
            String candidate = candidates[actualCandidate];
            double expectedSalary = setExpectedSalary();

            System.out.println(String.format("The candidate %s is expecting this salary: $ %.2f", candidate, expectedSalary));
            if (BASE_SALARY >= expectedSalary) {
                System.out.println("The cadidate " + candidate + " was selected for the job.");
                System.out.println("#######################################################");
                callingCandidate(candidate);
                System.out.println("#######################################################");
                selectedCandidates++;
            }
            actualCandidate++;
        }
    }

    private static double setExpectedSalary() {
        return ThreadLocalRandom.current().nextDouble(1500, 2500);
    }

    private static void callingCandidate(String candidate) {
        int callAttempts = 1;

        do {
            answeredCall = answerCall();
            continueTrying = !answeredCall;

            if (continueTrying) {
                callAttempts++;

            } else {
                System.out.println("Successful call");
            }

        } while (continueTrying &&  callAttempts < 3) ;

        if (answeredCall) {
            System.out.println("We get contact with " + candidate + " in " + callAttempts + " attempt(s).");
        } else {
            System.out.println("We could not get contact with " + candidate + ", max call numbers exceeded.");
        }
    }

    static boolean answerCall() {
        return new Random().nextInt(3) == 1;
    }

    private static void analyseSalaryCandidate(double expectedSalary) {
        if (BASE_SALARY > expectedSalary) {
            System.out.println("Call Candidate.");
        } else if (BASE_SALARY == expectedSalary) {
            System.out.println("Call a candidate with a counteroffer.");
        } else {
            System.out.println("Wait for results from the other candidates.");
        }
    }
}

import java.security.SecureRandom;
import java.util.Scanner;
public class computerAssisted_Instruction {

    public static boolean checkAnswer(int number1, int number2, double answer,int response, int questionType) {
        boolean isCorrect = false;
        switch(questionType) {
            case 1:
                if (Math.abs(answer - (number1 + number2))< .001) {
                    isCorrect = true;
                }
                break;
            case 2:
                if (Math.abs(answer - (number1 * number2))< .001) {
                    isCorrect = true;
                }
                break;
            case 3:
                if (Math.abs(answer - (number1 - number2))< .001) {
                    isCorrect = true;
                }
                break;
            case 4:
                if (Math.abs(Math.round(answer * 10) - Math.round(((double)number1 / number2) * 10)) < 0.001 ){
                    isCorrect = true;
                }
                break;
        }//end switch

        if (isCorrect == true) {
            System.out.println(printResponseCorrect(response));
        }
        else {
            System.out.println(printResponseIncorrect(response));

        }
        return isCorrect;
    }//end of checkAnswer

    public static String printResponseCorrect(int responseNumber){
        String statement = new String("");
        switch(responseNumber){
            case 0:
                statement = "Great Job";
                break;
            case 1:
                statement = "Correct";
                break;
            case 2:
                statement = "Good Work";
                break;
            case 3:
                statement = "You're right";
                break;

        }// end switch


        return statement;
    }//end printResponseCorrect

    public static String printResponseIncorrect(int responseNumber){
        String statement = new String("");
        switch(responseNumber){
            case 0:
                statement = "Sorry that isn't right";
                break;
            case 1:
                statement = "That isn't the answer";
                break;
            case 2:
                statement = "Incorrect";
                break;
            case 3:
                statement = "Sorry that is incorrect";
                break;
        }// end switch
        return statement;
    }//end printResponseCorrect
    public static boolean generateQuestion(SecureRandom rand, Scanner scnr, int boundLimit, int mathType) {


        int number1;
        int number2;
        double guess;
        int statementNumber;


        boolean isRight = false;
        if(mathType == 5){
            mathType = rand.nextInt(4) + 1;
        }
        number1 = rand.nextInt(boundLimit);
        if(mathType == 4) {
            number2 = rand.nextInt((boundLimit-1))+1;
        }//end if
        else {
            number2 = rand.nextInt(boundLimit);
        }//end else
            statementNumber = rand.nextInt(4);

            switch(mathType){
                case 1:
                    System.out.println("What is " + number1 + " plus " + number2 + "?");
                    break;
                case 2:
                    System.out.println("What is " + number1 + " times " + number2 + "?");
                    break;
                case 3:
                    System.out.println("What is " + number1 + " minus " + number2 + "?");
                    break;
                case 4:
                    System.out.println("What is " + number1 + " divided by " + number2 + "?");
                    System.out.println("Enter respsone to two decimals. ");
                    break;
            }//end switch

            guess = scnr.nextDouble();
            isRight = checkAnswer(number1,number2,guess,statementNumber,mathType);

           return isRight;
    }

    public static int generateUpperLimit(int level){
        int upperLimit = 0;
        switch (level){
            case 1:
                upperLimit = 10;
                break;
            case 2:
                upperLimit = 100;
                break;
            case 3:
                upperLimit = 1000;
                break;
            case 4:
                upperLimit = 10000;
                break;

        }//end switch
        return upperLimit;
    }//end generatelimit

    public static void printMenu(){
        System.out.println("Menu");
        System.out.println("1 - addition");
        System.out.println("2 - multiplication");
        System.out.println("3 - subtraction");
        System.out.println("4 - division");
        System.out.println("5 - mix of all");
    }//end print menu

    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();
        int i;

        int numberCorrect = 0;
        boolean isRight = false;
        int difficultyLevel = 0;
        int upperLimit;
        int mathChoice = 0;
        char nextSession = 'y';

        while(nextSession == 'y' || nextSession =='Y') {

            System.out.println("Please Select a difficulty level 1 to 4");
            difficultyLevel = scnr.nextInt();
            while (difficultyLevel < 1 || difficultyLevel > 4) {
                System.out.println("That is not a valid level");
                difficultyLevel = scnr.nextInt();
            }// end while loop

            upperLimit = generateUpperLimit(difficultyLevel);

            System.out.println("What type of arithmetic would you like to work on?");
            printMenu();
            mathChoice = scnr.nextInt();

            while (mathChoice < 1 || mathChoice > 5) {
                System.out.println("That is not a valid choice");
                mathChoice = scnr.nextInt();
            }// end while loop



            for (i = 0; i < 10; i++) {
                isRight = generateQuestion(rand, scnr, upperLimit, mathChoice);
                if (isRight == true) {
                    numberCorrect++;
                }//end if
            }//end for loop
            System.out.println("");
            System.out.println("You got " + numberCorrect + " out of 10 correct.");
            System.out.println("You got " + (10 - numberCorrect) + " out of 10 incorrect");
            if (numberCorrect / 10.0 < .75) {
                System.out.println("Please ask your teacher for extra help");
            }//end of if
            else {
                System.out.println("Congratulations, you're ready for the next level!");
            }//end else

            System.out.println("Would you like to start a new session? (Y/N)");
            nextSession = scnr.next().charAt(0);
        }
    }//end main


}//end public class

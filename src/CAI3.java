import java.security.SecureRandom;
import java.util.*;
import java.lang.Math;

class CAI3 {

  private static Scanner scanner;
  private static SecureRandom randomOperand, randomResponse;
  public static void main(String[] args) 
  {
    quiz();
  }

  private static void quiz()
  {
    randomOperand = new SecureRandom();
    randomResponse = new SecureRandom();
    scanner = new Scanner(System.in);
    while (true)
    {
      int numQuestions = 10;
      int numCorrect = 0;
      for (int i = 0; i < numQuestions; i++)
      {
        int operand1 = generateOperand();
        int operand2 = generateOperand();
        int correctAnswer = operand1 * operand2;
        boolean correct = false;
        askQuestion(operand1, operand2, i);
        int userResponse = readResponse();

        correct = isAnswerCorrect(userResponse, correctAnswer);
        if (correct)
        {
          displayCorrectResponse();
          correct = true;
        }
        else
        {
          displayIncorrectResponse();
        }
        System.out.println();
        System.out.println();
        if (correct)
        {
          numCorrect++;
        }
    
      }
      double score = (double)numCorrect / (double)numQuestions;
      displayCompletionMessage(score);
      System.out.println("\n\nResetting program...\n\n");
    }
  }

  private static int generateOperand()
  {
    int op = Math.abs(randomOperand.nextInt());
    op %=10;
    return op;
  }
  private static void askQuestion(int op1, int op2, int index)
  {
    System.out.println("Question " + (index+1) + ": How much is " + op1 + " times "+ op2+"?");
  }
  private static int readResponse()
  {
    int inp = scanner.nextInt();
    return inp;
  }
  private static boolean isAnswerCorrect(int input, int correctAnswer)
  {
    return (input == correctAnswer);
  }
  private static void displayCorrectResponse()
  {
    int message = Math.abs(randomResponse.nextInt()%4)+1;

    switch (message)
    {
      case 1:
        System.out.println("Very good!");
        break;
      case 2:
        System.out.println("Excellent!");
        break;
      case 3:
        System.out.println("Nice work!");
        break;
      default:
        System.out.println("Keep up the good work!");
        break;
    }
  }
  private static void displayIncorrectResponse()
  {
    int message = Math.abs(randomResponse.nextInt()%4)+1;

    switch (message)
    {
      case 1:
        System.out.println("Incorrect");
        break;
      case 2:
        System.out.println("Wrong.");
        break;
      case 3:
        System.out.println("Sorry!");
        break;
      default:
        System.out.println("Nope. Maybe next time.");
        break;
    }
  }
  private static void displayCompletionMessage(double s)
  {
    s *= 100;
    boolean smart = (s >=75.0);
    System.out.println("Your score was: " + s + "%. \n" + ((smart)? "Congratulations, you are ready to go to the next level!" : "Please ask your teacher for extra help."));
  }
}
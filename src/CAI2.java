import java.security.SecureRandom;
import java.util.*;
import java.lang.Math;

class CAI2 {

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
    int operand1 = generateOperand();
    int operand2 = generateOperand();
    int correctAnswer = operand1 * operand2;
    boolean correct = false;
    while (correct == false)
    {
      askQuestion(operand1, operand2);
      //System.out.println();
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
        System.out.println();
        System.out.println();
      }
    }
  }
  private static int generateOperand()
  {
    int op = Math.abs(randomOperand.nextInt());
    op %=10;
    return op;
  }
  private static void askQuestion(int op1, int op2)
  {
    System.out.println("How much is " + op1 + " times "+ op2+"?");
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
        System.out.println("No. Please try again.");
        break;
      case 2:
        System.out.println("Wrong. Try once more.");
        break;
      case 3:
        System.out.println("Don't give up!");
        break;
      default:
        System.out.println("No. Keep trying.");
        break;
    }
  }
}
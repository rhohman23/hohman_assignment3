import java.security.SecureRandom;
import java.util.*;
import java.lang.Math;

class CAI1 {

  private static Scanner scanner;
  private static SecureRandom randomOperand;
  public static void main(String[] args) 
  {
    quiz();
  }

  private static void quiz()
  {
    randomOperand = new SecureRandom();
    scanner = new Scanner(System.in);
    int operand1 = generateOperand();
    int operand2 = generateOperand();
    int correctAnswer = operand1 * operand2;
    boolean correct = false;
    while (correct == false)
    {
      askQuestion(operand1, operand2);
      System.out.println();
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
    System.out.println("Very good!");
  }
  private static void displayIncorrectResponse()
  {
    System.out.println("No. Please try again");
  }
}
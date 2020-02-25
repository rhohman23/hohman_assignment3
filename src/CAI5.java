import java.security.SecureRandom;
import java.util.*;
import java.lang.Math;

class CAI5 {

  private static Scanner scanner;
  private static SecureRandom randomOperand, randomResponse, randomProblemType;
  public static void main(String[] args) 
  {
    quiz();
  }

  private static void quiz()
  {
    randomOperand = new SecureRandom();
    randomResponse = new SecureRandom();
    randomProblemType = new SecureRandom();
    scanner = new Scanner(System.in);
    boolean showMoreProblems = true;
    while (showMoreProblems)
    {
      int difficulty = readDifficulty();
      int problemType = readProblemType();
      System.out.println();
      int numQuestions = 10;
      int numCorrect = 0;
      for (int i = 0; i < numQuestions; i++)
      {
        int actualProblemType = specificProblemType(problemType);
        int operand1 = generateQuestionArgument(difficulty);
        int operand2 = generateQuestionArgument(difficulty);
        int correctAnswer = calculateAnswer(operand1, operand2, actualProblemType);
        boolean correct = false;
        askQuestion(operand1, operand2, i, actualProblemType);
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
      System.out.println("\n\nWould you like to restart the program? enter (y/n)");
      showMoreProblems = scanner.next().charAt(0) == 'y';
      if (showMoreProblems)
      {
        System.out.println("\n\n");
      }

    }
  }

  private static int generateQuestionArgument(int d)
  {
    int op = Math.abs(randomOperand.nextInt());
    op %=(Math.pow(10, d));
    return op;
  }
  private static void askQuestion(int op1, int op2, int index, int pType)
  {
    String operatorWord = getOperatorWord(pType);
    System.out.println("Question " + (index+1) + ": How much is " + op1 + " " + operatorWord + " "+ op2+"?");
    if (pType == 4)
    {
      System.out.println("Round answer DOWN to nearest whole number");
    }
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
  private static int readDifficulty()
  {
    System.out.println("Enter a difficulty level (1-4)");
    int difficulty = scanner.nextInt();
    return difficulty;
  }
  private static int readProblemType()
  {
    System.out.print("Enter a number indicating the type of problems that you'd like to solve (1-5).\n1... Addition\n2... Subtraction\n3... Multiplication\n4... Division\n5... Mixed\nChoice: ");
    int pType = scanner.nextInt();
    return pType;
  }
  private static int calculateAnswer(int op1, int op2, int pType)
  {
    int ans=0;
    switch (pType)
    {
      case 1: 
        ans = op1 + op2;
        break;
      case 2: 
        ans = op1 - op2;
        break;
      case 3: 
        ans = op1 * op2;
        break;
      case 4: 
        ans = op1 / op2;
        break;
    }
    return ans;
  }

  private static int specificProblemType(int pType)
  {
    int actualPType = pType;
    if (pType != 1 && pType != 2 && pType != 3 && pType != 4)
    {
      actualPType = Math.abs(randomProblemType.nextInt()%4) + 1;
    }
    return actualPType;
  }
  private static String getOperatorWord(int pType)
  {
    switch (pType)
    {
      case 1:
        return "plus";
      case 2:
        return "minus";
      case 3:
        return "times";
      case 4:
        return "divided by";
    }
    return "times";
  }
}
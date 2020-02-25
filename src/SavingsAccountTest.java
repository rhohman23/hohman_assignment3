public class SavingsAccountTest
{
  public static void main(String[] args)
  {
    SavingsAccount sa1 = new SavingsAccount(2000.0);
    SavingsAccount sa2 = new SavingsAccount(3000.0);
    SavingsAccount.modifyInterestRate(.04);
    System.out.println("At a 4% interest rate:");
    for (int i = 1; i < 13; i++)
    {
      System.out.println("Month " + i + ":\nAccount 1 interest earned: $"+ String.format("%.2f",sa1.calculateMonthlyInterest()) + "\nAccount 1 current balance: $"+ String.format("%.2f",sa1.getCurrentBalance()) + "\nAccount 2 interest earned: $" + String.format("%.2f",sa2.calculateMonthlyInterest()) + "\nAccount 2 current balance: $" + String.format("%.2f",sa2.getCurrentBalance()));

      System.out.println();
    }
    System.out.println("\n\n");
    SavingsAccount.modifyInterestRate(.05);
    System.out.println("After an additional month of a new 5% interest rate:\nAccount 1 interest earned: $"+ String.format("%.2f",sa1.calculateMonthlyInterest()) + "\nAccount 1 current balance: $"+ String.format("%.2f",sa1.getCurrentBalance()) + "\nAccount 2 interest earned: $" + String.format("%.2f",sa2.calculateMonthlyInterest()) + "\nAccount 2 current balance: $" + String.format("%.2f",sa2.getCurrentBalance()));
  }
}
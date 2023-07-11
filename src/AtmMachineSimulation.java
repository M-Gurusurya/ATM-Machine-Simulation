
import java.util.Scanner;
class Banking{
    private int balance=10000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
public class AtmMachineSimulation {
    static int amount;

    public static void main(String[] args) {
        Banking banking=new Banking();
        Scanner scanner = new Scanner(System.in);
        getInputs(banking);
    }
    public static void getInputs(Banking banking)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("press 1 for deposit");
        System.out.println("press 2 for withdraw");
        System.out.println("press 3 for check balance");
        int result = scanner.nextInt();
        switch (result)
        {
            case 1:{
                System.out.println("enter amount");
                amount= scanner.nextInt();
                deposit(amount,banking);
                break;
            }
            case 2:
            {
                System.out.println("enter amount");
                amount= scanner.nextInt();
                try {
                    withdraw(amount,banking);
                }
                catch (InsufficientFundsException errorMessage)
                {
                    System.out.println(errorMessage);
                }
                catch (InvalidAmountException errorMessage)
                {
                    System.out.println(errorMessage);
                }
            }
            case 3:{
                System.out.println("your balance: " + banking.getBalance());
                break;
            }

        }
        System.out.println("press 1 to continue:");
        System.out.println("press 2 to exit:");
        int choice= scanner.nextInt();
        if(choice==1)
        {
            getInputs(banking);
        }
    }
    public static void deposit(int amount,Banking banking)
    {

        banking.setBalance(banking.getBalance()+amount);
    }
    public static void withdraw(int amount,Banking banking) throws InsufficientFundsException, InvalidAmountException
    {
        if(amount>banking.getBalance())
        {
            throw new InsufficientFundsException("Insufficient money");
        }
        if(amount<=0)
        {
            throw new InvalidAmountException("Amount should be greater than 0");
        }
    }
}
class InsufficientFundsException extends Exception
{
    InsufficientFundsException(String errorMessage)
    {
        super(errorMessage);
    }
}
class InvalidAmountException extends Exception
{
    InvalidAmountException(String errorMessage)
    {
        super(errorMessage);
    }
}
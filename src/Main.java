import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        final int pin = 1234;
        Double balance = 2500.75;
        boolean exit = true;
        int depositCount = 0;
        int withdrawCount = 0;
        int attempts = 3;
        System.out.println("Welcome!");

        do{
            attempts--;
            System.out.print("Enter your PIN: ");
            int inPin = Integer.parseInt(in.nextLine());
            if (inPin == pin){
                break;
            }
            else{
                System.out.println("Try Again!\nRemaining Attempts: "+(attempts));
                if(attempts==0) exit=false;
            }
        }
        while (attempts!=0);


            while(exit){
                System.out.print(""" 
                ========= ATM =========
                1. Check Balance
                2. Deposit
                3. Withdraw
                4. Show Account Status
                5. Exit
                =======================
                """);
                int choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1 -> CheckBalance(balance);
                    case 2 -> Deposit(balance, depositCount);
                    case 3 -> Withdraw(balance, withdrawCount);
                    case 4 -> ShowAccountStatus(balance);
                    case 5 -> Exit(depositCount, withdrawCount, exit);
                    default-> Default();
                }
            }
        }

    public static void CheckBalance(double balance){
        System.out.println("Balance: " + balance);
    }

    public static void Deposit(double balance, int depositCount){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Deposit amount: ");
        double inDeposit = Double.parseDouble(in.nextLine());
        if(inDeposit>0){
            balance += inDeposit;
            depositCount++;
        }
        else System.out.println("Invalid amount!");
        System.out.println("Balance: " + balance);
    }

    public static void Withdraw(double balance, int withdrawCount){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Withdraw amount: ");
        double inWithdraw = Double.parseDouble(in.nextLine());
        if(inWithdraw>0 && inWithdraw<balance){
            balance -= inWithdraw;
            withdrawCount++;
        }
        else if (inWithdraw==0){
            System.out.println("Transaction cancelled!");
        }
        else System.out.println("Invalid amount!");
        if(balance==0) System.out.println("Warning: Your account is empty!");
        System.out.println("Balance: " + balance);
    }

    public static void ShowAccountStatus(double balance){
        if(balance>=5000) System.out.println("VIP Customer");
        else if(balance>=1000 && balance<5000) System.out.println("Regular Customer");
        else System.out.println("Low Balance");
    }

    public static void Exit(int depositCount, int withdrawCount, boolean exit){
        System.out.println("Thank you for using our ATM.");
        System.out.println("Total successful deposit/withdrawal transactions: " + depositCount+withdrawCount +"\nDeposits: " + depositCount + "\nWithdraws: " + withdrawCount);
        exit = false;
    }

    public static void Default(){
        System.out.println("\'Invalid option!\'");
    }

}
import java.util.Scanner;

public class Main {

    static double  balance = 2500.75;
    static int depositCount = 0;
    static int withdrawCount = 0;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        final int pin = 1234;
        int attempts = 3;
        System.out.println("Welcome!");

        do{
            attempts--;
            System.out.print("Enter your PIN: ");
            int inPin = Integer.parseInt(in.nextLine());
            if (inPin == pin){
                attempts=0;
            }
            else{
                System.out.println("Try Again!\nRemaining Attempts: "+(attempts));
                if(attempts==0) {
                    System.out.println("Your account has been locked!");
                    return;
                }
            }
        }
        while (attempts!=0);

        outer:
        while(true){
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
                case 1 -> checkBalance();
                case 2 -> checkDeposit();
                case 3 -> checkWithdraw();
                case 4 -> showAccountStatus();
                case 5 -> {
                    checkExit();
                    break outer;
                }
                default-> checkDefault();
            }
        }
    }

    public static void checkBalance(){
        System.out.println("Balance: " + balance);
    }

    public static void checkDeposit(){
        System.out.print("Enter Deposit amount: ");
        double inDeposit = Double.parseDouble(in.nextLine());
        if(inDeposit>0){
            balance += inDeposit;
            depositCount++;
            System.out.println("Balance: " + balance);
        }
        else System.out.println("Invalid amount!");
    }

    public static void checkWithdraw(){
        System.out.print("Enter Withdraw amount: ");
        double inWithdraw = Double.parseDouble(in.nextLine());
        if(inWithdraw>0 && inWithdraw<=balance){
            balance -= inWithdraw;
            withdrawCount++;
            System.out.println("Balance: " + balance);
            if(balance==0) System.out.println("Warning: Your account is empty!");
        }
        else if (inWithdraw==0){
            System.out.println("Transaction cancelled!");
        }
        else if(inWithdraw>balance){
            System.out.println("Insufficient balance!");
        }
        else System.out.println("Invalid amount!");
    }

    public static void showAccountStatus(){
        if(balance>=5000) System.out.println("VIP Customer");
        else if(balance>=1000) System.out.println("Regular Customer");
        else System.out.println("Low Balance");
    }

    public static void checkExit(){
        System.out.println("Thank you for using our ATM.");
        System.out.println("Total successful deposit/withdrawal transactions: " + (depositCount+withdrawCount) +"\nDeposits: " + depositCount + "\nWithdraws: " + withdrawCount);
    }

    public static void checkDefault(){
        System.out.println("\'Invalid option!\'");
    }

}
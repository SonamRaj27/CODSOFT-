import  java.util.Scanner;

class BankAccount{

    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionsHistory = "";

    public void register(){
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.name = s.nextLine();
        System.out.println("\nEnter Your Username -");
        this.userName = s.nextLine();
        System.out.println("\n Enter your password -");
        this.password = s.nextLine();
        System.out.println("\nEnter Your Account Number -");
        this.accountNo = s.nextLine();
        System.out.println("\nRegistration completed.. Kindly login");
}

    public boolean login(){
        boolean isLogin = false;
        Scanner s= new Scanner(System.in);
        while (!isLogin){
            System.out.println("\nEnter Your Username -");
            String Username = s.nextLine();
            if (Username.equals(userName)){
                while(!isLogin){
                    System.out.println("\nEnter Your password -");
                    String Password = s.nextLine();
                    if(Password.equals(password)){
                        System.out.println("\nLogin successful!!");
                        isLogin = true;
                    }
                    else{
                        System.out.println("nIncorrect Password");
                     }
                }
            }
            else{
                System.out.println("\n Username not found");
            }
        }
        return isLogin;
    }

    public void withdraw(){

        System.out.println("\nEnter amount to withdraw -");
        Scanner s = new Scanner(System.in);
        float amount = s.nextFloat();
        try{

            if ( balance>=amount){
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str= amount + "Rs Withdrawed\n";
                transactionsHistory = transactionsHistory.concat(str);

            }
            else {
                System.out.println("\nInsufficient Balance");

            }
        }
        catch(Exception e){
    
        }
    }

    public void deposit(){
        System.out.println("\nEnter amount to deposit -");
        Scanner s = new Scanner(System.in);
        float amount = s.nextFloat();

        try{
            if ( amount <= 100000f ){
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + "Rs deposited\n";
                transactionsHistory = transactionsHistory.concat(str);
            }
            else {
                 System.out.println("\nSorry...Limit is 100000.00");
            }

        }
        catch( Exception e) {

        }
    }

    public void transfer(){

        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name -");
        String receipent = s.nextLine();
        System.out.println("\nEnter amount to transfer -");
        float amount = s.nextFloat();
        
        try{
            if ( balance >= amount ){
                 if ( amount <= 50000f ) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Tranferred to " + receipent);
                    String str = amount + "Rs tranferred to " + receipent + "\n";
                    transactionsHistory = transactionsHistory.concat(str);
                 }
                 else{
                    System.out.println("\nSorry...Limit is 50000.00");
                 }
            }
            else{
                System.out.println("\nInsufficient balance");
            }
        }
        catch (Exception e){

        }
    }

    public void checkbalance(){
        System.out.println("\n" + balance + "Rs");
    }

    public void transHistory(){
        if ( transactions ==0 ){
             System.out.println("\nEmpty");
        }
        else {
            System.out.println("\n" + transactionsHistory);
        }
    }

public class AtmInterface{

    public static int takeIntegerInput(int limit){
        int input = 0;
        boolean flag = false;

        while(!flag){
            try{
                Scanner s = new Scanner(System.in);
                input = s.nextInt();
                flag = true;

                if(flag && input > limit || input<1){
                    System.out.println("Choose the number between 1 to "+limit);
                    flag = false;
                }

            }
            catch ( Exception e){
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return input;
    }

    public static void main(String[] args){

        System.out.println("\n************WELCOME TO SBI ATM SYSTEM**************\n");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Enter your choice -");
        int choice = takeIntegerInput(2);

        if(choice ==1){
            BankAccount b = new BankAccount();
            b.register();
            while(true){
                System.out.println("n1.Login \n2.Exit");
                System.out.println("Enter your choice -");
                int ch = takeIntegerInput(2);
                if (ch==1){
                    if(b.login()){
                        System.out.println("\n\n*********WELCOME BACK********" +b.name+"********\n");
                        boolean isFinished = false;
                        while(! isFinished){
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("\nEnter your choice -");
                            int c = takeIntegerInput(6);
                            switch(c){
                                case 1:
                                   b.withdraw();
                                   break;
                                case 2:
                                   b.deposit();
                                   break;
                                case 3:
                                   b.transfer();
                                   break;
                                case 4:
                                   b.checkbalance();
                                   break;
                                case 5:
                                  b.transHistory();
                                  break;
                                case 6:
                                  isFinished = true;
                                  break;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
             System.exit(0);
        }


    }
}

}
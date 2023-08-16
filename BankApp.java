import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BankApp {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "Welcome to Smart Banking App";
        final String CREATE_NEW_ACCOUNT="(01)-Create New Account";
        final String DEPOSIT_MONEY = "(02)-Deposit Money";
        final String WITHDRAW_MONEY= "(03)-Withdraw  Money";
        final String TRANFER_MONEY = "(04)-Tranfer Money";
        final String CHECK_ACCOUNT_BALANCE="(05)-Check Account Balance";
        final String DROP_EXISTING_ACCOUNT="(06)-Drop Existing Account";
        final String EXIT = "EXIT from the app";



        String[] CustomerName = new String[0];
        String[] CustomerID = new String[0];
        int[] Balance=new int[0];

        String screen = DASHBOARD;

        // boolean validNew;
        // String nameNew;
        // int initialDeposit;

        do {
            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("-".repeat(40));
            System.out.println(" ".repeat((40 - APP_TITLE.length() + 7)/2).concat(APP_TITLE));
            System.out.println("-".repeat(40));

            switch(screen){
                case DASHBOARD: 
                    System.out.println("\n(01)-Create New Account");
                    System.out.println("(02)-Deposit Money");
                    System.out.println("(03)-Withdraw  Money");
                    System.out.println("(04)-Tranfer Money");
                    System.out.println("(05)-Check Account Balance");
                    System.out.println("(06)-Drop Existing Account");
                    System.out.println("(07)-Exit\n");
                    System.out.print("Enter an option to continue > ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){
                        case 1: screen=CREATE_NEW_ACCOUNT ;break;                    
                        case 2: screen = DEPOSIT_MONEY; break;
                        case 3: screen = WITHDRAW_MONEY; break;
                        case 4: screen = TRANFER_MONEY; break;
                        case 5:screen=CHECK_ACCOUNT_BALANCE ;break;
                        case 6:screen=DROP_EXISTING_ACCOUNT; break;
                        case 7: screen=EXIT; break;
                        default: continue;
                    }
                    break;
                

                case CREATE_NEW_ACCOUNT:
                    String ID=String.format(" ID: SDB-%05d", (CustomerName.length + 1));
                    System.out.println(ID);
                    boolean validNew;
                    String nameNew;
                    int initialDeposit;
                   
                      do{
                        validNew=true;
                        System.out.print("Name : ");
                        nameNew = SCANNER.nextLine().strip();
                        if (nameNew.isBlank()){
                            System.out.printf("%sName can't be empty%s\n", COLOR_RED_BOLD, RESET);
                            validNew = false;
                            continue;
                        }
                        for (int i = 0; i < nameNew.length(); i++) {
                            if (!(Character.isLetter(nameNew.charAt(i)) || 
                                Character.isSpaceChar(nameNew.charAt(i))) ) {
                                System.out.printf("%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                                validNew = false;
                                continue;
                            }
                        }
                    }while(!validNew);

                    do{
                        validNew=true;
                        System.out.print("Initial Deposit : ");
                        initialDeposit= SCANNER.nextInt();
                        SCANNER.nextLine();

                        if(initialDeposit<5000){
                                System.out.printf("%sInsufficiant Amount%s\n", COLOR_RED_BOLD, RESET);

                        }


                    }while(!validNew);

                    String[] newCustomerName = new String[CustomerName.length + 1];
                    String[] newCustomerID = new String[CustomerID.length + 1];


                    for (int i = 0; i < CustomerName.length; i++) {
                        
                        newCustomerName[i]=CustomerName[i];
                        newCustomerID[i] = CustomerID[i];
                    }
                    newCustomerID[newCustomerID.length -1] = ID;
                    CustomerID=newCustomerID;
                    newCustomerName[newCustomerName.length -1] = nameNew;
                    CustomerName = newCustomerName;


                    System.out.println();
                    System.out.printf( " %s : %shas been created sucessfully. Do you want to add new Customer(Y/n)? ",ID,nameNew);
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;
                    


                case EXIT:
                    final String APP_CLOSE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, "Thank Your Using Smart Bank APP!", RESET);
                    System.out.println(CHECK_ACCOUNT_BALANCE);
                    System.out.println("-".repeat(40));
                    System.out.println();
                    System.out.println();
                    System.out.println();
                     System.out.println(" ".repeat((40 - APP_CLOSE.length() + 7)/2).concat(APP_CLOSE));
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    
                    System.out.println("-".repeat(40));
                    
                    System.exit(0);
            
                }
            
        }while(true);
    }
}
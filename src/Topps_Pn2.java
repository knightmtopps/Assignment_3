public class Savings_account {
    private double savingsBalance;
    private static double annualInterestRate;

    public void calculateMonthlyInterest() {
    savingsBalance = savingsBalance + savingsBalance * annualInterestRate/12;
    }//end of calculatemonthlyinterest

    public static void modifyInterestRate(double newInterestRate){
        annualInterestRate = newInterestRate;
    }//end of modifyInterestRate

    public Savings_account(double balance){
        savingsBalance = balance;
    }

    public double getAccountBalance(){
        return savingsBalance;
    }

    public static void main (String [] args) {
    Savings_account saver1 = new Savings_account(2000);
    Savings_account saver2 = new Savings_account(3000);
    int i;

    modifyInterestRate(0.04);

    for(i=0; i<12; i++) {
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Saver1 balance for month %d is $%.2f\n", (i+1),  saver1.getAccountBalance());
        System.out.printf("Saver2 balance for month %d is $%.2f\n", (i+1) , saver2.getAccountBalance());
    }

    modifyInterestRate(.05);
    System.out.println("");
    System.out.println("Interest rate set to 5%");
    saver1.calculateMonthlyInterest();
    saver2.calculateMonthlyInterest();

    System.out.printf("Saver1 balance is $%.2f\n" , saver1.getAccountBalance());
    System.out.printf("Saver2 balance is $%.2f\n" , saver2.getAccountBalance());

    }// end of main

}//end of savings account class

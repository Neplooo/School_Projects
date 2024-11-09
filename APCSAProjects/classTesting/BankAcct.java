/** Bank Account Test Class
 * @author Alberto
 * @version 0.1
 * @since 10/28/24
 */

public class BankAcct {
    
    private double bankBalance;
    private String accHolder;

    public BankAcct(){
    }
    
    public BankAcct(double initAmount, String name){

        bankBalance = initAmount;
        accHolder = name;

    }


    /** Deposit method adds money to an account.
     * Preconditions: None. 
     * Postconditions: Bank account will contain the amount deposited. 
     * @param n Money that goes in
     */
    public void deposit(double n){

        bankBalance += n;
        viewBalance();

    }

    public void withdraw(double n){


        if (bankBalance - n < 0){

            System.out.println("You are withdrawing more money than what is in your account!");

        }else{
        bankBalance -= n;
        }
        viewBalance();

    }

    public void viewBalance(){

        System.out.println("Current Balance: $" + bankBalance);

    }

    public Double getBalance(){

        return bankBalance;

    }

    public String getName(){
        return accHolder;
    }

}

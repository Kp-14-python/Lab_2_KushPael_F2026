import java.util.Scanner;
import java.util.InputMismatchException;

public class Bank_System {
	//variables 
	long Accountnumber;
	String name;
	int balance;
	
	//Function which handle Argumentexception
	public void BankAccount(long Accountnumber, String name, int balance) {
		//Valid Account number.
		if (Accountnumber < 100000000 || Accountnumber > 999999999) {
			throw new IllegalArgumentException("Account number must be exactly 9 digits.");
		}
		//Valid name
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name can not be blank.");
		}
		//Valid balance
		if (balance <=0) {
			throw new IllegalArgumentException("Balance can not be negative.");
		}
		//Store information
		this. Accountnumber = Accountnumber;
		this.name = name;
		
		//store balance
		this.balance = Math.round(balance);
	
	}
    //deposit function
	public void deposit(double amount) {
		//Deposit can not be zero or negative
		if(amount<=0) {
			throw new IllegalArgumentException("Deposit amount must be grater than zero.");
		}
		balance=(int) (balance + amount);
		
		System.out.println("Deposit Successfully..."+ amount);
	}
    //withdrew function
	public void withdraw(double amount) {
		//withdraw can not be zero or negative
		if (amount <=0) {
			throw new IllegalArgumentException("withdrew amount must be grater than zero.");
		}
		balance = (int) (balance - amount); 
		
		System.out.println("Withdraw Successfully..."+amount);
	}
	//Display accountnumber, name and balance.
	public void display() {
		System.out.println("===========Your Account Information=============");
		System.out.println("You account number : "+Accountnumber);
		System.out.println("You name : "+name);
		System.out.println("You account balance : "+balance);
	}
	
	// Get account number
    public long getAccountNumber() {
        return Accountnumber;
    }

    // Get name
    public String getName() {
        return name;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }
    
    //Main driver class
    	 static Scanner sc;

		public static void main(String[] args) {
			 Scanner sc = new Scanner(System.in);
    		
    		//Creating array to add accountnumber, name and balance
    		Bank_System[] account = new Bank_System[1];
    		System.out.println("--------Enter the bank details----------");
    		
    		//loop for adding three drtails in array
    		for (int i = 0 ; i<account.length; i++) {
    			account[i] = new Bank_System();
    			boolean accountCreated = false;
    			
    			//If it is true. we can proced further.
    			while(!accountCreated) {
    				try {
    					System.out.println("Enter detail for account");
        				//Taking Account number from users
        				System.out.print("Enter Account number (9 digit) : ");
        				
        				long Accountnumber= sc.nextLong();   
        				
        				 sc.nextLine();
        				
        				//Taking name from user
        				System.out.print("Enter your name : ");
        				String name = sc.nextLine();
        				
        				//Taking balance info from user
        				System.out.print("Enter your balance : ");
        				int balance = sc.nextInt();
        				
        				//Calling BankAccount function from Bank_System class
        				account[i].BankAccount(Accountnumber, name, balance);
        				accountCreated = true;
        			
    				}catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input type. Please enter numbers where expected.");
                        sc.nextLine(); // Clear the invalid scanner input
                    } catch (IllegalArgumentException e) {
                        System.out.println("Validation Error: " + e.getMessage());
                    }
    				
    			}
    		}
    		
    		
    		
    		for (int i=0 ; i<account.length;i++) {
    			account[i].display();
    			//Deposit Transaction
        		System.out.println("----------Deposit-----------");
    			boolean Depositdone=false;
    			while (!Depositdone) {
    				//Getting deposit amount from user. 
    				try {
    					System.out.print("Enter you deposit amount : ");
    					int amount = sc.nextInt();
    					account[i].deposit(amount);
    					Depositdone = true;
    				//If user enter wrong value.
    				}catch(InputMismatchException e) {
    					System.out.println("Please enter valid numerical ammount....");
    					sc.nextLine();
    				}catch (IllegalArgumentException e) {
                        System.out.println("Deposit Error: " + e.getMessage());
    			}
    		} 
    			//Withdraw Transaction
        		boolean Withdraw =false;
        		account[i].display();
        		
        		System.out.println("----------Withdraw-----------");
        		while (!Withdraw) {
        			//Getting deposit amount from user
        			try {
        				System.out.print("Enter you withdraw amount : ");
        				int amount=sc.nextInt();
        				//Calling function from bank system
        				account[i].withdraw(amount);
        				Withdraw = true;
        				//If value is invalid
        				
        			}catch(InputMismatchException e) {
        				System.out.println("Please enter valid withdraw amount....");
        				sc.nextLine();
        			}catch (IllegalArgumentException e) {
                        System.out.println("Withdrawal Error: " + e.getMessage());
                        }
        		}
        		
        		account[i].display();
        		System.out.println();
    	}
    		System.out.print("Thank for using banking system.....");
    		
    }
		
	
}


	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 


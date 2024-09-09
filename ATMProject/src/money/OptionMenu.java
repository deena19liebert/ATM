package money;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account{
	
	Scanner menuInput = new Scanner(System.in);

	
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException {
		int x = 1;
		 
		do {
			try {
			data.put(9876543, 9876);
			data.put(8989898, 1890);
			data.put(89345898, 1891);
			
			System.out.println("Welcome to the ATM!");
			System.out.println("Enter your Customer Number: ");
			setCustomerNumber(menuInput.nextInt());
			
			System.out.println("Enter your Pin Number: ");
			setPinNumber(menuInput.nextInt());
		} catch (Exception e) {
			System.out.println("\n" + "Oops! Enter a valid Number.");
			x = 2;
		}
		for(Entry<Integer, Integer> entry : data.entrySet()) {
			
			if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber() ) {
				getAccountType();
			}
		}
		System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
		} while (x == 1);
	}
	
	/* Display Account Type Menu with Selection */
	
	public void getAccountType() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("1 - Checking Account");
		System.out.println("2 - Saving Account");
		System.out.println("3 - Exit");
		System.out.println();
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
	   	case 3:
	   		System.out.println("Thank You for using this ATM. Have a great day!");
	   		break;
	   	default:
	   		System.out.println("\n" + "Invalid Choice." + "\n");
	   		getAccountType();
		}
	}
	
	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("1 - View Balance");
		System.out.println("2 - Withdraw Funds");
		System.out.println("3 - Deposit Funds");
		System.out.println("4 - Exit");
		System.out.println();
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			System.out.println("Check Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
	   	case 3:
	   		getCheckingDepositInput();
	   		getAccountType();
	   		break;
	   	case 4:
	   		System.out.println("Thank You for using this ATM. Have a great day!");
	   	default:
	   		System.out.println("\n" + "Invalid Choice." + "\n");
	   		getChecking();
		}
	}
	
	
	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("1 - View Balance");
		System.out.println("2 - Withdraw Funds");
		System.out.println("3 - Deposit Funds");
		System.out.println("4 - Exit");
		System.out.println();
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
	   	case 3:
	   		getSavingDepositInput();
	   		getAccountType();
	   		break;
	   	case 4:
	   		System.out.println("Thank You for using this ATM. Have a great day!");
	   	default:
	   		System.out.println("\n" + "Invalid Choice." + "\n");
	   		getSaving();
		}
	}
		
}

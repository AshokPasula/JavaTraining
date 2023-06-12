package task01;

import java.util.Scanner;

public class MultipleAccATM {

	private static final int MAX_COUNT = 100;

	private static int[] accNum = new int[MAX_COUNT];
	private static int[] pin = new int[MAX_COUNT];
	private static double[] blances = new double[MAX_COUNT];
	private static double[][] transactions = new double[MAX_COUNT][MAX_COUNT];
	private static int transactionCount = 0;
	private static int bankAccCount = 0;
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;

		while (!exit) {
			System.out.println("Welcome to the  Public Bank");
			System.out.println("1. Create new account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				createAccount(scanner);
				break;
			case 2:
				login(scanner);
				break;
			case 3:
				exit = true;
				System.out.print("Logged out Succesfully ");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();

		}
	}

	public static void createAccount(Scanner scanner) {
		if (bankAccCount >= MAX_COUNT) {
			System.out.println("Cannot add more books. Maximum limit reached.");
			return;
		}
		System.out.print("Enter Account Number: ");
		int accNumber = scanner.nextInt();
		System.out.print("Set pin to your account: ");
		int accPin = scanner.nextInt();
		System.out.print("Please deposit the initial ammount to your :$");
		double bal = scanner.nextDouble();

		accNum[bankAccCount] = accNumber;
		pin[bankAccCount] = accPin;
		blances[bankAccCount] = bal;
		transactions[bankAccCount][transactionCount] = bal;
		bankAccCount++;
		transactionCount++;
		
	}

	public static int findPinNum(int accPinNum) {
		for (int i = 0; i < bankAccCount; i++) {
			if (pin[i] == accPinNum) {
				return pin[i];
			}
		}
		return -1;
	}
	
	public static int findAccIndex(int accNumber) {
		for (int i = 0; i < bankAccCount; i++) {
			if (accNum[i] == accNumber) {
				return i;
			}
		}
		return -1;
	}

	public static int findAccNum(int accNumber) {
		for (int i = 0; i < bankAccCount; i++) {
			if (accNum[i] == accNumber) {
				return accNum[i];
			}
		}
		return -1;
	}

	public static double checkAccBal(int accNumber) {
		for (int i = 0; i < bankAccCount; i++) {
			if (accNum[i] == accNumber) {
					return blances[i];
			}
		}
		return -1;
	}
	
	public static void checkAvaliableBal(int accNumber) {
		System.out.println("\nAvalable blances :$"+checkAccBal(accNumber));
	}

	public static void login(Scanner scanner) {
		System.out.print("\nEnter the account number: ");
		int accountNumber = scanner.nextInt();
		if (accountNumber == findAccNum(accountNumber)) {
			System.out.print("Enter the pin number: ");
			int pin = scanner.nextInt();
			System.out.println();
			if (pin == findPinNum(pin)) {
				System.out.println("Logged in sucessfull");
				int choice;
				do {
					System.out.println("\nWelcome " + accountNumber);
					System.out.println("1. Check Balance");
					System.out.println("2. Deposit");
					System.out.println("3. Withdraw");
					System.out.println("4. View Transaction History");
					System.out.println("5. Logout");
					System.out.print("Choose an option: ");

					choice = scanner.nextInt();
					switch (choice) {
					case 1:
						checkAvaliableBal(accountNumber);
						break;
					case 2:
						deposit(accountNumber, scanner);
						break;
					case 3:
						withdraw(accountNumber, scanner);
						break;
					case 4:
						showTransactionHistory(accountNumber);
						break;
					case 5:
						System.out.println("Logged out sucessfully");
						break;
					default:
						System.out.println("Invalid option. Please try again.");
					}
					System.out.println();
				} while (choice != 5);
			} else {
				System.out.println("Pin is Invalid");
			}
		} else {
			System.out.println("Account number is Invalid");
		}
	}

	public static void deposit(int accountNum, Scanner scanner) {
		int indexNumber = findAccIndex(accountNum);
		System.out.print("\nEnter deposit amount:$ ");
		double amount = scanner.nextDouble();
            if(checkAccBal(accountNum)> 0) {
            	double depositAmount = checkAccBal(accountNum) + amount;
            	blances[indexNumber] = depositAmount;
			    transactions[indexNumber][transactionCount++] = amount;
			    System.out.println("Deposit successful!");
            }
		    else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public static void withdraw(int accountNum, Scanner scanner) {
		int indexNumber = findAccIndex(accountNum);
		System.out.print("\nEnter withdraw amount: $");
		double amount = scanner.nextDouble();
		if (amount > checkAccBal(accountNum)) {
			System.out.println("Insufficient balance.");
		} else if(amount < 0){
			System.out.println("Invalid withdrawal amount.");
		} else {
			double withdrawAmount = checkAccBal(accountNum) - amount;
        	blances[indexNumber] = withdrawAmount;
			transactions[indexNumber][transactionCount++] = -amount;
			System.out.println("withdraw successful!");
		}
	}
	public static void showTransactionHistory(int accountNum) {
		System.out.println("\nTransaction History:");
		int indexNumber = findAccIndex(accountNum);
			for (int i = 0; i < transactionCount; i++) {
				if(transactions[indexNumber][i]==0.0 || transactions[indexNumber][i]==-0.0) {
					continue;
				}
				else if (transactions[indexNumber][i] > 0) {
					System.out.println("Deposit: $" + transactions[indexNumber][i]);
				} else {
					System.out.println("Withdraw: $" + (-transactions[indexNumber][i]));
				}
			}
		}
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Account Class
    static class Account {
        int accountNumber;
        String name;
        String accountType;
        String phone;
        double balance;

        Account(int accountNumber, String name, String accountType,
                String phone, double balance) {

            this.accountNumber = accountNumber;
            this.name = name;
            this.accountType = accountType;
            this.phone = phone;
            this.balance = balance;
        }

        void displayAccount() {

            System.out.println("\n-----------------------------------");
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Account Holder : " + name);
            System.out.println("Account Type   : " + accountType);
            System.out.println("Phone Number   : " + phone);
            System.out.println("Balance        : ₹" + balance);
            System.out.println("-----------------------------------");
        }
    }

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("        ACCOUNT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Check Balance");
            System.out.println("7. Update Account");
            System.out.println("8. Delete Account");
            System.out.println("9. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    viewAccounts();
                    break;

                case 3:
                    searchAccount();
                    break;

                case 4:
                    depositMoney();
                    break;

                case 5:
                    withdrawMoney();
                    break;

                case 6:
                    checkBalance();
                    break;

                case 7:
                    updateAccount();
                    break;

                case 8:
                    deleteAccount();
                    break;

                case 9:
                    System.out.println("\nThank you for using Account Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
    }

    // Create Account
    static void createAccount() {

        System.out.println("\n---------- CREATE ACCOUNT ----------");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        // Check duplicate account number
        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {
                System.out.println("Account number already exists!");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Type (Savings/Current): ");
        String accountType = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Initial deposit cannot be negative!");
            return;
        }

        accounts.add(
            new Account(accountNumber, name, accountType, phone, balance)
        );

        System.out.println("\nAccount created successfully!");
    }

    // View All Accounts
    static void viewAccounts() {

        System.out.println("\n---------- ALL ACCOUNTS ----------");

        if (accounts.isEmpty()) {
            System.out.println("No account records found.");
            return;
        }

        for (Account account : accounts) {
            account.displayAccount();
        }
    }

    // Search Account
    static void searchAccount() {

        System.out.println("\n---------- SEARCH ACCOUNT ----------");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {

                System.out.println("\nAccount Found!");
                account.displayAccount();
                return;
            }
        }

        System.out.println("Account not found!");
    }

    // Deposit Money
    static void depositMoney() {

        System.out.println("\n---------- DEPOSIT MONEY ----------");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {

                System.out.print("Enter Amount to Deposit: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero!");
                    return;
                }

                account.balance += amount;

                System.out.println("\nMoney deposited successfully!");
                System.out.println("New Balance: ₹" + account.balance);
                return;
            }
        }

        System.out.println("Account not found!");
    }

    // Withdraw Money
    static void withdrawMoney() {

        System.out.println("\n---------- WITHDRAW MONEY ----------");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {

                System.out.print("Enter Amount to Withdraw: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero!");
                    return;
                }

                if (amount > account.balance) {
                    System.out.println("Insufficient balance!");
                    return;
                }

                account.balance -= amount;

                System.out.println("\nMoney withdrawn successfully!");
                System.out.println("Remaining Balance: ₹" + account.balance);
                return;
            }
        }

        System.out.println("Account not found!");
    }

    // Check Balance
    static void checkBalance() {

        System.out.println("\n---------- CHECK BALANCE ----------");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {

                System.out.println("\nAccount Holder: " + account.name);
                System.out.println("Current Balance: ₹" + account.balance);
                return;
            }
        }

        System.out.println("Account not found!");
    }

    // Update Account
    static void updateAccount() {

        System.out.println("\n---------- UPDATE ACCOUNT ----------");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {

                sc.nextLine();

                System.out.print("Enter New Account Holder Name: ");
                account.name = sc.nextLine();

                System.out.print("Enter New Account Type: ");
                account.accountType = sc.nextLine();

                System.out.print("Enter New Phone Number: ");
                account.phone = sc.nextLine();

                System.out.println("\nAccount updated successfully!");
                return;
            }
        }

        System.out.println("Account not found!");
    }

    // Delete Account
    static void deleteAccount() {

        System.out.println("\n---------- DELETE ACCOUNT ----------");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {

                accounts.remove(account);

                System.out.println("Account deleted successfully!");
                return;
            }
        }

        System.out.println("Account not found!");
    }
}
package com.company.multithreading.coding_exercises.synchornized;

class Bank{
    String accountHolderName;
    double balance;

    public Bank(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    synchronized  public void withdrawAmount(String withdrawalType, double withdrawAmount){
//        System.out.println("INITIAL BALANCE : "+balance);
        if(withdrawAmount<balance){
            System.out.println("-------------"+withdrawalType+"----------");
            System.out.println("("+ balance+" - "+withdrawAmount+")  : "+(balance-withdrawAmount));
            System.out.println(" Previous balance   : "+balance);
            System.out.println(" deducted Amount    : "+withdrawAmount);
            balance= balance- withdrawAmount;
            System.out.println(" New balance is     :"+balance);
        }else{
            System.out.println("No enough balance for Withdrawal :( "+withdrawalType);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    double getBalance(){
        return this.balance;
    }

}
class ChequeWithdrawal extends Thread {
    Bank bank;
    double withdrawalAmount;

    public ChequeWithdrawal(Bank bank, double withdrawalAmount) {
        this.bank = bank;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        bank.withdrawAmount("Cheque Withdrawal",withdrawalAmount);
    }
}
class ATMWithdrawal extends  Thread{

    Bank bank;
    double withdrawalAmount;

    public ATMWithdrawal(Bank bank, double withdrawalAmount) {
        this.bank = bank;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        bank.withdrawAmount("ATM Withdrawal", withdrawalAmount);
    }
}

class Shopping extends Thread{
    Bank bank;
    double withdrawalAmount;

    public Shopping(Bank bank, double withdrawalAmount) {
        this.bank = bank;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        bank.withdrawAmount("Shopping",withdrawalAmount);
    }
}

public class BankAccountSychronized {
    public static void main(String[] args) {
        Bank bank= new Bank("Ashmeet", 10000);

        ChequeWithdrawal chequeWithdrawal= new ChequeWithdrawal(bank, 5000); //12
        ATMWithdrawal atmWithdrawal= new ATMWithdrawal(bank, 3000); //12
        Shopping shopping= new Shopping(bank, 4000); //12

        chequeWithdrawal.start();
        atmWithdrawal.start();
        shopping.start();

        try {
            chequeWithdrawal.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Balance : "+bank.getBalance());

    }
}

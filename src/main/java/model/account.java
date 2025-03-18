/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dev khatri
 */
public class account {
  private int accountId;
  private long accountNumber;
  private int pin;
  private int balance;
  private int accountHolderId;

    public int getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(int accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
  
  private String accountHolderName;
   public void setaccountHolderName(String accountHolderName){
       this.accountHolderName = accountHolderName;
   }  
  
   public String getaccountHolderName(){
       return accountHolderName;
   }
   
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }  
    public boolean isWithdrawable(int balance, int amountToWithdraw){
        if(balance >= amountToWithdraw) return true;
        else return false;
    }
    public boolean isTransable(int balance,int ammountToTransfer){
        if(balance >= ammountToTransfer) return true;
        else return false;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dev khatri
 */
public class Transaction {
    private int transcationId;
    private long Sender_Accountno;
    private int amount;
    private String transaction_Type;
    private long receiver_Accountno;
    private String transcation_date;

    public String getTranscation_date() {
        return transcation_date;
    }

    public void setTranscation_date(String transcation_date) {
        this.transcation_date = transcation_date;
    }

    public int getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(int transcationId) {
        this.transcationId = transcationId;
    }

    public long getSender_Accountno() {
        return Sender_Accountno;
    }

    public void setSender_Accountno(long Sender_Accountno) {
        this.Sender_Accountno = Sender_Accountno;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransaction_Type() {
        return transaction_Type;
    }

    public void setTransaction_Type(String transaction_Type) {
        this.transaction_Type = transaction_Type;
    }

    public long getReceiver_Accountno() {
        return receiver_Accountno;
    }

    public void setReceiver_Accountno(long receiver_Accountno) {
        this.receiver_Accountno = receiver_Accountno;
    }
    
}

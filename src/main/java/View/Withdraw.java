/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.TransactionHandler;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.account;
import model.user;

/**
 *
 * @author Dev khatri
 */
public class Withdraw extends javax.swing.JFrame {
    private user User;
    private account Account;
    private JLabel balancelbl;
    /**
     * Creates new form Withdraw
     */
    public Withdraw() {
        initComponents();
    }
 
    public Withdraw(account account,JLabel balancelbl){
        this.balancelbl = balancelbl;
        this.Account = account;
        initComponents();
        setLocationRelativeTo(null);
        currentBalance.setText(Integer.toString(Account.getBalance()) + "  " + "PKR");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        currentbalanceLbL = new javax.swing.JLabel();
        currentBalance = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        withdraw_btn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Withdraw");

        currentbalanceLbL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        currentbalanceLbL.setText("Current balance : ");

        currentBalance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        currentBalance.setText("5600 PKR");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Amount : ");

        amountField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                getInputAmount_OnKeypress(evt);
            }
        });

        withdraw_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        withdraw_btn.setText("Withdraw");
        withdraw_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdraw_btnActionPerformed(evt);
            }
        });

        returnBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnBtn.setText("Return to main page");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentbalanceLbL, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(currentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(returnBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(withdraw_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(amountField))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentbalanceLbL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(withdraw_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getInputAmount_OnKeypress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_getInputAmount_OnKeypress
        // TODO add your handling code here:
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' ||  evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) amountField.setEditable(true);
        else amountField.setEditable(false);
    }//GEN-LAST:event_getInputAmount_OnKeypress

    private void withdraw_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdraw_btnActionPerformed
        // TODO add your handling code here:
        TransactionHandler transactionHandler = new TransactionHandler();
        int AmountToWithDraw = Integer.parseInt(amountField.getText());
        String result = transactionHandler.withDraw(Account,AmountToWithDraw);
        if(result.equals("You have insufficient balance in your account")){
            JOptionPane.showMessageDialog(this, result);
       }else{
            currentBalance.setText(Integer.toString(Account.getBalance()) + "  " + "PKR");
            balancelbl.setText(Integer.toString(Account.getBalance()) + "  " + "PKR");
        }
    }//GEN-LAST:event_withdraw_btnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_returnBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel currentBalance;
    private javax.swing.JLabel currentbalanceLbL;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton withdraw_btn;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.AccountController;
import Controller.UserController;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import model.account;
import model.user;

/**
 *
 * @author Dev khatri
 */
public class Home extends javax.swing.JFrame {
  
    private AccountController AccountController;
    private UserController AuthController;
    private user User;
    private account Account;
    /**
     * Creates new form Home
     */
    public Home() {
        this.AccountController = new AccountController();
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public Home(user user,account account){
        this.User = user;
        this.Account = account;
        this.AccountController = new AccountController();
        this.AuthController = new UserController();
        initComponents();
        showAccountDetails();
        setLocationRelativeTo(null);
    }
    
       private void showAccountDetails(){
        jLabel1.setText(User.getName());
        userAccountno.setText(Long.toString(Account.getAccountNumber()).substring(0,3) + "******" + Long.toString(Account.getAccountNumber()).substring(9));
        balance.setText(Integer.toString(Account.getBalance()) + " " + "PKR");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userbalancelbl = new javax.swing.JPanel();
        namelbl = new javax.swing.JLabel();
        accountnolbl = new javax.swing.JLabel();
        userAccountno = new javax.swing.JLabel();
        balanceLbl = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        withdrawBtn = new javax.swing.JButton();
        depositBtn = new javax.swing.JButton();
        TransferBtn = new javax.swing.JButton();
        TranscationBtn = new javax.swing.JButton();
        changepinBtn = new javax.swing.JButton();
        updatePhone = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        namelbl.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        namelbl.setText("Name : ");

        accountnolbl.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        accountnolbl.setText(" Account no :");

        userAccountno.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        userAccountno.setText("573495809");

        balanceLbl.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        balanceLbl.setText("Balance :");

        balance.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        balance.setText("50000");

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel1.setText("Dev khatri");

        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        userbalancelbl.setBorder(border);

        javax.swing.GroupLayout userbalancelblLayout = new javax.swing.GroupLayout(userbalancelbl);
        userbalancelbl.setLayout(userbalancelblLayout);
        userbalancelblLayout.setHorizontalGroup(
            userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userbalancelblLayout.createSequentialGroup()
                .addGroup(userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userbalancelblLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(balanceLbl)
                        .addGap(40, 40, 40)
                        .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(userbalancelblLayout.createSequentialGroup()
                        .addGroup(userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userbalancelblLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userbalancelblLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(accountnolbl)
                                .addGap(18, 18, 18)))
                        .addGroup(userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userAccountno, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        userbalancelblLayout.setVerticalGroup(
            userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userbalancelblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namelbl)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountnolbl)
                    .addComponent(userAccountno))
                .addGap(18, 18, 18)
                .addGroup(userbalancelblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceLbl)
                    .addComponent(balance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        withdrawBtn.setText("Withdraw");
        withdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBtnActionPerformed(evt);
            }
        });

        depositBtn.setText("Deposit");
        depositBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositBtnActionPerformed(evt);
            }
        });

        TransferBtn.setText("Transfer");
        TransferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferBtnActionPerformed(evt);
            }
        });

        TranscationBtn.setText("Transcation History");
        TranscationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TranscationBtnActionPerformed(evt);
            }
        });

        changepinBtn.setText("Update Email");
        changepinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepinBtnActionPerformed(evt);
            }
        });

        updatePhone.setText("Update phone number");
        updatePhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePhoneActionPerformed(evt);
            }
        });

        jButton1.setText("Update Address");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(userbalancelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changepinBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(TransferBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(withdrawBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(updatePhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(TranscationBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(depositBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userbalancelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(withdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TransferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TranscationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changepinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TranscationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TranscationBtnActionPerformed
        // TODO add your handling code here:
        new transactionsHistory(Account).setVisible(true);
    }//GEN-LAST:event_TranscationBtnActionPerformed

    private void withdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBtnActionPerformed
        // TODO add your handling code here:
        new Withdraw(Account,balance).setVisible(true);
    }//GEN-LAST:event_withdrawBtnActionPerformed

    private void depositBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositBtnActionPerformed
        // TODO add your handling code here:
        new Deposit(User,Account,balance).setVisible(true);
    }//GEN-LAST:event_depositBtnActionPerformed

    private void TransferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferBtnActionPerformed
        // TODO add your handling code here:
        new Transfer(Account,balance).setVisible(true);
    }//GEN-LAST:event_TransferBtnActionPerformed

    private void changepinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepinBtnActionPerformed
        // TODO add your handling code here:
        new updateData(User,"Email").setVisible(true);
    }//GEN-LAST:event_changepinBtnActionPerformed

    private void updatePhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePhoneActionPerformed
        // TODO add your handling code here:
        new updateData(User, "Phone").setVisible(true);
    }//GEN-LAST:event_updatePhoneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new updateData(User, "Address").setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        User = null;
        Account = null;
        this.dispose();
        new LoginPage();
    }//GEN-LAST:event_exitBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TranscationBtn;
    private javax.swing.JButton TransferBtn;
    private javax.swing.JLabel accountnolbl;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel balanceLbl;
    private javax.swing.JButton changepinBtn;
    private javax.swing.JButton depositBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel namelbl;
    private javax.swing.JButton updatePhone;
    private javax.swing.JLabel userAccountno;
    private javax.swing.JPanel userbalancelbl;
    private javax.swing.JButton withdrawBtn;
    // End of variables declaration//GEN-END:variables
}

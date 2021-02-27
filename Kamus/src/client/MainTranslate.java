/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.controller.AppLogin;
import client.controller.AppUser;
import interfaces.historyinterface;
import interfaces.userinterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.History;
import models.User;

/**
 *
 * @author iqbalfauzi
 */
public class MainTranslate extends javax.swing.JFrame {

    /**
     * Creates new form MainTranslate
     */
    
    private AppUser userControl = new AppUser();
    public MainTranslate(String user) throws NotBoundException, MalformedURLException, RemoteException {
        initComponents();
        userControl.CheckUserRemote();
        userControl.CheckHistoryRemote();
//        AppLogin appLogin = new AppLogin();
//        uice = appLogin.uice;
//        hice = appLogin.hice;
//        this.userName = user;
//        this.uice = uice;
        Load(userControl.AllHistory(user));
        SetUserField(userControl.UserInfo(user));
    }
    
    private void Load(List<History> histories) {
        String header[] = {"ID", "FROM", "TO", "MESSAGE","RESULT", "USERNAME", "DATETIME"};
        String[][] data = new String[histories.size()][7];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = String.valueOf(histories.get(i).getId());
            data[i][1] = histories.get(i).getLanguage_id_from();
            data[i][2] = histories.get(i).getLanguage_id_to();
            data[i][3] = histories.get(i).getMessage_from();
            data[i][4] = histories.get(i).getMessage_to();
            data[i][5] = histories.get(i).getUser();
            data[i][6] = histories.get(i).getDatetime();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, header);
        tabel_history.setModel(defaultTableModel);
    }
    
    private void SetUserField(User user) throws RemoteException {
        view_user.setText(user.getUsername());
        edit_nama.setText(user.getNama());
        edit_email.setText(user.getEmail());
        edit_username.setText(user.getUsername());
        edit_bio.setText(user.getBio());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        history_view = new javax.swing.JButton();
        translate_view = new javax.swing.JButton();
        view_user = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        panel_content = new javax.swing.JPanel();
        unit_translate = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_bahasa_tujuan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_bahasa_dari = new javax.swing.JTextArea();
        reverse = new javax.swing.JButton();
        combo_bahasa_dari = new javax.swing.JComboBox<>();
        comba_bahasa_tujuan = new javax.swing.JComboBox<>();
        translate_button = new javax.swing.JButton();
        unit_history = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_history = new javax.swing.JTable();
        unit_user = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edit_nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edit_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        edit_bio = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        edit_username = new javax.swing.JTextField();
        save_user = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(82, 173, 162));

        history_view.setText("History");
        history_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                history_viewActionPerformed(evt);
            }
        });

        translate_view.setText("Translate");
        translate_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translate_viewActionPerformed(evt);
            }
        });

        view_user.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        view_user.setText("User");

        logout.setText("Logout");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(history_view, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(translate_view, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(view_user)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(view_user)
                .addGap(109, 109, 109)
                .addComponent(translate_view, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(history_view, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(29, 29, 29))
        );

        panel_content.setBackground(new java.awt.Color(255, 255, 255));
        panel_content.setLayout(new java.awt.CardLayout());

        unit_translate.setBackground(new java.awt.Color(255, 255, 255));

        area_bahasa_tujuan.setEditable(false);
        area_bahasa_tujuan.setColumns(20);
        area_bahasa_tujuan.setRows(5);
        jScrollPane1.setViewportView(area_bahasa_tujuan);

        area_bahasa_dari.setColumns(20);
        area_bahasa_dari.setRows(5);
        jScrollPane2.setViewportView(area_bahasa_dari);

        reverse.setText("<>");

        combo_bahasa_dari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comba_bahasa_tujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        translate_button.setText(">>");

        javax.swing.GroupLayout unit_translateLayout = new javax.swing.GroupLayout(unit_translate);
        unit_translate.setLayout(unit_translateLayout);
        unit_translateLayout.setHorizontalGroup(
            unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_translateLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_bahasa_dari, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addComponent(reverse)
                        .addGap(82, 82, 82)
                        .addComponent(comba_bahasa_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addComponent(translate_button)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        unit_translateLayout.setVerticalGroup(
            unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, unit_translateLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_bahasa_dari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reverse)
                    .addComponent(comba_bahasa_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(translate_button)))
                .addGap(69, 69, 69))
        );

        panel_content.add(unit_translate, "card2");

        unit_history.setBackground(new java.awt.Color(255, 255, 255));

        tabel_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabel_history);

        javax.swing.GroupLayout unit_historyLayout = new javax.swing.GroupLayout(unit_history);
        unit_history.setLayout(unit_historyLayout);
        unit_historyLayout.setHorizontalGroup(
            unit_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_historyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        unit_historyLayout.setVerticalGroup(
            unit_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_historyLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panel_content.add(unit_history, "card3");

        unit_user.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("User Information");

        jLabel3.setText("Full Name");

        jLabel4.setText("Email");

        jLabel5.setText("Bio");

        edit_bio.setColumns(20);
        edit_bio.setRows(5);
        jScrollPane4.setViewportView(edit_bio);

        jLabel6.setText("jLabel6");

        edit_username.setEditable(false);

        save_user.setText("Save");

        javax.swing.GroupLayout unit_userLayout = new javax.swing.GroupLayout(unit_user);
        unit_user.setLayout(unit_userLayout);
        unit_userLayout.setHorizontalGroup(
            unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_userLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(unit_userLayout.createSequentialGroup()
                        .addComponent(save_user)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(unit_userLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(unit_userLayout.createSequentialGroup()
                        .addGroup(unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(edit_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(edit_email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(edit_username)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                        .addGap(60, 60, 60))))
        );
        unit_userLayout.setVerticalGroup(
            unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_userLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addGroup(unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(unit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(unit_userLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(unit_userLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(save_user)
                .addGap(54, 54, 54))
        );

        panel_content.add(unit_user, "card4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_content, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(panel_content, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void translate_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translate_viewActionPerformed
        // TODO add your handling code here:
        panel_content.removeAll();
        panel_content.repaint();
        panel_content.revalidate();
        
        panel_content.add(unit_translate);
        panel_content.repaint();
        panel_content.revalidate();
    }//GEN-LAST:event_translate_viewActionPerformed

    private void history_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_viewActionPerformed
        // TODO add your handling code here:
        panel_content.removeAll();
        panel_content.repaint();
        panel_content.revalidate();
        
        panel_content.add(unit_history);
        panel_content.repaint();
        panel_content.revalidate();
    }//GEN-LAST:event_history_viewActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainTranslate().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_bahasa_dari;
    private javax.swing.JTextArea area_bahasa_tujuan;
    private javax.swing.JComboBox<String> comba_bahasa_tujuan;
    private javax.swing.JComboBox<String> combo_bahasa_dari;
    private javax.swing.JTextArea edit_bio;
    private javax.swing.JTextField edit_email;
    private javax.swing.JTextField edit_nama;
    private javax.swing.JTextField edit_username;
    private javax.swing.JButton history_view;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logout;
    private javax.swing.JPanel panel_content;
    private javax.swing.JButton reverse;
    private javax.swing.JButton save_user;
    private javax.swing.JTable tabel_history;
    private javax.swing.JButton translate_button;
    private javax.swing.JButton translate_view;
    private javax.swing.JPanel unit_history;
    private javax.swing.JPanel unit_translate;
    private javax.swing.JPanel unit_user;
    private javax.swing.JLabel view_user;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.controller.AppUser;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.History;
import models.Translata;
import models.User;

/**
 *
 * @author iqbalfauzi
 */
public class MainTranslate extends javax.swing.JFrame {

    /**
     * Creates new form MainTranslate
     */
    private boolean reverseBahasa = true;
    private User userInfo;
    private AppUser userControl = null;
    
    public MainTranslate(String user) throws NotBoundException, MalformedURLException, RemoteException {
        initComponents();
        setLocationRelativeTo(null);
        userControl = AppUser.getappuser();
        userInfo = userControl.UserInfo(user);
        SetUserField(userInfo);
        
    }
    
    private void revere() {
        String temp = "";
        temp = text_dari.getText();
        text_dari.setText(text_tujuan.getText());
        text_tujuan.setText(temp);
        reverseBahasa = !reverseBahasa;
    }
    
    private void Translate() throws RemoteException{
        List<Translata> result = userControl.TextTranslate(area_bahasa_asal.getText());
        String show = "";
        String historySave = "";
        String showRelated = "";
        if (result.size() >= 1) {
            historySave = result.get(0).getSpain();
            for (int i=0; i<result.size(); i+=1) {
                if(i<result.size()-1) {
                    show += result.get(i).getSpain();
                    show += ",\n";
                    showRelated += result.get(i).getEn();
                    showRelated += ",\n";
                } else {
                    show += result.get(i).getSpain();
                    showRelated += result.get(i).getEn();
                }
            }
        } else {
            historySave = "Data not found!";
            show = "Data not found!";
            showRelated = "No relateble word!";
        }
        area_relateble.setText(showRelated);
        area_bahasa_tujuan.setText(show);
        
        AddToHistory(historySave);
    }
    
    public void AddToHistory(String result) throws RemoteException {
        History history = new History(
                text_dari.getText(), text_tujuan.getText(), area_bahasa_asal.getText(), result, userInfo.getUsername());
        userControl.AddHistory(history);
    }
    
    private void TranslateReverse() throws RemoteException {
        List<Translata> result = userControl.TextTranslateReverse(area_bahasa_asal.getText());
        String show = "";
        String historySave = "";
        String showRelated = "";
        if (result.size() >= 1) {
            historySave = result.get(0).getSpain();
            for (int i=0; i<result.size(); i+=1) {
                if(i<result.size()-1) {
                    show += result.get(i).getSpain();
                    show += ",\n";
                    showRelated += result.get(i).getEn();
                    showRelated += ",\n";
                } else {
                    show += result.get(i).getSpain();
                    showRelated += result.get(i).getEn();
                }
            }
        } else {
            historySave = "Data not found!";
            show = "Data not found!";
            showRelated = "No relateble word!";
        }
        area_relateble.setText(show);
        area_bahasa_tujuan.setText(showRelated);
        
        AddToHistory(historySave);
    }
    
    private void Load(List<History> histories) {
        System.out.println("HISTORYY"+ histories);
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
        user_name.setText(user.getNama());
        view_user.setText(user.getUsername()+" Info");
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

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        history_view = new javax.swing.JButton();
        translate_view = new javax.swing.JButton();
        view_user = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        panel_content = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unit_translate = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_bahasa_tujuan = new javax.swing.JTextArea();
        translate_button = new javax.swing.JButton();
        text_dari = new javax.swing.JLabel();
        text_tujuan = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        area_relateble = new javax.swing.JTextArea();
        invert_bahasa = new javax.swing.JButton();
        area_bahasa_asal = new javax.swing.JTextField();
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

        jTextField1.setText("jTextField1");

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

        view_user.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        view_user.setForeground(new java.awt.Color(255, 255, 255));
        view_user.setText("User info");
        view_user.setToolTipText("User information");
        view_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_userMouseClicked(evt);
            }
        });

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout)
                    .addComponent(view_user))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(view_user)
                .addGap(102, 102, 102)
                .addComponent(translate_view, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(history_view, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(29, 29, 29))
        );

        panel_content.setBackground(new java.awt.Color(255, 255, 255));
        panel_content.setLayout(new java.awt.CardLayout());

        jLabel7.setFont(new java.awt.Font("Hack", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(82, 173, 162));
        jLabel7.setText("Welcome home");

        user_name.setFont(new java.awt.Font("Hack", 1, 36)); // NOI18N
        user_name.setForeground(new java.awt.Color(82, 173, 162));
        user_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_name.setText("name");

        jLabel9.setFont(new java.awt.Font("Hack", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(82, 173, 162));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("......................");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(user_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        panel_content.add(jPanel3, "card5");

        unit_translate.setBackground(new java.awt.Color(255, 255, 255));

        area_bahasa_tujuan.setEditable(false);
        area_bahasa_tujuan.setColumns(20);
        area_bahasa_tujuan.setRows(5);
        jScrollPane1.setViewportView(area_bahasa_tujuan);

        translate_button.setText(">>");
        translate_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translate_buttonActionPerformed(evt);
            }
        });

        text_dari.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_dari.setText("English");

        text_tujuan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_tujuan.setText("Spain");

        jLabel8.setText("Related word");

        area_relateble.setEditable(false);
        area_relateble.setColumns(20);
        area_relateble.setRows(5);
        jScrollPane5.setViewportView(area_relateble);

        invert_bahasa.setText("<->");
        invert_bahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invert_bahasaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout unit_translateLayout = new javax.swing.GroupLayout(unit_translate);
        unit_translate.setLayout(unit_translateLayout);
        unit_translateLayout.setHorizontalGroup(
            unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_translateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(area_bahasa_asal, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, unit_translateLayout.createSequentialGroup()
                                .addComponent(text_dari)
                                .addGap(22, 22, 22)))
                        .addGap(26, 26, 26)
                        .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(translate_button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invert_bahasa))))
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(text_tujuan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        unit_translateLayout.setVerticalGroup(
            unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_translateLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_tujuan)
                    .addComponent(invert_bahasa)
                    .addComponent(text_dari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(unit_translateLayout.createSequentialGroup()
                        .addGroup(unit_translateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(area_bahasa_asal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(translate_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addGap(48, 48, 48))
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

        jLabel6.setText("Username");

        edit_username.setEditable(false);

        save_user.setText("Save");
        save_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_userActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(save_user)
                .addGap(29, 29, 29))
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

        panel_content.removeAll();
        panel_content.repaint();
        panel_content.revalidate();
        
        panel_content.add(unit_translate);
        panel_content.repaint();
        panel_content.revalidate();
    }//GEN-LAST:event_translate_viewActionPerformed

    private void history_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_viewActionPerformed

        panel_content.removeAll();
        panel_content.repaint();
        panel_content.revalidate();
        
        try {
            Load(userControl.AllHistory(userInfo.getUsername()));
        } catch (RemoteException ex) {
            Logger.getLogger(MainTranslate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        panel_content.add(unit_history);
        panel_content.repaint();
        panel_content.revalidate();
    }//GEN-LAST:event_history_viewActionPerformed

    private void translate_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translate_buttonActionPerformed
        try {
            if(reverseBahasa){
                Translate();
            } else {
                TranslateReverse();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MainTranslate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_translate_buttonActionPerformed

    private void invert_bahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invert_bahasaActionPerformed
        revere();
    }//GEN-LAST:event_invert_bahasaActionPerformed

    private void view_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_userMouseClicked
        panel_content.removeAll();
        panel_content.repaint();
        panel_content.revalidate();
        
        panel_content.add(unit_user);
        panel_content.repaint();
        panel_content.revalidate();
    }//GEN-LAST:event_view_userMouseClicked

    private void save_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_userActionPerformed
        userInfo.setBio(edit_bio.getText());
        userInfo.setEmail(edit_email.getText());
        userInfo.setNama(edit_nama.getText());
        try {
            if(userControl.UserUpdate(userInfo)){
                JOptionPane.showMessageDialog(this, "Update successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Update faill");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MainTranslate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_save_userActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
////        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
////        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
////         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
////         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(MainTranslate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new MainTranslate("jessifebria").setVisible(true);
//                } catch (NotBoundException ex) {
//                    Logger.getLogger(MainTranslate.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (MalformedURLException ex) {
//                    Logger.getLogger(MainTranslate.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (RemoteException ex) {
//                    Logger.getLogger(MainTranslate.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField area_bahasa_asal;
    private javax.swing.JTextArea area_bahasa_tujuan;
    private javax.swing.JTextArea area_relateble;
    private javax.swing.JTextArea edit_bio;
    private javax.swing.JTextField edit_email;
    private javax.swing.JTextField edit_nama;
    private javax.swing.JTextField edit_username;
    private javax.swing.JButton history_view;
    private javax.swing.JButton invert_bahasa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logout;
    private javax.swing.JPanel panel_content;
    private javax.swing.JButton save_user;
    private javax.swing.JTable tabel_history;
    private javax.swing.JLabel text_dari;
    private javax.swing.JLabel text_tujuan;
    private javax.swing.JButton translate_button;
    private javax.swing.JButton translate_view;
    private javax.swing.JPanel unit_history;
    private javax.swing.JPanel unit_translate;
    private javax.swing.JPanel unit_user;
    private javax.swing.JLabel user_name;
    private javax.swing.JLabel view_user;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chat;

import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import fileTranfer.FileTransfer;
/**
 *
 * @author THIS PC
 */
public class FrChatClient extends javax.swing.JFrame implements Runnable {
    Socket socket;
    DataOutputStream output;
    DataInputStream input;
    DefaultListModel model; 
    private boolean isConnected = false;
    private File fileToSend;
    /**
     * Creates new form FrChatClient
     */
    public FrChatClient() {
        initComponents();
        setTitleIconImage();
        model = new DefaultListModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPort = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnStop = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsHistory = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        btnSendFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        txtPort.setText("8888");
        txtPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPortActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("PORT NO.");

        btnStop.setText("STOP");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CLIENT");

        jScrollPane1.setViewportView(lsHistory);

        txtMessage.setColumns(20);
        txtMessage.setRows(1);
        jScrollPane2.setViewportView(txtMessage);

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send_32px.png"))); // NOI18N
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnSendFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attachment.png"))); // NOI18N
        btnSendFile.setName("btnShareFile"); // NOI18N
        btnSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStop)
                    .addComponent(jLabel1)
                    .addComponent(btnStart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSendFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPortActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        try {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
        if (input != null) {
            input.close();
        }
        if (output != null) {
            output.close();
        }
        isConnected = false;
        model.addElement("Disconnected...");
        lsHistory.setModel(model);

        btnStart.setEnabled(true);
        txtPort.setEnabled(true);
        btnSend.setEnabled(false);
        btnStop.setEnabled(false);
    } catch (Exception e) {
        model.addElement("Error stopping client: " + e.getMessage());
    }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String  formattedDate = currentTime.format(formatter);
            
            String message = txtMessage.getText();
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("(" + formattedDate + "): " + message);
            output.flush();

            model.addElement("You (" + formattedDate + "): " + message);
            lsHistory.setModel(model);
            
            txtMessage.setText("");
        } catch (Exception e) {
            model.addElement("Error when sending message: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            if(isConnected){
                model.addElement("Client is connecting ...");
                return;
            }
            
            int port = Integer.parseInt(txtPort.getText().trim());
            model.addElement("Connecting to server " + port + "...");
            lsHistory.setModel(model);
            
            socket = new Socket("localhost", port);
            isConnected = true;
            
            btnStart.setEnabled(false);
            txtPort.setEnabled(false);
            btnSend.setEnabled(true);
            btnStop.setEnabled(true);
            
            model.addElement("Connected to Server!");
            lsHistory.setModel(model);
            Thread t = new Thread(FrChatClient.this);
            t.start();
        } catch(NumberFormatException e){
            model.addElement("Invalid port number!");
        }
        catch (Exception e) {
            model.addElement("Connection error: " + e.getMessage());
            isConnected = false;
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file to send");
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileToSend = fileChooser.getSelectedFile();
            try {
                if(output == null){
                    output = new DataOutputStream(socket.getOutputStream());
                }
                FileTransfer.sendFile(output, fileToSend);
                model.addElement("You sent a file: " + fileToSend.getName());
                lsHistory.setModel(model);
            } catch (Exception e) {
                model.addElement("Error sending file: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSendFileActionPerformed

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
            java.util.logging.Logger.getLogger(FrChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrChatClient client = new FrChatClient();
                client.setVisible(true);
                client.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSendFile;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lsHistory;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            input = new DataInputStream(socket.getInputStream());
            while (true) {
                if (socket != null && !socket.isClosed()) {
                    String message = input.readUTF();
                    if ("Server has disconnected...".equals(message)) {
                        model.addElement("Disconnected from server...");
                        lsHistory.setModel(model);
                        socket.close();
                        break;
                    }

                    if ("IS SHARING FILE...".equals(message)) {
                        model.addElement("Server " + message);
                        lsHistory.setModel(model);
                    
                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Do you want to download this file?", "Send File",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (confirm == JOptionPane.YES_OPTION) {
                            JFileChooser directoryChooser = new JFileChooser();
                            directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                            if (directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                FileTransfer.receiveFile(input, directoryChooser.getSelectedFile().getAbsolutePath());
                                model.addElement("File received successfully.");
                            }
                            else {
                                model.addElement("File transfer cancelled.");
                                
                                input.readUTF();
                                long size = input.readLong();
                                while (size > 0) {
                                    long skipped = input.skip(size);
                                    size -= skipped;
                                }
                            }
                        }
                        else {
                           model.addElement("File transfer cancelled.");
                           input.readUTF();
                           long size = input.readLong();
                            while (size > 0) {
                                long skipped = input.skip(size);
                                size -= skipped;
                            }
                        } 
                        lsHistory.setModel(model);
                        continue;
                    }
                    model.addElement("Server " + message);
                    lsHistory.setModel(model);
                }
            }
        } catch (Exception e) {
            model.addElement("Connection error: " + e.getMessage());
            lsHistory.setModel(model);
        }
    }

    private void setTitleIconImage() {
        URL imageURL = getClass().getResource("/images/user_16px.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
    }
}

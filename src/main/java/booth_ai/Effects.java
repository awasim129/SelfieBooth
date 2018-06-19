/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booth_ai;

import static booth_ai.FullScreen.graphicsDevice;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author xterminate
 */
public class Effects extends javax.swing.JFrame {

    /**
     * Creates new form Effects
     */
    public Effects() {
        initComponents();
        FullScreen.show();
        graphicsDevice.setFullScreenWindow(this);
       // jLabel2.setSize(FullScreen.screenSize);
        imgLoader();
        
       jLabel1.setSize(FullScreen.screenSize);
        System.out.println(System.getenv("GMAIL_USER"));
        
       }
    
    public void imgLoader() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/xterminate/project/output/Image.jpg"));
            } catch (IOException e) {
                    e.printStackTrace();
                                    }
        Image dimg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),
        Image.SCALE_SMOOTH);

        ImageIcon imgThisImg = new ImageIcon(dimg);
        jLabel1.setIcon(imgThisImg);
      //  jLabel1.setLocation(500, 500);
    }
    
    
    public void usbcopy() {
        String[] env = {"PATH=/bin:/usr/bin/"};
        String cmd = "sudo /home/xterminate/project/testing/usbcpy.sh";  //e.g test.sh -dparam1 -oout.txt
        try {
            Process process = Runtime.getRuntime().exec(cmd, env);
        } catch (IOException ex) {
            Logger.getLogger(Effects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void emailservice() {
        JFrame frame = new JFrame("Please Provide your Email");
        String email = JOptionPane.showInputDialog(frame, "What's your Email?");
        SendEmailWithAttachment.sendmail(email);
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        applyeffect = new javax.swing.JButton();
        usbcpy = new javax.swing.JButton();
        email = new javax.swing.JButton();
        mm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(15, 20));
        setMinimumSize(new java.awt.Dimension(1275, 1020));
        getContentPane().setLayout(null);

        jLabel1.setAlignmentY(0.0F);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 20, 630, 450);

        applyeffect.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        applyeffect.setText("Add Effects");
        applyeffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyeffectActionPerformed(evt);
            }
        });
        getContentPane().add(applyeffect);
        applyeffect.setBounds(390, 790, 210, 65);

        usbcpy.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        usbcpy.setText("Copy to USB");
        usbcpy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usbcpyActionPerformed(evt);
            }
        });
        getContentPane().add(usbcpy);
        usbcpy.setBounds(710, 790, 220, 65);

        email.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        email.setText("Email Picture");
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email);
        email.setBounds(390, 870, 210, 65);

        mm.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        mm.setText("Main Menu");
        mm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmActionPerformed(evt);
            }
        });
        getContentPane().add(mm);
        mm.setBounds(710, 870, 220, 65);

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/xterminate/project/testing/SelfieBooth/media/perform.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1270, 1010);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        emailservice();
    }//GEN-LAST:event_emailActionPerformed

    private void usbcpyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usbcpyActionPerformed
        usbcopy();
    }//GEN-LAST:event_usbcpyActionPerformed

    private void applyeffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyeffectActionPerformed
        this.setVisible(false);
        new EffectsApply().setVisible(true);
    }//GEN-LAST:event_applyeffectActionPerformed

    private void mmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmActionPerformed
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_mmActionPerformed

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
            java.util.logging.Logger.getLogger(Effects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Effects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Effects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Effects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Effects().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyeffect;
    private javax.swing.JButton email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton mm;
    private javax.swing.JButton usbcpy;
    // End of variables declaration//GEN-END:variables
}

/*
 * Copyright (C) 2018 xterminate
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package booth_ai;

import static booth_ai.FullScreen.graphicsDevice;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author xterminate
 */
public class MainMenu extends javax.swing.JFrame {

    public static String cascade;
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
       FullScreen.show();
       graphicsDevice.setFullScreenWindow(this);
       jLabel1.setSize(FullScreen.screenSize);
    }
   /* public void imgLoader() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/xterminate/project/testing/SelfieBooth/media/face-recognition.png"));
            } catch (IOException e) {
                    e.printStackTrace();
                                    }
        Image dimg = img.getScaledInstance(jButton2.getWidth()+300, jButton2.getHeight()+300,
        Image.SCALE_SMOOTH);

        ImageIcon imgThisImg = new ImageIcon(dimg);
        jButton2.setIcon(imgThisImg);
      //  jLabel1.setLocation(500, 500);
    }
public void imgLoader2() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/xterminate/project/testing/SelfieBooth/media/Smile-recognition.png"));
            } catch (IOException e) {
                    e.printStackTrace();
                                    }
        Image dimg = img.getScaledInstance(jButton3.getWidth()+300, jButton3.getHeight()+300,
        Image.SCALE_SMOOTH);

        ImageIcon imgThisImg = new ImageIcon(dimg);
        jButton3.setIcon(imgThisImg);
      //  jLabel1.setLocation(500, 500);
    } */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jButton2.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        jButton2.setText("FACE DETECTION");
        jButton2.setMaximumSize(new java.awt.Dimension(250, 40));
        jButton2.setMinimumSize(new java.awt.Dimension(250, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(480, 301, 300, 49);

        jButton3.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        jButton3.setText("SMILE RECOGNTION");
        jButton3.setMaximumSize(new java.awt.Dimension(250, 40));
        jButton3.setMinimumSize(new java.awt.Dimension(250, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(481, 390, 300, 50);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("/home/xterminate/project/testing/SelfieBooth/media/mainmenu.jpg")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jLabel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel1.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1330, 1020);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cascade = "/home/xterminate/cascades/lbpcascade_frontalface.xml";
        this.setVisible(false);
        new Capture_Screen().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cascade = "/home/xterminate/cascades/haarcascade_smile.xml";
        this.setVisible(false);
        new Capture_Screen().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
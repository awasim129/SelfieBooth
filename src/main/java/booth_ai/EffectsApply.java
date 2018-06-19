/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booth_ai;

import static booth_ai.FullScreen.graphicsDevice;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author xterminate
 */
public class EffectsApply extends javax.swing.JFrame {
    
    public static String imgurl = "/home/xterminate/project/output/Image.jpg";
    public static String returnurl;
    public static String urll;
    /**
     * Creates new form EffectsApply
     */
    public EffectsApply() {
        initComponents();
        FullScreen.show();
        graphicsDevice.setFullScreenWindow(this);
        jLabel2.setSize(FullScreen.screenSize);
        imgLoader(imgurl);
        
    }

    public void imgLoader(String imgurl) {
        BufferedImage img = null;
        try {
        img = ImageIO.read(new File(imgurl));
            } catch (IOException e) {
                e.printStackTrace();
                        }
        Image dimg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),
        Image.SCALE_SMOOTH);

        ImageIcon imgThisImg = new ImageIcon(dimg);
        jLabel1.setIcon(imgThisImg);
    }
    
    public void urldisp(){
        URL url;
        try {
            url = new URL(urll);
            Image image = ImageIO.read(url);
            Image dimg = image.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),
        Image.SCALE_SMOOTH);

        ImageIcon imgThisImg = new ImageIcon(dimg);
        jLabel1.setIcon(imgThisImg);
        } catch (MalformedURLException ex) {
            Logger.getLogger(EffectsApply.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EffectsApply.class.getName()).log(Level.SEVERE, null, ex);
        }

 
    }
    public void save() {
         URL url;
        try {
            url = new URL(urll);
            InputStream in = new BufferedInputStream(url.openStream());
           ByteArrayOutputStream out = new ByteArrayOutputStream();
byte[] buf = new byte[1024];
int n = 0;
while (-1!=(n=in.read(buf)))
{
   out.write(buf, 0, n);
}
out.close();
in.close();
byte[] response = out.toByteArray();
FileOutputStream fos = new FileOutputStream("/home/xterminate/project/output/Image.jpg");
fos.write(response);
fos.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(EffectsApply.class.getName()).log(Level.SEVERE, null, ex);
        }

         catch (IOException ex) {
            Logger.getLogger(EffectsApply.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void convert_to(String filter)  {
        CloudinaryAPI effects = new CloudinaryAPI();
                                  
        try {
            //Map result = effects.access.uploader().upload(new File("/home/xterminate/project/output/Image.jpg"), ObjectUtils.asMap(
              //      "transformation", new Transformation().effect("art:zorro")));
            File toUpload = new File("/home/xterminate/project/output/Image.jpg");
Map  uploadResult = effects.access.uploader().upload(toUpload, ObjectUtils.emptyMap());
            System.out.println(uploadResult);
            String tag = uploadResult.get("public_id").toString();
            returnurl = effects.access.url()
  .transformation(new Transformation().effect(filter))
  .generate(tag+".jpg");
                      System.out.println(returnurl);
                      urll = returnurl;
                      urldisp();

            
            
        } catch (IOException ex) {
            Logger.getLogger(EffectsApply.class.getName()).log(Level.SEVERE, null, ex);
        }
                      

                      

    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sepia = new javax.swing.JButton();
        redrock = new javax.swing.JButton();
        incognito = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        primavera = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1275, 960));
        setSize(new java.awt.Dimension(1275, 1020));
        getContentPane().setLayout(null);

        sepia.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        sepia.setText("Sepia");
        sepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepiaActionPerformed(evt);
            }
        });
        getContentPane().add(sepia);
        sepia.setBounds(310, 740, 150, 57);

        redrock.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        redrock.setText("Grayscale");
        redrock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redrockActionPerformed(evt);
            }
        });
        getContentPane().add(redrock);
        redrock.setBounds(530, 740, 160, 57);

        incognito.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        incognito.setText("Incognito");
        incognito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incognitoActionPerformed(evt);
            }
        });
        getContentPane().add(incognito);
        incognito.setBounds(750, 740, 170, 57);

        SaveButton.setFont(new java.awt.Font("Purisa", 1, 18)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton);
        SaveButton.setBounds(560, 910, 101, 30);

        primavera.setFont(new java.awt.Font("Purisa", 1, 22)); // NOI18N
        primavera.setText("Primavera");
        primavera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primaveraActionPerformed(evt);
            }
        });
        getContentPane().add(primavera);
        primavera.setBounds(530, 820, 160, 60);

        jLabel1.setText("jLabel1");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 270, 640, 420);

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/xterminate/project/testing/SelfieBooth/media/effect.png")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1240, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepiaActionPerformed
        convert_to("sepia");
    }//GEN-LAST:event_sepiaActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        save();
        this.setVisible(false);
        new Effects().setVisible(true);
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void redrockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redrockActionPerformed
        convert_to("grayscale");
    }//GEN-LAST:event_redrockActionPerformed

    private void incognitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incognitoActionPerformed
        convert_to("art:incognito");
    }//GEN-LAST:event_incognitoActionPerformed

    private void primaveraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primaveraActionPerformed
        convert_to("art:primavera");
    }//GEN-LAST:event_primaveraActionPerformed

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
            java.util.logging.Logger.getLogger(EffectsApply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EffectsApply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EffectsApply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EffectsApply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EffectsApply().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton incognito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton primavera;
    private javax.swing.JButton redrock;
    private javax.swing.JButton sepia;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booth_ai;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Rida Zafar
 */
public class Capture_Screen extends javax.swing.JFrame {

    //Components for the Java Open Computer Vision Library
    private DaemonThread myThread = null;
    int count = 0;
    public VideoCapture webSource = null; //Opens a Video Source
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    
   
   
   // CascadeClassifier faceDetector = new CascadeClassifier(Capture_Screen.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));  //Files to Detect Face
    CascadeClassifier faceDetector = new CascadeClassifier(MainMenu.cascade);
    MatOfRect faceDetections = new MatOfRect();
    Rect rect = new Rect(0,0,0,0); //Rectanbgle inititialized to Capture Face Detections Array
    Rect rec2=new Rect(0,0,0,0); //Comparison Rectangle to capture Pic when Given Time Passed
    int c=0; //Counter to count iterations in Seconds
    boolean rectconrol = true;  //Control used to remove rectangle from Face, one second before pic capture
    
    /**
     * Creates new form Capture_Screen
     */
    public Capture_Screen() {
        initComponents();
        start();
    }
    
    public void start() {
        webSource = new VideoCapture(0); // video capture from default cam
        myThread = new DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();                 //start thrad
        startbutton.setEnabled(false);  // deactivate start button
        stopbutton.setEnabled(true);  //  activate stop button
    }
    
    public void newfunc() {
        this.setVisible(false);
        new Effects().setVisible(true);
    }
    
    class DaemonThread implements Runnable {

        
        protected volatile boolean runnable = false;

        @Override
        public void run() {
     
            synchronized (this) {
     
                while (runnable) {
     
                    if (webSource.grab()) {
                        try {
                             
                            
                            webSource.retrieve(frame);
                            Graphics g = camera.getGraphics();
                            System.out.println("Rect bf " + rect.x);
                            faceDetector.detectMultiScale(frame, faceDetections);
                          
                            for ( Rect rect : faceDetections.toArray()) {
                                MatOfRect faceDetections2 = new MatOfRect();
                                //faceDetector.detectMultiScale(frame, faceDetections2);
    //                            stopwatch.start();
                                System.out.println("ttt");
                               
                                rec2 = new Rect();
                                rec2 =  rect;
                                if (rectconrol==true) {
                                Core.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                        new Scalar(0, 255,0)); }
            
                                System.out.println("Rect x: "+rect.x);
                                
                                System.out.println(c);
                                Highgui.imencode(".jpg", frame, mem);
                                if (c>8) {
                                    rectconrol = false;
                                }
                                if (c==10) {
                                
                                    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                                RenderedImage ri = (RenderedImage) im;
                                
                                File outputFile = new File("/home/xterminate/project/output/Image.jpg");
                                ImageIO.write(ri, "jpg", outputFile);
                                myThread.runnable = false;            // stop thread
                                stopbutton.setEnabled(false);   // activate start button 
                                startbutton.setEnabled(true);     // deactivate stop button
                                rectconrol=true;
                                webSource.release();
                                c=0;
                                
                                
  

                                  System.out.println("Success");
                                  newfunc();
                                }
                            }
                            
                            System.out.println("Rect AF "+rec2.x);
                            if (rec2.x >0 && rec2.y >0) {
                                    c=c+1;
                                    rec2.x=0;
                                    rec2.y=0;
                                }
                                else {
                                    c=0;
                                }
                            Highgui.imencode(".jpg", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            //RenderedImage ri = (RenderedImage) im;
                            BufferedImage buff = (BufferedImage) im;
                            //File outputFile = new File("C:\\Anas\\Image.png");
                            //ImageIO.write(ri, "png", outputFile);
                            
                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight()-150 , 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                                               
 
                               if (runnable == false) {
                                 
                                    System.out.println("Paused ..... ");
                                    this.wait();
                                    
                                }
                           }
                        
                        }  
                            catch (Exception ex) {
                            System.out.println("Error!!");
                            ex.printStackTrace();
                        } 
                    }
                }
            }
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

        camera = new javax.swing.JPanel();
        startbutton = new javax.swing.JButton();
        stopbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1275, 1020));

        camera.setBackground(new java.awt.Color(0, 0, 0));
        camera.setMaximumSize(new java.awt.Dimension(1366, 768));
        camera.setMinimumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout cameraLayout = new javax.swing.GroupLayout(camera);
        camera.setLayout(cameraLayout);
        cameraLayout.setHorizontalGroup(
            cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cameraLayout.setVerticalGroup(
            cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        startbutton.setText("Start");
        startbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startbuttonActionPerformed(evt);
            }
        });

        stopbutton.setText("Stop");
        stopbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(camera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(startbutton)
                .addGap(321, 321, 321)
                .addComponent(stopbutton)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(camera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startbutton)
                    .addComponent(stopbutton))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startbuttonActionPerformed
    
    }//GEN-LAST:event_startbuttonActionPerformed

    private void stopbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopbuttonActionPerformed
        webSource = new VideoCapture(0); // video capture from default cam
        myThread = new DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();                 //start thrad
        stopbutton.setEnabled(false);  // deactivate start button
        startbutton.setEnabled(true);  //  activate stop button
        

    }//GEN-LAST:event_stopbuttonActionPerformed
                        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         
       System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
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
            java.util.logging.Logger.getLogger(Capture_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capture_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capture_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capture_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capture_Screen().setVisible(true);
                
                
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel camera;
    private javax.swing.JButton startbutton;
    private javax.swing.JButton stopbutton;
    // End of variables declaration//GEN-END:variables
}

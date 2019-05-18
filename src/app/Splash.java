package app;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

/**
 *
 * @author jie
 */
public class Splash extends JFrame {

    int a = 0;
    JProgressBar progressBar = new JProgressBar(0, 100);
    JLabel label = new JLabel();
    Image gambar;

    public Splash() {
        progressBar.setStringPainted(true);
        label.setText("Aplikasi Huruf Hijaiyah");
        label.setFont(new Font("Bodoni MT", 1, 30));
        JPanel content = (JPanel) getContentPane();
        setLayout(null);
        gambar = new ImageIcon(getClass().getResource("/gambar/awal.png")).getImage();
        add(label);
        label.setBounds(215, 50, 350, 100); //posisi dan ukuran 
        Component add = add(progressBar);
        progressBar.setBounds(175, 400, 400, 20); //posisi dan ukuran pB
        pack();
        setSize(730, 575);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        while (a <= 100) {
            progressBar.setValue(a);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
            a += 1;
        }
        this.setVisible(false);
        new JFrame2().setVisible(true);
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D gd = (Graphics2D)g.create();
        gd.drawImage(gambar, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Splash();
        } catch (Exception ex) {
        }
    }
}

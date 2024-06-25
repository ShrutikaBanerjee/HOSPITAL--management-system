import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    private String username;
    private int s;
    private Thread th;

    public static void main(String[] args) {
        new Loading("username").setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    //new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        th = new Thread((Runnable) this);

        setBounds(450, 240, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 182, 193)); // Baby pink color
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbllibraryManagement = new JLabel("Travel and Toursim Application");
        lbllibraryManagement.setForeground(new Color(72, 209, 204)); // Cyan color for text
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(50, 46, 700, 35);
        contentPane.add(lbllibraryManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45)); // Brownish color for text
        lblNewLabel_2.setBounds(200, 165, 150, 20);
        contentPane.add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        contentPane.add(panel);

        setUndecorated(true);
        setUploading();
    }
}

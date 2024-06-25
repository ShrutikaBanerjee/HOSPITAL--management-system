import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class DashBoard extends JFrame {

    DashBoard() {
        // Frame setup
        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the frame is closed

        // Panel setup
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        // Image setup for Dashboard.png
        URL imgURL = getClass().getResource("/Dashboard.png");
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(10, 0, 70, 70); // Adjusted position to ensure visibility
            p1.add(imageLabel); // Add image label to the panel
        } else {
            System.err.println("Dashboard image not found.");
        }

        // Text label setup
        JLabel dashboardLabel = new JLabel("travel and tourism association");
        dashboardLabel.setForeground(Color.WHITE);
        dashboardLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        dashboardLabel.setBounds(500, 10, 1200, 50); // Position text label to the right of the image
        p1.add(dashboardLabel); // Add text label to the panel
        
        // Panel for buttons
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        // Method to create buttons
        JButton[] buttons = new JButton[11];
        String[] buttonNames = {
            "ADD PERSONAL DETAILS", "UPDATE PERSONAL DETAILS", "VIEW DETAILS", "DELETE PERSONAL DETAILS", "CHECK PACKAGE",
            "BOOK PACKAGE", "VIEW PACKAGE", "VIEW HOTELS", "BOOK HOTEL", "VIEW BOOKED HOTELS", "DESTINATIONS"
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setBounds(0, i * 50, 300, 50);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            p2.add(buttons[i]);
        }

        // Image setup for home.jpg
        URL imgURL1 = getClass().getResource("/home.jpg");
        if (imgURL1 != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL1);
            Image scaledImage = originalIcon.getImage().getScaledInstance(1200, 900, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel homeImageLabel = new JLabel(scaledIcon);
            homeImageLabel.setBounds(300, 70, 1200, 900); // Adjusted position to ensure visibility
            add(homeImageLabel); 
        } else {
            System.err.println("Home image not found.");
        }

        // Make frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new DashBoard();
    }
}

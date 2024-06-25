import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Login extends JFrame implements ActionListener {
	 JButton signup;
	 JButton loginButton;
	  JButton forget;
    public Login() {
        // Set the size of the frame
        setSize(900, 400);
        
        // Center the JFrame on the screen
        setLocationRelativeTo(null);
        
        // Exit application on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a main panel with absolute positioning
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 400); // Adjust bounds to match desired area
        panel.setBackground(new Color(233, 150, 122)); // Coral color using RGB
        panel.setLayout(null); // Set layout to null to use absolute positioning
        getContentPane().add(panel); // Add panel to the content pane

        // Load and display the image
        getContentPane().setBackground(Color.white);
        URL imgURL = getClass().getResource("/login.png");
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(0, 0, 400, 400); // Position image label within panel bounds
            panel.add(imageLabel); // Add image label to the panel
        } else {
            System.err.println("Image not found.");
        }

        // Create a secondary panel for form elements
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        getContentPane().add(p2); // Add secondary panel to the content pane

        // Add a label for the username field
        JLabel username = new JLabel("USERNAME");
        username.setBounds(430, 30, 100, 25); // Position and size of the label
        p2.add(username); // Add label to the secondary panel

        // Add a text field for username input
        JTextField usernameField = new JTextField();
        usernameField.setBounds(550, 30, 200, 25); // Position and size of the text field
        p2.add(usernameField);// Add text field to the secondary panel

        // Add a label for the password field
        JLabel password = new JLabel("PASSWORD");
        password.setBounds(430, 120, 100, 25); // Position and size of the label
        p2.add(password); // Add label to the secondary panel

        // Add a password field for password input
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(550, 120, 200, 25); // Position and size of the password field
        p2.add(passwordField); // Add password field to the secondary panel

        // Add a login button
        loginButton = new JButton("Login");
        loginButton.setBounds(650, 200, 150, 50); // Position and size of the login button
        loginButton.setBackground(new Color(75, 0, 130)); // Indigo color using RGB
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(new LineBorder(new Color(75, 0, 130)));
        loginButton.addActionListener(this);// Indigo border
        p2.add(loginButton); // Add button to the secondary panel
        
        // Add a signup button
        signup = new JButton("SignUp");
        signup.setBounds(480, 200, 150, 50); // Position and size of the signup button
        signup.setBackground(new Color(75, 0, 130)); // Indigo color using RGB
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(75, 0, 130))); 
        signup.addActionListener(this);
        p2.add(signup); // Add button to the secondary panel
        
        // Add a forgot password button
        forget = new JButton("Forgot Password?");
        forget.setBounds(550, 300, 150, 50); // Position and size of the forgot password button
        forget.setBackground(Color.WHITE); // White background
        forget.setForeground(Color.RED); // Red text color
        forget.setBorder(new LineBorder(new Color(75, 0, 130))); // Indigo border
        forget.addActionListener(this);
        p2.add(forget); // Add button to the secondary panel

        // Make the frame visible
        setVisible(true);
    }

    @Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==loginButton) {
			new Loading ("username");
			
		}
		else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup();
			
		}
		else {
			setVisible(false);
			new ForgotPassword();
		}
		
	}
    public static void main(String[] args) {
        // Run the GUI code in the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(Login::new);
    }

	
}

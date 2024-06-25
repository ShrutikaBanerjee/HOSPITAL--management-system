import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomer extends JFrame implements ActionListener {
    JButton backButton, createButton;
    JTextField nameField, usernameField;
    JTextField passwordField;
    Choice positionChoice;

    AddCustomer() {
        setTitle("Signup Form");
        setBounds(200, 200, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 360);
        panel.setBackground(new Color(233, 150, 122));
        panel.setLayout(null);
        getContentPane().add(panel);

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        Color labelColor = Color.BLACK;
        Color fieldColor = Color.DARK_GRAY;

        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setBounds(60, 50, 150, 25);
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(labelColor);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(220, 50, 150, 25);
        usernameField.setFont(fieldFont);
        usernameField.setForeground(fieldColor);
        panel.add(usernameField);

        JLabel nameLabel = new JLabel("id number");
        nameLabel.setBounds(60, 90, 150, 25);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(labelColor);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220, 90, 150, 25);
        nameField.setFont(fieldFont);
        nameField.setForeground(fieldColor);
        panel.add(nameField);

        JLabel passwordLabel = new JLabel("contact/email");
        passwordLabel.setBounds(60, 130, 150, 25);
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(labelColor);
        panel.add(passwordLabel);

        passwordField = new  JTextField();
        passwordField.setBounds(220, 130, 150, 25);
        passwordField.setFont(fieldFont);
        passwordField.setForeground(fieldColor);
        panel.add(passwordField);

        JLabel positionLabel = new JLabel("id");
        positionLabel.setBounds(60, 170, 150, 25);
        positionLabel.setFont(labelFont);
        positionLabel.setForeground(labelColor);
        panel.add(positionLabel);

        positionChoice = new Choice();
        positionChoice.add("Passport");
        positionChoice.add("adhar card");
        positionChoice.add("Parivar patr");
        positionChoice.setBounds(220, 170, 120, 25);
        panel.add(positionChoice);

        createButton = new JButton("add");
        createButton.setBounds(60, 220, 150, 30);
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBackground(Color.WHITE);
        createButton.setForeground(Color.BLACK);
        createButton.addActionListener(this);
        panel.add(createButton);

        backButton = new JButton("BACK");
        backButton.setBounds(220, 220, 150, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        panel.add(backButton);

        URL imgURL = getClass().getResource("/newcustomer.jpg");
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(480, 50, 250, 250);
            getContentPane().add(imageLabel);
        } else {
            System.err.println("Image not found.");
        }
        try {
			String query = "SELECT * FROM account WHERE username = '" + usernameField.getText() + "'";
			Com c = new Com();
			  ResultSet rs =c.s.executeQuery(query);
			  while(rs.next()) {
				nameField.setText(rs.getString("name"));
				  //rs.getString("position");
			  }
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}

        setVisible(true);
    }

  

    public static void main(String[] args) {
        new AddCustomer();
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

import javax.swing.*;

public class ForgotPassword extends JFrame implements ActionListener{
    JTextField nameField, usernameField, ANSWER, passwordField;
    Choice positionChoice;
    JButton search, RETRIEVE, backButton;

    ForgotPassword() {
        setTitle("FORGOT PASSWORD");
        setBounds(200, 200, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 580, 400);
        panel.setBackground(new Color(244, 194, 194));
        panel.setLayout(null);
        getContentPane().add(panel);

        URL imgURL = getClass().getResource("/forgotpassword.jpg");
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(600, 75, 250, 250); // Adjust bounds to center the image
            getContentPane().add(imageLabel);
        } else {
            System.err.println("Image not found.");
        }

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

        search = new JButton("SEARCH");
        search.setBounds(400, 50, 100, 25);
        search.setFont(new Font("Arial", Font.BOLD, 14));
        search.setBackground(new Color(137, 204, 240));
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        panel.add(search);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setBounds(60, 90, 150, 25);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(labelColor);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220, 90, 150, 25);
        nameField.setFont(fieldFont);
        nameField.setForeground(fieldColor);
        panel.add(nameField);

        JLabel positionLabel = new JLabel("POSITION");
        positionLabel.setBounds(60, 170, 150, 25);
        positionLabel.setFont(labelFont);
        positionLabel.setForeground(labelColor);
        panel.add(positionLabel);

        positionChoice = new Choice();
        positionChoice.add("xyz");
        positionChoice.add("mnl");
        positionChoice.add("abc");
        positionChoice.setBounds(220, 170, 150, 25);
        panel.add(positionChoice);

        JLabel securityCode = new JLabel("CODE-DOB");
        securityCode.setBounds(60, 130, 150, 25);
        securityCode.setFont(labelFont);
        securityCode.setForeground(labelColor);
        panel.add(securityCode);

        ANSWER = new JTextField();
        ANSWER.setBounds(220, 130, 150, 25);
        ANSWER.setFont(fieldFont);
        ANSWER.setForeground(fieldColor);
        panel.add(ANSWER);

        JLabel passwordLabel = new JLabel("NEW PASSWORD");
        passwordLabel.setBounds(60, 210, 150, 25);
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(labelColor);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(220, 210, 150, 25);
        passwordField.setFont(fieldFont);
        passwordField.setForeground(fieldColor);
        panel.add(passwordField);

        RETRIEVE = new JButton("RETRIEVE");
        RETRIEVE.setBounds(250, 300, 150, 25);
        RETRIEVE.setFont(new Font("Arial", Font.BOLD, 14));
        RETRIEVE.setBackground(new Color(137, 204, 240));
        RETRIEVE.setForeground(Color.WHITE);
        RETRIEVE.addActionListener(this);
        panel.add(RETRIEVE);

        // Adding the Back button
        backButton = new JButton("BACK");
        backButton.setBounds(60, 300, 100, 25);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(137, 204, 240));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        panel.add(backButton);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==search) {
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
    		
    	}
    	else if(ae.getSource()==RETRIEVE) {
    		try {
    			String query = "SELECT * FROM account WHERE username = '" + usernameField.getText() + "'";
    			Com c = new Com();
    			  ResultSet rs =c.s.executeQuery(query);
    			  while(rs.next()) {
    				passwordField.setText(rs.getString("password"));
    				  //rs.getString("position");
    			  }
    			

    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}
    	else {
    		setVisible(false);
    		new Login();
    	}
    
	
	

    }

    public static void main(String[] args) {
        new ForgotPassword();
    }
	
}

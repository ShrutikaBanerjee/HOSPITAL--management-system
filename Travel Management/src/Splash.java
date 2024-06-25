import javax.swing.*;
import java.net.URL;

public class Splash extends JFrame implements Runnable {
	Thread thread;
    Splash() {
     //   setSize(1100, 600);
      //  setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Attempt to load the image from the classpath
        URL imgURL = getClass().getResource("/welcomeabord.jpg");
        if (imgURL != null) {
            ImageIcon i1 = new ImageIcon(imgURL);
            JLabel image = new JLabel(i1);
            add(image);
        } else {
            System.err.println("Couldn't find file: splash.jpg");
        }

        setVisible(true);
        thread= new Thread(this);
        thread.start();
        
    }
    public void run ()
    {try {
    	Thread.sleep(5000);
    	new Login();
    	setVisible(false);
    }
    catch(Exception e) {
    	
    }
    	
    }
    public static void main(String[] args) {
       Splash frame= new Splash();
       int x=1;
       for(int i =1; i <=650;x+=6, i+=6) {
    	   frame.setLocation(650-x,400-i/2 );
    	   frame.setSize(i+1+x,i);
    	   try {
    		   Thread.sleep(10);
    	   }
    	   catch(Exception e) {
    		   
    	   }
       }
    }
}

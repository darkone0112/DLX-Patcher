import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DlxPatcher {
    private static final String JAVA6_PORTABLE_PATH = "C:/Java6Portable/App/Java/jre";
    private static final String[] WEBSITE_URLS = {"https://www.example.com", "https://www.google.com"};
    
    public static void main(String[] args) {
        // set the path to the Java 6 portable installation directory
        System.setProperty("java.home", JAVA6_PORTABLE_PATH);
        
        // create a new JFrame and JPanel
        JFrame frame = new JFrame("Open Web Pages");
        JPanel panel = new JPanel();
        
        // create a button for each website
        for (String url : WEBSITE_URLS) {
            JButton button = new JButton(url);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    openWebPage(url);
                }
            });
            panel.add(button);
        }
        
        // add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);
        
        // set the size and visibility of the frame
        frame.pack();
        frame.setVisible(true);
    }
    
    // method for opening a webpage using the default browser
    private static void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

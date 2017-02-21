package java2final;

//import
import javax.swing.JFrame;

/**
 *
 * @author KaChiLau
 */
public class SnakeGame extends JFrame{ //make the window
    public static void main(String[] args) {
        JFrame f = new JFrame("I am a Snake, I am hungry"); //create a frame
        Screen s = new Screen(); //create a screen
        f.add(s); //add the screen to frame
        f.setSize(800, 830); //set the size to 800
        f.setVisible(true); //make the screen visible
        f.setLocationRelativeTo(null); //set the screen location to center of the window
        f.setResizable(false); //user can't change the size of the window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close if user press x on the right up corner
    }
}

import javax.swing.*;
import java.awt.*;
/**
 * Title        : imagePanel.java
 * Description  : This class adds the images into a panel for miniproject task3.
 * @author Shiyuan Jia
 * @version 3.0 2017-5-28
 */

public class imagePanel extends JPanel{

    /**
     * Declaration of instance variables.
     * The buttons are used to contain images.
     */
    private JButton[] imageLabel;

    /**
     * This is the constructor for this class.
     * It will add a special number of images into a panel.
     * @param number The number of images which will be added to this panel.
     */
    public imagePanel(int number){
        
        imageLabel = new JButton[number];

        // Set layout of this panel.
        this.setLayout(new GridLayout(0,5,2,2));

        // Add pictures into buttons.
        for(int i = 0; i < number; i++){
            imageLabel[i] = new JButton();
            imageLabel[i].setBackground(Color.white);
            imageLabel[i].setIcon(new ImageIcon("animal" + (i +1)+ ".png"));
            this.add(imageLabel[i]);
        }
    }
}
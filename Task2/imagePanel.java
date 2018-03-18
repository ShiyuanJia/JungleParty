import javax.swing.*;
import java.awt.*;
/**
 * Title        : imagePanel.java
 * Description  : This class adds the images into a panel for miniproject task2.
 * @author Shiyuan Jia
 * @version 2.0 2017-5-28
 */

public class imagePanel extends JPanel{

    /**
     * Declaration of instance variables.
     * The Labels are used to contain images.
     */
    private JLabel[] imageLabel;

    /**
     * This is the constructor for this class.
     * It will add a special number of images into a panel.
     * @param number The number of images which will be added to this panel.
     */
    public imagePanel(int number){
        
        imageLabel = new JLabel[number];

        // Set layout of this panel.
        this.setLayout(new GridLayout(0,5,2,2));

        // Add pictures into labels.
        for(int i = 0; i < number; i++){
            imageLabel[i] = new JLabel();
            imageLabel[i].setIcon(new ImageIcon("animal" + (i +1)+ ".png"));
            this.add(imageLabel[i]);
        }
    }
}
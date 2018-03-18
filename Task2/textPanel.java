import javax.swing.*;
import java.awt.*;
/**
 * Title        : textPanel.java
 * Description  : This class contains prompt message label and combobox for task2.
 * @author Shiyuan Jia
 * @version 2.0 2017-5-28
 */

public class textPanel extends JPanel {

    // Declaration of instance variables.
    // label contains prompt message.
    private JLabel textlabel;
    
    // combobox where user can choose a right number from possible answers.
    private JComboBox<Integer> jComboBox;

    /**
     * This is the constructor that adds text label and text field
     * into a panel.
     */
    public textPanel(){
        
        this.setLayout(new FlowLayout());
        textlabel = new JLabel("How many animals have come to the party?");
        jComboBox = new JComboBox<>();

        // Add the possible answers into jComnoBox.
        for(int i = 0; i < 10; i++)
            jComboBox.addItem(i+1);
        
        this.add(textlabel);
        this.add(jComboBox);
    }

    /**
     * This is the method which will be excuted when the answer is right.
     * It can change the prompt message of text label.
     */
    public void right(){
        textlabel.setText("Correct! How many animals are in the party now?");
    }

    /**
     * This is the method will be excuted when the answer is wrong.
     * It can change the prompt message of text label.
     */
    public void wrong(){
        textlabel.setText("Wrong! Try again!");
    }

    /**
     * This method will return the number that user chooses from the combobox.
     * @return int the number of user's choice.
     */
    public int getInputNum(){
        return jComboBox.getItemAt(jComboBox.getSelectedIndex());
    }
    
}
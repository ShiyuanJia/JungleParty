import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Title        : textPanel.java
 * Description  : This class contains prompt message label and text field for task1.
 * @author Shiyuan Jia
 * @version 1.0 2017-5-28
 */

public class textPanel extends JPanel {
    
    // Declaration of instance variables.
    // label contains prompt message.
    private JLabel textlabel;
    
    // text field where user enters answer.
    private JTextField jTextField;

    /**
     * This is the constructor that adds text label and text field
     * into a panel.
     */
    public textPanel(){
        
        this.setLayout(new FlowLayout());
        textlabel = new JLabel("How many animals have come to the party?");
        jTextField = new JTextField(2);
        
        this.add(textlabel);
        this.add(jTextField);
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
     * This method will return the number that user enters at the text field.
     * @return  return the number of user entering if user enters right formal;
     *          return -1 if user enters nothing;
     *          return -2 if user enters no numeric content.
     */
    public int getInputNum(){
        if(isNumeric(jTextField.getText()))
            return -2;
        else if(jTextField.getText().equals(""))
            return -1;
        return Integer.parseInt(jTextField.getText());
    }

    /**
     * This method will judge whether the string content is numeric.
     * @param str string content is judged
     * @return return true if the content is not numeric;
     *         return false if the content is numeric.
     */
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if(!isNum.matches())
            return true;
        return false;
    }
    
}
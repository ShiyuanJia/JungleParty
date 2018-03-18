import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Title        : JungleParty.java
 * Description  : This class contains the test method of JungleParty program task1.
 * @author Shiyuan Jia
 * @version 1.0 2017-5-28
 */

public class JungleParty{
    
    // Declaration of instance variables.
    // The number of pictures
    private int random;
    // The frame of this program
    private JFrame jFrame;
    // The panels are added to the frame
    private JPanel northPanel, centerPanel, southPanel;
    // The check button
    private JButton jButton;
    // A imagepanel contains image labels
    private imagePanel image;
    // A textpanel contains prompt message and text field
    private textPanel text;

    /**
     * The method will excute the program.
     */
    public void go(){
        
        random = 10;
        jFrame = new JFrame();
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        jButton = new JButton("Check!");
        text = new textPanel();
        image = new imagePanel(random);

        northPanel.add(image);
        centerPanel.add(text);
        southPanel.add(jButton);
        
        northPanel.setPreferredSize(new Dimension(950,random*32));
        
        /*
         * Add action listener to 'check' button.
         * If the button is clicked, it will excute actionperformed method.
         * The images and prompt message will be changed according to user's answer.
         */
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(text.getInputNum() == random) {
                    text.right();
                    random = (int) (Math.random() * 10 + 1);
                    northPanel.removeAll();
                    image = new imagePanel(random);
                    northPanel.add(image);
                    northPanel.updateUI();
                }
                else if(text.getInputNum()==-1){}
                else
                    text.wrong();

            }
        });

        //Get windows' size, to make program show at center
        int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;

        jFrame.getContentPane().add(northPanel, BorderLayout.NORTH);
        jFrame.getContentPane().add(centerPanel,BorderLayout.CENTER);
        jFrame.getContentPane().add(southPanel,BorderLayout.SOUTH);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setTitle("Welcome to the Jungle Party!");
        jFrame.setLocation((width-jFrame.getSize().width)/2,(height-jFrame.getSize().height)/2);
        jFrame.setVisible(true);
    }
    
    /**
     * Creates an instance of this class.
     * And call 'go' method to excute this program.
     * @param args null
     */
    public static void main(String[] args){
        JungleParty jungleParty = new JungleParty();
        jungleParty.go();
    }
}

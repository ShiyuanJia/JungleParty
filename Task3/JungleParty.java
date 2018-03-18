import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Title        : JungleParty.java
 * Description  : This class contains the test method of JungleParty program task3.
 * @author Shiyuan Jia
 * @version 3.0 2017-5-28
 */
public class JungleParty{

    // Decelaration of instance variables.
    // The number of pictures
    private int random;
    // The frame of this program
    private JFrame jFrame;
    // The panels are added to the frame
    private JPanel northPanel, centerPanel, southPanel;
    // The check button and bottom prompt panel
    private JPanel buttonPanel, promptPanel;
    // The check button
    private JButton jButton;
    // The images' buttons
    private JButton[] getImage;
    // A imagepanel contains image labels
    private imagePanel image;
    // A textpanel contains prompt message and text combobox
    private textPanel text;
    // The bottom prompt message label
    private JLabel promptLabel;

    /**
     * The method will excute the program.
     */
    public void go(){
        
        random = 10;
        jFrame = new JFrame();
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel();
        promptPanel = new JPanel();
        
        jButton = new JButton("Check!");
        text = new textPanel();
        image = new imagePanel(random);
        getImage = new JButton[random];
        promptLabel = new JLabel("Click on animals you wish to kick out of the party!");
        promptLabel.setForeground(Color.red);
        
        jFrame.setTitle("Welcome to the Jungle Party!");
        
        buttonPanel.add(jButton);
        promptPanel.add(promptLabel);
        northPanel.add(image);
        centerPanel.add(text);
        southPanel.add(buttonPanel,BorderLayout.CENTER);
        southPanel.add(promptPanel,BorderLayout.SOUTH);
        
        this.imageClick();
        
        northPanel.setPreferredSize(new Dimension(950,random*32));

        /*
         * Add action listener to 'check' button.
         * If the button is clicked, it will excute actionperformed method.
         * The images and prompt message will be changed according to user's answer.
         */
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(text.getInputNum() == random){
                    text.textRight();
                    random = (int)(Math.random()*10 + 1);
                    northPanel.removeAll();
                    image = new imagePanel(random);
                    northPanel.add(image);
                    northPanel.updateUI();
                    imageClick();
                }
                else {
                    text.textWrong();
                }
            }
        });

        //Get windows' size, to make program show at center
        int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;

        jFrame.getContentPane().add(northPanel, BorderLayout.NORTH);
        jFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        jFrame.getContentPane().add(southPanel, BorderLayout.SOUTH);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocation((width-jFrame.getSize().width)/2,(height-jFrame.getSize().height)/2);
        jFrame.setVisible(true);
    }

    /**
     * This method will listen the picture buttons.
     * If user clicks a picture, the picture will disappear from the frame.
     */
    public void imageClick(){
        for(int i = 0; i < random; i++){
            getImage[i] = new JButton();
            getImage[i] = (JButton)image.getComponent(i);
            getImage[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jButton = (JButton)e.getSource();
                    jButton.setVisible(false);
                    image.updateUI();
                    text.textChange();
                    random--;
                }
            });
        }
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

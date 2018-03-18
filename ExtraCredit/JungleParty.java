import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
/**
 * Title        : JungleParty.java
 * Description  : This class contains the test method of JungleParty program ExtraCredit.
 * @author Shiyuan Jia
 * @version 4.0 2017-5-28
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
     * @param num the max number of images, entered by user at command line.
     */
    public void go(int num){
        
        random = num;
        jFrame = new JFrame();
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel();
        promptPanel = new JPanel();
        
        jButton = new JButton("Check!");
        text = new textPanel(random);
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
        
        northPanel.setPreferredSize(new Dimension(950,((random+4)/5)*160));

        /*
         * Add action listener to 'check' button.
         * If the button is clicked, it will excute actionperformed method.
         * The images and prompt message will be changed according to user's answer.
         */
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(text.getInputNum() == random) {
                    text.textRight();
                    random = (int) (Math.random() * num + 1);
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
     *  This method will judge whther the string content is a number.
     * @param str string content is judged
     * @return return true if the content is not numbers;
     *         return false if the content is numbers.
     */
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return true;
        }
        return false;
    }

    /**
     * The method will create an instance of JungleParty
     * and excute this program.
     * @param args the number of images
     */
    public static void main(String[] args) {
        JungleParty jungleParty = new JungleParty();

        if (args.length <= 0 || jungleParty.isNumeric(args[0]) || Integer.parseInt(args[0]) > 20 || Integer.parseInt(args[0]) < 10)
        {
            System.out.println("Wrong! Please enter number between 10 and 20.");
            System.out.println("EX:");
            System.out.println("java JungleParty 15");
        }
        else {
            int num = Integer.parseInt(args[0]);
            jungleParty.go(num);
        }
    }
}

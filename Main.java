import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args) throws AWTException{
        final int buttonWidth = 75;
        final int buttonHeight = 60;
        boolean isHorizontal = true;
        //Create strings formatted for clipboard
        StringSelection lowerAcuteA = new StringSelection("á");
        StringSelection lowerAcuteE = new StringSelection("é");
        StringSelection lowerAcuteI = new StringSelection("í");
        StringSelection lowerAcuteO = new StringSelection("ó");
        StringSelection lowerAcuteU = new StringSelection("ú");
        StringSelection lowerTildeN = new StringSelection("ñ");
        StringSelection upperAcuteA = new StringSelection("Á");
        StringSelection upperAcuteE = new StringSelection("É");
        StringSelection upperAcuteI = new StringSelection("Í");
        StringSelection upperTildeN = new StringSelection("Ñ");
        StringSelection upperAcuteO = new StringSelection("Ó");
        StringSelection upperAcuteU = new StringSelection("Ú");
        StringSelection invertedQuestionMark = new StringSelection("¿");
        StringSelection invertedExclaimationMark = new StringSelection("¡");
        StringSelection lowerUUmlaut = new StringSelection("ü");
        StringSelection upperUUmlaut = new StringSelection("Ü");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        JFrame frame = new JFrame();
        Robot robot = new Robot();

        //Create buttons
        JButton capsButton = new JButton("CAPS");
        JButton acuteAButton = new JButton("á");
        JButton acuteEButton = new JButton("é");
        JButton acuteIButton = new JButton("í");
        JButton acuteOButton = new JButton("ó");
        JButton acuteUButton = new JButton("ú");
        JButton tildeNButton = new JButton("ñ");
        JButton uUmulautButton = new JButton("ü");
        JButton invertedExclaimationMarkButton = new JButton("¡");
        JButton invertedQuestionMarkButton = new JButton("¿");
        capsButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
        acuteAButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        acuteEButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        acuteIButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        acuteOButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        acuteUButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        tildeNButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        uUmulautButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        invertedExclaimationMarkButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));
        invertedQuestionMarkButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));

        setup(frame);

        capsButton.setBounds(0, 0, buttonWidth, buttonHeight);
        frame.add(capsButton);
        capsButton.setVisible(true);
        capsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    acuteAButton.setText("Á");
                    acuteEButton.setText("É");
                    acuteIButton.setText("Í");
                    tildeNButton.setText("Ñ");
                    acuteOButton.setText("Ó");
                    acuteUButton.setText("Ú");
                    uUmulautButton.setText("Ü");
                    invertedExclaimationMarkButton.setText("FLIP");
                    invertedExclaimationMarkButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
                    //frame.setSize(165, 387);
                }
                else{
                    acuteAButton.setText("á");
                    acuteEButton.setText("é");
                    acuteIButton.setText("í");
                    tildeNButton.setText("ñ");
                    acuteOButton.setText("ó");
                    acuteUButton.setText("ú");
                    uUmulautButton.setText("ü");
                    invertedExclaimationMarkButton.setText("¡");
                    invertedExclaimationMarkButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 40));

                    //frame.setSize(387, 157);
                }
            }
        });

        acuteAButton.setBounds(75, 0, buttonWidth, buttonHeight);
        frame.add(acuteAButton);
        acuteAButton.setVisible(true);
        acuteAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, lowerAcuteA, robot);
                }
                else{
                    type(clipboard, upperAcuteA, robot);
                }
            }
        });

        acuteEButton.setBounds(150, 0, buttonWidth, buttonHeight);
        frame.add(acuteEButton);
        acuteEButton.setVisible(true);
        acuteEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, lowerAcuteE, robot);
                }
                else{
                    type(clipboard, upperAcuteE, robot);
                }
            }
        });

        acuteIButton.setBounds(225, 0, buttonWidth, buttonHeight);
        frame.add(acuteIButton);
        acuteIButton.setVisible(true);
        acuteIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, lowerAcuteI, robot);
                }
                else{
                    type(clipboard, upperAcuteI, robot);
                }
            }
        });

        tildeNButton.setBounds(75, buttonHeight, buttonWidth, buttonHeight);
        frame.add(tildeNButton);
        tildeNButton.setVisible(true);
        tildeNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, lowerTildeN, robot);
                }
                else{
                    type(clipboard, upperTildeN, robot);
                }
            }
        });

        acuteOButton.setBounds(150, buttonHeight, buttonWidth, buttonHeight);
        frame.add(acuteOButton);
        acuteOButton.setVisible(true);
        acuteOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, lowerAcuteO, robot);
                }
                else{
                    type(clipboard, upperAcuteO, robot);
                }
            }
        });

        acuteUButton.setBounds(225, 60, buttonWidth, buttonHeight);
        frame.add(acuteUButton);
        acuteUButton.setVisible(true);
        acuteUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, lowerAcuteU, robot);
                }
                else{
                    type(clipboard, upperAcuteU, robot);
                }
            }
        });

        invertedExclaimationMarkButton.setBounds(300, 0, buttonWidth, buttonHeight);
        frame.add(invertedExclaimationMarkButton);
        invertedExclaimationMarkButton.setVisible(true);
        invertedExclaimationMarkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, invertedExclaimationMark, robot);
                }
                else{
                    //Horizontal width = 387, height = 165
                    //Vertical width = 157, height = 387
                    if (frame.getWidth() == 387) {
                        frame.setSize(165, 337);
                        invertedExclaimationMarkButton.setBounds(0, 240, buttonWidth, buttonHeight);
                        acuteEButton.setBounds(0, 120, buttonWidth, buttonHeight);
                        acuteIButton.setBounds(75, 120, buttonWidth, buttonHeight);
                        acuteOButton.setBounds(0, 180, buttonWidth, buttonHeight);
                        acuteUButton.setBounds(buttonWidth, 180, buttonWidth, buttonHeight);
                        invertedQuestionMarkButton.setBounds(buttonWidth, 240, buttonWidth, buttonHeight);
                    }
                    else{
                        frame.setSize(387, 157);
                        invertedExclaimationMarkButton.setBounds(300, 0, buttonWidth, buttonHeight);
                        acuteEButton.setBounds(150, 0, buttonWidth, buttonHeight);
                        acuteIButton.setBounds(225, 0, buttonWidth, buttonHeight);
                        acuteOButton.setBounds(150, buttonHeight, buttonWidth, buttonHeight);
                        acuteUButton.setBounds( 225, buttonHeight, buttonWidth, buttonHeight);
                        invertedQuestionMarkButton.setBounds(300, buttonHeight, buttonWidth, buttonHeight);
                    }
                }
            }
        });

        invertedQuestionMarkButton.setBounds(300, buttonHeight, buttonWidth, buttonHeight);
        frame.add(invertedQuestionMarkButton);
        invertedExclaimationMarkButton.setVisible(true);
        invertedQuestionMarkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { type(clipboard, invertedQuestionMark, robot);}
        });

        uUmulautButton.setBounds(0, buttonHeight, buttonWidth, buttonHeight);
        frame.add(uUmulautButton);
        uUmulautButton.setVisible(true);
        uUmulautButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acuteAButton.getText().equals("á")){
                    type(clipboard, lowerUUmlaut, robot);
                }
                else{
                    type(clipboard, upperUUmlaut, robot);
                }
            }
        });
    }



    public static void setup(JFrame frame){
        frame.setSize(387, 157);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spanish Characters");
        frame.setLayout(null);
        frame.setAlwaysOnTop(true);
        frame.setFocusableWindowState(false);
    }

    public static void type(Clipboard clipboard, StringSelection letter, Robot robot) {
        clipboard.setContents(letter, letter);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}

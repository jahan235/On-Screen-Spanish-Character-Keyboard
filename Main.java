import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JFrame {

    // A variable to track the current layout orientation: horizontal (true) or vertical (false)
    static boolean isHorizontal = true;

    public static void main(String[] args) throws AWTException {
        // HashMap to store mappings for toggling between lowercase and uppercase characters
        HashMap<String, String> charMap = new HashMap<>();
        charMap.put("á", "Á");
        charMap.put("é", "É");
        charMap.put("í", "Í");
        charMap.put("ó", "Ó");
        charMap.put("ú", "Ú");
        charMap.put("ñ", "Ñ");
        charMap.put("¡", "¡"); // No toggle for these, but included for consistency
        charMap.put("¿", "¿");

        // Clipboard object to enable copying characters
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // Robot object to simulate key presses
        Robot robot = new Robot();
        // JFrame for the GUI
        JFrame frame = new JFrame();

        // List of buttons in order
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton capsButton = new JButton("CAPS"); // Button to toggle case
        JButton flipButton = new JButton("FLIP"); // Button to toggle layout orientation
        buttons.add(capsButton);
        buttons.add(flipButton);
        buttons.add(new JButton("á"));
        buttons.add(new JButton("é"));
        buttons.add(new JButton("í"));
        buttons.add(new JButton("ñ"));
        buttons.add(new JButton("ó"));
        buttons.add(new JButton("ú"));
        buttons.add(new JButton("¡"));
        buttons.add(new JButton("¿"));

        // Define the font for the buttons (Comic Sans, Bold, size 20)
        Font buttonFont = new Font("Comic Sans MS", Font.BOLD, 20);

        // Setup the main frame (window)
        setup(frame);

        // Add buttons to the frame and set them up
        for (JButton button : buttons) {
            button.setFont(buttonFont); // Apply font to the button
            frame.add(button);
            button.setVisible(true);

            // Listener for the CAPS button
            if (button.equals(capsButton)) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Case for all buttons
                        for (JButton btn : buttons) {
                            if (!btn.getText().equals("CAPS") && charMap.containsKey(btn.getText())) {
                                String currentText = btn.getText();
                                btn.setText(charMap.get(currentText)); // Toggle the text
                                charMap.put(charMap.get(currentText), currentText); // Reverse mapping
                            }
                        }
                    }
                });
            }
            // Listener for the FLIP button
            else if (button.equals(flipButton)) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        isHorizontal = !isHorizontal; // Toggle the layout orientation
                        repositionButtons(buttons, frame); // Rearrange buttons based on the new layout
                        frame.repaint(); // Refresh the frame
                    }
                });
            }
            // Listener for all character buttons
            else {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Copy the button's text to the clipboard and simulate a paste action
                        StringSelection selection = new StringSelection(button.getText());
                        clipboard.setContents(selection, selection);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                    }
                });
            }
        }

        // Initial button positioning based on the default (horizontal) layout
        repositionButtons(buttons, frame);
    }

    /**
     * Sets up the main frame (application window) with initial properties.
     */
    public static void setup(JFrame frame) {
        frame.setSize(515, 185); // Initial dimensions for the horizontal layout
        frame.setVisible(true); // Make the frame visible
        frame.setResizable(false); // Prevent resizing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application on exit
        frame.setTitle("Spanish Characters"); // Title of the window
        frame.setLayout(null); // Absolute layout for manual button positioning
        frame.setAlwaysOnTop(true); // Keep the window always on top
        frame.setFocusableWindowState(false); // Prevent window from stealing focus
    }

    /**
     * Rearranges buttons based on the current layout orientation (horizontal or vertical).
     */
    public static void repositionButtons(ArrayList<JButton> buttons, JFrame frame) {
        int x = 0, y = 0; // Starting coordinates
        int width = 100, height = 75; // Button dimensions

        if (isHorizontal) {
            // Horizontal layout: 2 rows, 5 columns
            frame.setSize(515, 185); // Frame dimensions adjusted for horizontal layout
            int maxButtonsPerRow = 5; // Maximum buttons in one row
            for (int i = 0; i < buttons.size(); i++) {
                JButton button = buttons.get(i);
                x = (i % maxButtonsPerRow) * width; // Calculate x position
                y = (i / maxButtonsPerRow) * height; // Calculate y position
                button.setBounds(x, y, width, height); // Set button bounds
            }
        } else {
            // Vertical layout: 2 columns, 5 rows
            frame.setSize(210, 410); // Frame dimensions adjusted for vertical layout
            int maxButtonsPerColumn = 5; // Maximum buttons in one column
            for (int i = 0; i < buttons.size(); i++) {
                JButton button = buttons.get(i);
                x = (i / maxButtonsPerColumn) * width; // Calculate x position
                y = (i % maxButtonsPerColumn) * height; // Calculate y position
                button.setBounds(x, y, width, height); // Set button bounds
            }
        }
    }
}

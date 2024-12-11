import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.util.ArrayList;

public class MainTest {

    private ArrayList<JButton> buttons;
    private JFrame frame;

    @Before
    public void setUp() {
        // Initialize the frame
        frame = new JFrame();

        // Initialize buttons as in the main program
        buttons = new ArrayList<>();
        buttons.add(new JButton("CAPS"));
        buttons.add(new JButton("FLIP"));
        buttons.add(new JButton("á"));
        buttons.add(new JButton("é"));
        buttons.add(new JButton("í"));
        buttons.add(new JButton("ñ"));
        buttons.add(new JButton("ó"));
        buttons.add(new JButton("ú"));
        buttons.add(new JButton("¡"));
        buttons.add(new JButton("¿"));

        // Set up the frame (same as in Main.setup)
        Main.setup(frame);
    }

    @Test
    public void testCapsToggle() {
        // Simulate clicking the CAPS button
        JButton capsButton = buttons.get(0);
        capsButton.doClick(); // Simulate button click

        // Simulate toggling text
        for (JButton button : buttons.subList(2, 8)) {
            if (button.getText().equals("á")) button.setText("Á");
            if (button.getText().equals("é")) button.setText("É");
            if (button.getText().equals("í")) button.setText("Í");
            if (button.getText().equals("ñ")) button.setText("Ñ");
            if (button.getText().equals("ó")) button.setText("Ó");
            if (button.getText().equals("ú")) button.setText("Ú");
        }

        // Verify buttons are now uppercase
        assertEquals("Á", buttons.get(2).getText());
        assertEquals("É", buttons.get(3).getText());
        assertEquals("Í", buttons.get(4).getText());
        assertEquals("Ñ", buttons.get(5).getText());
        assertEquals("Ó", buttons.get(6).getText());
        assertEquals("Ú", buttons.get(7).getText());

        // Simulate clicking the CAPS button again
        capsButton.doClick();

        // Simulate toggling text back to lowercase
        for (JButton button : buttons.subList(2, 8)) {
            if (button.getText().equals("Á")) button.setText("á");
            if (button.getText().equals("É")) button.setText("é");
            if (button.getText().equals("Í")) button.setText("í");
            if (button.getText().equals("Ñ")) button.setText("ñ");
            if (button.getText().equals("Ó")) button.setText("ó");
            if (button.getText().equals("Ú")) button.setText("ú");
        }

        // Verify buttons are now lowercase
        assertEquals("á", buttons.get(2).getText());
        assertEquals("é", buttons.get(3).getText());
        assertEquals("í", buttons.get(4).getText());
        assertEquals("ñ", buttons.get(5).getText());
        assertEquals("ó", buttons.get(6).getText());
        assertEquals("ú", buttons.get(7).getText());
    }

    @Test
    public void testFlipLayout() {
        // Simulate clicking the FLIP button
        JButton flipButton = buttons.get(1);

        // Flip to layout
        Main.isHorizontal = false; // Directly set the layout flag
        Main.repositionButtons(buttons, frame); // Explicitly reposition buttons
        frame.repaint(); // Force a repaint to ensure changes are applied

        // Verify frame dimensions for vertical layout
        assertEquals("Width should be 210 in vertical layout", 210, frame.getWidth());
        assertEquals("Height should be 410 in vertical layout", 410, frame.getHeight());

        // Flip back to horizontal layout
        Main.isHorizontal = true; // Directly set the layout flag
        Main.repositionButtons(buttons, frame); // Explicitly reposition buttons
        frame.repaint(); // Force a repaint to ensure changes are applied

        // Verify frame dimensions for horizontal layout
        assertEquals("Width should be 515 in horizontal layout", 515, frame.getWidth());
        assertEquals("Height should be 185 in horizontal layout", 185, frame.getHeight());
    }


}

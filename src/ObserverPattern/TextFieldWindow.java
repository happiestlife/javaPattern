package ObserverPattern;

import javax.swing.*;
import java.awt.*;

public class TextFieldWindow implements FrameWindow {
    private JFrame frame;
    private JTextField textField;

    public TextFieldWindow(String title, int x, int y, int width, int height) {
        frame = createWindow(title, x, y, width, height);
    }

    public void updateText(String msg) {
        textField.setText(msg);
        textField.validate();
    }

    public void update(int n){
        updateText(Integer.toString(n));
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextField();
        panel.add(textField);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }
}
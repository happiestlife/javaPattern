package ObserverPattern;

import javax.swing.*;
import java.awt.*;

public class LabelWindow implements FrameWindow {
    private JFrame frame;
    private JLabel label;

    public LabelWindow(String title, int x, int y, int width, int height) {
        frame = createWindow(title, x, y, width, height);
    }

    public void updateText(String msg) {
        label.setText(msg);
        label.validate();
    }
    public void update(int n){
        updateText(Integer.toString(n));
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel();
        panel.add(label);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }
}
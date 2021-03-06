package ObserverPattern;

import javax.swing.*;

public interface FrameWindow{
    public default JFrame createWindow(String title, int x, int y, int width, int height) {
        JFrame frame;
        frame = new JFrame(title);
        frame.setBounds(x, y, width, height);
        JPanel panel = createPanel(width, height);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
    public default void update(int n){}
    public JPanel createPanel(int width, int height);
}
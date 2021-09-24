package ObserverPattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow  implements ActionListener, FrameWindow {
    private static final String MAIN_TITLE = "Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String TEXTFIELD_ADD_OBSERVER_BUTTON_TITLE = "Add TextField Window Observer";
    private static final String TEXTFIELD_REMOVE_OBSERVER_BUTTON_TITLE = "Remove TextField Window Observer";
    private static final String LABEL_ADD_OBSERVER_BUTTON_TITLE = "Add Label Window Observer";
    private static final String LABEL_REMOVE_OBSERVER_BUTTON_TITLE = "Remove Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;

    private JFrame frame;
    private JButton stopButton;
    private JButton updateTextFieldObserverButton;
    private JButton updateLabelObserverButton;
    private PrimeObservableThread primeThread;
    private TextFieldWindow textFieldWindow;
    private LabelWindow labelWindow;

    public MainWindow(String title) {
        frame = createWindow(title, X, Y, WIDTH, HEIGHT);
        textFieldWindow = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        labelWindow = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                primeThread.stopRunning();
                textFieldWindow.closeWindow();
                labelWindow.closeWindow();
                System.exit(0);
            }
        });

        primeThread = new PrimeObservableThread(textFieldWindow, labelWindow); // ��ü ����

        primeThread.run();  // �Ҽ� ���� ����. �� �Լ��� ����� �Ŀ��� stopButton�� ������ ������ ���� �ݺ���
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        updateTextFieldObserverButton = createButton(TEXTFIELD_REMOVE_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(updateTextFieldObserverButton);
        updateLabelObserverButton = createButton(LABEL_REMOVE_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(updateLabelObserverButton);
        stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
        panel.add(stopButton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateTextFieldObserverButton) {
            JButton bt = (JButton) e.getSource();
            if(bt.getText() == TEXTFIELD_ADD_OBSERVER_BUTTON_TITLE){
                primeThread.textFieldState(true);
                updateTextFieldObserverButton.setText(TEXTFIELD_REMOVE_OBSERVER_BUTTON_TITLE);
            }else{
                primeThread.textFieldState(false);
                updateTextFieldObserverButton.setText(TEXTFIELD_ADD_OBSERVER_BUTTON_TITLE);
            }
        }
        else if (e.getSource() == updateLabelObserverButton) {
            JButton bt = (JButton) e.getSource();
            if(bt.getText() == LABEL_ADD_OBSERVER_BUTTON_TITLE){
                primeThread.labelState(true);
                updateLabelObserverButton.setText(LABEL_REMOVE_OBSERVER_BUTTON_TITLE);
            }else{
                primeThread.labelState(false);
                updateLabelObserverButton.setText(LABEL_ADD_OBSERVER_BUTTON_TITLE);
            }
        }
        else if (e.getSource() == stopButton) {
            primeThread.stopRunning();
        }
    }

    private JButton createButton(String text, ActionListener listener, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height / 3);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
        return button;
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
    }
}
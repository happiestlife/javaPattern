package CommandPattern;

import javax.swing.*;

public abstract class CommonButton extends JButton implements Command{
    protected Calculator calculator;
    protected JLabel display;

    public CommonButton(Calculator calculator, JLabel display){
        this.calculator = calculator;
        this.display = display;
    }

    abstract public void execute();
}

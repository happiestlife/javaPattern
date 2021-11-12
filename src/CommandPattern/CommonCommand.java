package CommandPattern;

import javax.swing.*;

public class CommonCommand{
    protected Calculator calculator;
    protected JLabel display;

    public CommonCommand(Calculator calculator, JLabel display){
        this.calculator = calculator;
        this.display = display;
    }
}

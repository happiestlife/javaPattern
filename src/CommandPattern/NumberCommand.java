package CommandPattern;

import javax.swing.*;

public class NumberCommand extends CommonCommand implements Command{

    public NumberCommand(Calculator calculator, JLabel display){
        super(calculator, display);
    }

    @Override
    public void execute(JButton button) {
        if (calculator.isOperand1Set() && calculator.isOperatorSet()) {
            int num2 = Integer.parseInt(button.getText());
            calculator.setOperand2(num2);
            display.setText("" + num2);
            calculator.setOperand2Set(true);
        }
        else {  // 첫 번째 피연산자 값 지정
            int num1 = Integer.parseInt(button.getText());
            display.setText("" + num1);
            calculator.setOperand1(num1);
            calculator.setOperand1Set(true);
        }
    }
}

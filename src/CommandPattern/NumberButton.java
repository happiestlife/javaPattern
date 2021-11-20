package CommandPattern;

import javax.swing.*;

public class NumberButton extends CommonButton {
    public NumberButton(Calculator calculator, JLabel display){
        super(calculator, display);
    }

    @Override
    public void execute() {
        if (calculator.isOperand1Set() && calculator.isOperatorSet()) {
            int num2 = Integer.parseInt(getText());
            calculator.setOperand2(num2);
            display.setText("" + num2);
            calculator.setOperand2Set(true);
        }
        else {  // 첫 번째 피연산자 값 지정
            int num1 = Integer.parseInt(getText());
            display.setText("" + num1);
            calculator.setOperand1(num1);
            calculator.setOperand1Set(true);
        }
    }
}

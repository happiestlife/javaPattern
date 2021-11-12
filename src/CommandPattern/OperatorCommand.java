package CommandPattern;

import javax.swing.*;

public class OperatorCommand extends CommonCommand implements Command{

    public OperatorCommand(Calculator calculator, JLabel display){
        super(calculator, display);
    }

    @Override
    public void execute(JButton button) {
        if (calculator.isOperand1Set()) {  // 첫 번째 피연산자 값이 지정되어야만 연산자 처리 가능
            calculator.setOperatorSet(true);
            calculator.setOperator(button.getText().charAt(0));
        }
    }
}

package StatePattern;

import java.util.Scanner;

public class Start implements State{
    private CalcV1 calculator;

    public Start(CalcV1 c){
        calculator = c;
    }

    @Override
    public void processNumber(String inputStr) {
        calculator.setOperand1(Integer.parseInt(inputStr));
        calculator.setFirstOperandState();
    }

    @Override
    public void processOperator(char operator) {
        System.out.println("첫번째 피연산자를 먼저 입력하세요.");
    }
}

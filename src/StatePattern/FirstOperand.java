package StatePattern;

import java.util.Scanner;

public class FirstOperand implements State{
    private CalcV1 calculator;

    public FirstOperand(CalcV1 c){
        calculator = c;
    }

    @Override
    public void processNumber(String inputStr) {
        System.out.println("연산자(+,-,*,/,=)를 입력하세요.");
    }

    @Override
    public void processOperator(char operator) {
        calculator.setOperator(operator);
        calculator.setOperatorState();
    }
}

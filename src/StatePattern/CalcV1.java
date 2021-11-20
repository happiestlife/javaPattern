package StatePattern;

import java.util.Scanner;

public class CalcV1 {
    private enum STATES { STATE_START, STATE_FIRST_OPERAND, STATE_SECOND_OPERAND, STATE_OPERATOR };
    private Scanner scanner;
    private String inputStr;
    private int operand1; // 첫 번째 피 연산자값 저장
    private int operand2; // 두 번째 피 연산자값 저장
    private char operator; // 사칙 연산자 저장

    private Start start;
    private FirstOperand firstOperand;
    private SecondOperand secondOperand;
    private Operator operatorc;

    private State state;

    CalcV1() {
        scanner = new Scanner(System.in);  // Create a Scanner object
        start = new Start(this);
        firstOperand = new FirstOperand(this);
        secondOperand = new SecondOperand(this);
        operatorc = new Operator(this);
        state = start;
    }

    public void setOperand1(int num){
        operand1 = num;
    }

    public void setOperand2(int num){
        operand2 = num;
    }

    public void setOperator(char operator){
        this.operator = operator;
    }

    public void setStartState(){
        state = start;
    }
    public void setFirstOperandState(){
        state = firstOperand;
    }
    public void setSecondOperandState(){
        state = secondOperand;
    }
    public void setOperatorState(){
        state = operatorc;
    }

    void printOutResult() {
        switch (operator) {
            case '+':
                System.out.printf("%d + %d = %d\n", operand1, operand2, operand1 + operand2);
                break;

            case '-':
                System.out.printf("%d - %d = %d\n", operand1, operand2, operand1 - operand2);
                break;

            case '*':
                System.out.printf("%d * %d = %d\n", operand1, operand2, operand1 * operand2);
                break;

            case '/':
                System.out.printf("%d / %d = %d\n", operand1, operand2, operand1 / operand2);
                break;
        }
    }

    String getInput(String s) {
        System.out.println(s);
        return scanner.next();
    }

    boolean run() {
        inputStr = getInput("정수 또는 +,-,*,/,= 기호 중 한 개를 입력하세요");
        char ch = inputStr.charAt(0);
        if (ch == 'q' || ch == 'Q') { // q를 입력하면 프로그램 종료
            return false;
        }
        else if (ch >= '0' && ch <= '9') { // 정수가 입력되면
            state.processNumber(inputStr);
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') { // 연산자 처리
            state.processOperator(ch);
        }
        return true;
    }
}

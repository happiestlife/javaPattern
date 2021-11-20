package StatePattern;

public class Operator implements State{
    private CalcV1 calculator;

    public Operator(CalcV1 c){
        calculator = c;
    }

    @Override
    public void processNumber(String inputStr) {
        calculator.setOperand2(Integer.parseInt(inputStr));
        calculator.setSecondOperandState();
    }

    @Override
    public void processOperator(char operator) {
        System.out.println("두번째 피연산자를 먼저 입력하세요.");
    }
}

package StatePattern;

public class SecondOperand implements State{
    private CalcV1 calculator;

    public SecondOperand(CalcV1 c){
        calculator = c;
    }

    @Override
    public void processNumber(String inputStr) {
        System.out.println("연산자(+,-,*,/,=)를 입력하세요.");
    }

    @Override
    public void processOperator(char operator) {
        if(operator == '='){
            calculator.printOutResult();
            calculator.setStartState();
        }else
            System.out.println("'='을 입력하세요");
    }
}

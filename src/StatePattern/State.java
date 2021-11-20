package StatePattern;

public interface State {
    public void processNumber(String inputStr);
    public void processOperator(char operator);
}

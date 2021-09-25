package ObserverPattern;

public interface Subject {
    public void notifyObserver(int primeNumber);
    public void addObserver(FrameWindow frameWindow);
    public void removeObserver(FrameWindow frameWindow);
}

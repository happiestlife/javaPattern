package SingletonPattern;

public class Main {
    public static void main(String args[]){
        Singleton singleton = Singleton.getInstance();

        System.out.println(singleton.getName());

        singleton.setName("hard working!");

        System.out.println(singleton.getName());
    }
}

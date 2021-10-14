package SingletonPattern;

import java.util.Scanner;

public class Singleton {
    private volatile static Singleton singleton;
    private String name;
    private Singleton(){}

    public static Singleton getInstance() {
        if(singleton == null){
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    public String getName(){
        if(name == null){
            Scanner s = new Scanner(System.in);
            System.out.println("input name");
            name = s.next();
            s.close();
        }
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

package IteratorPattern;

import java.util.Iterator;

public class Main {
    public static void main(String args[]){
        DynamicMap map = new DynamicMap();

        for (int i = 0; i < 15; i++) {
            map.input(i+1, (i+1)*100 );
        }

        System.out.println("for문과 iterator 사용");
        for (Iterator itr = map.iterator(); itr.hasNext(); ) {
            Integer key = (Integer)itr.next();
            if(key == null)
                System.out.println("no key");
            else
                System.out.println("skey : " + key + ", value : " + map.getWithKey((Integer) key));
        }

        System.out.println("for-each구문 사용");
        for (Object n : map) {
            System.out.println("key : " + (Integer) n + ", value : " + map.getWithKey((Integer) n));
        }
    }
}

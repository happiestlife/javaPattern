package AdapterPattern;

import java.util.Iterator;

public class TestDynamicArray {
    public static void main(String[] args) {
        ObjectDynamicArray arr = new ObjectDynamicArray();
        arr.put("Seoul");
        arr.put("Busan");
        arr.put("Gwangju");
        arr.put("Daejeon");
        arr.put("Cheonan");
        arr.put("Ulsan");
        arr.put("Daegu");
        arr.put("Incheon");

        System.out.println("--index");
        for (int i = 0; i < arr.length(); i++) {
           String s = (String) arr.elemAt(i);
            System.out.println(s);
        }

        System.out.println("--iterator");
        for (Iterator iter = arr.createIterator(); iter.hasNext(); ) {
            String s = (String) iter.next();
            System.out.println(s);
        }
        System.out.println("<dynamic array>");
        DataCollection<String> arr1 = new DataCollectionAdapter<String>();
        arr1.put("Seoul");
        arr1.put("Busan");
        arr1.put("Gwangju");
        arr1.put("Daejeon");
        arr1.put("Cheonan");
        arr1.put("Ulsan");
        arr1.put("Daegu");
        arr1.put("Incheon");

        System.out.println("--index");
        for (int i = 0; i < arr1.length(); i++) {
            String s = (String) arr1.elemAt(i);
            System.out.println(s);
        }

        System.out.println("--iterator");
        for (Iterator iter = arr1.createIterator(); iter.hasNext(); ) {
            String s = (String) iter.next();
            System.out.println(s);
        }
    }
}

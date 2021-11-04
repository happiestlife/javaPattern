package AdapterPattern;

import java.util.Iterator;

public class DataCollectionAdapter<T> implements DataCollection<T>{
    private ObjectDynamicArray<T> arr;

    public DataCollectionAdapter(){
        arr = new ObjectDynamicArray<>();
    }

    @Override
    public boolean put(T t) {
        return arr.put(t);
    }

    @Override
    public T elemAt(int index) {
        return arr.elemAt(index);
    }

    @Override
    public int length() {
        return arr.length();
    }

    @Override
    public Iterator createIterator() {
        return arr.createIterator();
    }
}

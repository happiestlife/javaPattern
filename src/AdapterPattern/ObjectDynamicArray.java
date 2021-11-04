package AdapterPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class ObjectDynamicArray<T> implements DataCollection<T>{
    private ArrayList<T> list;
    public ObjectDynamicArray(){
        list = new ArrayList<>();
    }

    @Override
    public boolean put(T t) {
        list.add(t);
        return true;
    }

    @Override
    public T elemAt(int index) {
        if(list.size() < index)
            return null;
        else
            return list.get(index);
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public Iterator createIterator() {
        return new ObjectDynamicArrayIterator(this);
    }
}

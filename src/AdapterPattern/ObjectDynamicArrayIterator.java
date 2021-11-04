package AdapterPattern;

import java.util.Iterator;

public class ObjectDynamicArrayIterator<T> implements Iterator {
    private ObjectDynamicArray<T> arr;
    private int index;

    public ObjectDynamicArrayIterator(ObjectDynamicArray<T> arr){
        this.arr = arr;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < arr.length();
    }

    @Override
    public Object next() {
        return arr.elemAt(index++);
    }
}

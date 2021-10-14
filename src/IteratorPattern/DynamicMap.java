package IteratorPattern;

public class DynamicMap implements Iterable{
    private int SIZE_INCREMENT = 10;
    private int key_id[];
    private int value_100id[];
    private int size;
    private int count;

    public DynamicMap(){
        size = SIZE_INCREMENT;
        count = 0;
        key_id = new int[SIZE_INCREMENT];
        value_100id = new int[SIZE_INCREMENT];
    }

    public void input(int key, int value){
        if(size <= count){
            int tmp_key[] = new int[size + SIZE_INCREMENT];
            int tmp_value[] = new int[size + SIZE_INCREMENT];

            for(int i = 0; i < size; i++){
                tmp_key[i] = key_id[i];
                tmp_value[i] = value_100id[i];
            }
            size += SIZE_INCREMENT;
            
            key_id = tmp_key;
            value_100id = tmp_value;
        }
        key_id[count] = key;
        value_100id[count] = value;
        count++;
    }

    public int getWithKey(int key){
        int i;
        for(i = 0 ; i < count; i++) {
            if(key_id[i] == key){
                return value_100id[i];
            }
        }
        return -1;
    }

    public int getKeyWithIndex(int index){
        if(index <= count)
            return key_id[index];
        else {
            System.out.println("out of index");
            return -1;
        }
    }

    public int size(){
        return count;
    }

    public DynamicMapIterator iterator(){
        return new DynamicMapIterator(this);
    }


}

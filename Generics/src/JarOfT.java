import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JarOfT <E>{
    private static final int INITIAL_CAPACITY = 4;

    private E[] storedData;
    private int size;
    private int capacity;

    public JarOfT(Class<E> eClass)
    {
        this.storedData = (E[]) Array.newInstance(eClass, INITIAL_CAPACITY);
        capacity = INITIAL_CAPACITY;
    }

    public JarOfT(E[] storedData) {
        this.storedData = storedData;
        this.size = storedData.length;
        this.capacity = storedData.length;
    }

    public void add(E element)
    {
        this.expand();
        storedData[size++] = element;
    }

    public E remove()
    {
        E element = this.storedData[size];
        this.storedData = Arrays.copyOf(this.storedData, size-1);
        return element;
    }

    private void expand() {
        if(this.size + 1 >= capacity)
        {
            this.storedData = Arrays.copyOf(this.storedData, capacity*2);
            this.capacity *= 2;
        }
    }




}

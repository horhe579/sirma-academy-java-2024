import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomList <E extends Comparable>{

    private static final int INITIAL_CAPACITY = 4;
    private E[] elements;
    private int size = 0;
    private int capacity;

    public CustomList(Class<E> eClass) {
        this.elements = (E[]) Array.newInstance(eClass, INITIAL_CAPACITY);
        this.capacity = INITIAL_CAPACITY;
    }

    public CustomList(Class<E> eClass, int capacity)
    {
        this.elements = (E[]) Array.newInstance(eClass, capacity);
        this.capacity = capacity;
    }

    public void add(E element)
    {
        this.expand();
        elements[this.size++] = element;
    }

    private void expand() {
        if(this.size + 1 == capacity)
        {
            this.elements = (E[]) Arrays.copyOf(this.elements, )
        }
    }

    public E remove(int index)
    {

    }

    public boolean contains(E element)
    {

    }

    public void swap(int index, int index)
    {

    }

    public int countGreaterThan(E element)
    {

    }

    public E getMax()
    {

    }

    public E getMin()
    {

    }

}

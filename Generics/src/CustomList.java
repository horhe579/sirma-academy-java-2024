import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomList<E extends Comparable<E>> {

    private static final int INITIAL_CAPACITY = 4;
    private E[] elements;
    private int size = 0;
    private int capacity;

    public CustomList(Class<E> eClass) {
        this.elements = (E[]) Array.newInstance(eClass, INITIAL_CAPACITY);
        this.capacity = INITIAL_CAPACITY;
    }

    public CustomList(Class<E> eClass, int capacity) {
        this.elements = (E[]) Array.newInstance(eClass, capacity);
        this.capacity = capacity;
    }

    public void add(E element) {
        this.expand();
        elements[this.size++] = element;
    }

    private void expand() {
        if (this.size == capacity) {
            this.capacity *= 2;
            this.elements = Arrays.copyOf(this.elements, this.capacity);
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Clear the last element
        return removedElement;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    public int countGreaterThan(E element) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public E getMax() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        E max = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i].compareTo(max) > 0) {
                max = elements[i];
            }
        }
        return max;
    }

    public E getMin() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        E min = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i].compareTo(min) < 0) {
                min = elements[i];
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

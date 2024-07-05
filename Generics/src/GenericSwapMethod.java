import java.util.ArrayList;
import java.util.List;

class GenericSwapMethodStrings<E> {
    private List<E> elements = new ArrayList<>();

    public void append(E element) {
        elements.add(element);
        System.out.println(element.getClass().getName() + ": " + element);
    }

    public void swap(int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    @Override
    public String toString() {
        return (this.elements.getClass().getName() + ": " + this.elements);
    }
}

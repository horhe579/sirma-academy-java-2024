public class GenericScale<T extends Comparable<T>> {

    private T leftElement;
    private T rightElement;

    public GenericScale(T leftElement, T rightElement) {
        this.leftElement = leftElement;
        this.rightElement = rightElement;
    }

    public T getHeavier() {
        int result = leftElement.compareTo(rightElement);

        if (result < 0) {
            return rightElement;
        } else if (result > 0) {
            return leftElement;
        }
        return null;
    }
}

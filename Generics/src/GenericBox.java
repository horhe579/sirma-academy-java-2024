import java.util.List;

public class GenericBox <T extends Comparable> {
    private T storedData;

    public GenericBox(T storedData) {
        this.storedData = storedData;
    }

    public long compareDataToList(List<T> comparisonList)
    {
//        int count = 0;
//        for(T data : comparisonList)
//        {
//            if (this.storedData.compareTo(data) == 0)
//            {
//                count++;
//            }
//        }
        return comparisonList.stream().filter(t -> (this.storedData.compareTo(t) < 0)).count();
    }

    @Override
    public String toString() {
        return (this.storedData.getClass().getName() + ": " + this.storedData);
    }
}

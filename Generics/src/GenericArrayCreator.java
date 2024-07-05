import java.lang.reflect.Array;

public class GenericArrayCreator <E> {

    public static <E> E[] create(int length, E item)
    {
        E[] newArray = (E[]) Array.newInstance(item.getClass(), length);
        for (int i = 0; i < length; i++) {
            newArray[i] = item;
        }
        return newArray;
    }

    public static <E> E[] create(Class<E> tClass, int length, E item)
    {
        E[] newArray = (E[]) Array.newInstance(tClass, length);
        for (int i = 0; i < length; i++) {
            newArray[i] = item;
        }
        return newArray;
    }

}

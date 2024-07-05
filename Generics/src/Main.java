import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Integer[] array1 = GenericArrayCreator.create(5, 6);
//        Integer[] array2 = GenericArrayCreator.create(Integer.class, 5, 7);
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));

//        GenericScale<Double> scale = new GenericScale<>(2.1, 2.2);
//        System.out.println(scale.getHeavier());

//        GenericBox<String> box = new GenericBox<>("chicken in a box");
//        System.out.println(box);

//        GenericSwapMethodStrings<Integer> stringList = new GenericSwapMethodStrings<>();
//
//        stringList.append(1);
//        stringList.append(2);
//        stringList.append(3);
//        stringList.append(4);
//        stringList.append(5);
//
//        System.out.println("Before swap: " + stringList);
//
//        stringList.swap(1, 3);
//
//        System.out.println("After swap: " + stringList);

        GenericBox<Double> box1 = new GenericBox<>(7.55);
        System.out.println(box1.compareDataToList(Arrays.asList(42.78, 123.22, 7.13)));

    }
}

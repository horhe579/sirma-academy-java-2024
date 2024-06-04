public class Clock {
    public static void main(String[] args) {
        for (int i = 0; i < 24; i++)
        {
            for (int j = 0; j < 60; j++)
            {
                System.out.println(String.format("%02d", i) + ':' + String.format("%02d", j));
            }
        }
    }
}

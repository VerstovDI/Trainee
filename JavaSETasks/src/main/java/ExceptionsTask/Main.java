package ExceptionsTask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            if (arrayList.size() >= 10) {
                try {
                    if (arrayList.size() >= 10) {
                        throw new MyArrayListException("Only 10 elements to hold are possible");
                    }
                    arrayList.add(i);
                } catch (MyArrayListException arrayListException) {
                    arrayListException.printStackTrace();
                }
            }
            arrayList.add(i);
        }
    }
}

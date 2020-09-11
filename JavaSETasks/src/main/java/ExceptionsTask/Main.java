package ExceptionsTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            try {
                addToBoundedArray(arrayList, i);
            } catch (MyArrayListException arrayListException) {
                Locale.setDefault(Locale.FRANCE);
                System.err.println(arrayListException.getLocalizedMessage());
                System.err.println(arrayListException.getMessage());
                arrayListException.printStackTrace();
            }
        }
    }

    public static void addToBoundedArray(ArrayList<Integer> arrayList,
                                         Integer i) throws MyArrayListException {
        if (arrayList.size() < 10) {
            arrayList.add(i);
        } else {
            throw new MyArrayListException("Too many elements in the array!");
        }
    }

}

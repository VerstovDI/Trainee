package CollectionsTask;

import java.util.*;

public class CollectionsComparison {
    private static Random rnd = new Random(System.nanoTime());
    private static final long LOW    = 100;
    private static final long MEDIUM = 100000;
    private static final long HIGH   = 1000000000;

    public void compare(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList,
                               TreeSet<Integer> treeSet, HashSet<Integer> hashSet) {
        // Скорость операций добавления
        for (int i = 0; i < LOW; i++) {

        }
        // Скорость операций поиска
        // Скорость операций удаления
    }

    private long testAddMethod(Collection<Integer> collection, long element, long iterations) {
        long result = 0;
        return result;
    }

}

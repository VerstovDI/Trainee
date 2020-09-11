package CollectionsTask.CollectionsBenchmark.LinkedListBenchmark;


import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


import java.util.LinkedList;
import java.util.Random;

@State(Scope.Benchmark)
public class LinkedListInitialState {
    Random rnd = new Random(System.nanoTime());
    LinkedList<Integer> linkedList = new LinkedList<>();
    protected long iterations = 200;
    public static final int RANDOM_NUMBER = 500;
    int objectsIndex = 0;

    @Setup(Level.Trial)
    public void setUp() {
        for (long i = 0; i < iterations; i++) {
            linkedList.add(rnd.nextInt(RANDOM_NUMBER));
        }
        objectsIndex = linkedList.size();
    }
}

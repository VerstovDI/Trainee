package CollectionsTask.CollectionsBenchmark.TreeSetBenchmark;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

//@State(Scope.Benchmark)
public class TreeSetInitialState {
    Random rnd = new Random(System.nanoTime());
    TreeSet<Integer> treeSet = new TreeSet<>();
    public long iterations = 200;
    public static final int RANDOM_NUMBER = 500;

    //@Setup(Level.Trial)
    public void setUp() {
        for (long i = 0; i < iterations; i++) {
            treeSet.add(rnd.nextInt(RANDOM_NUMBER));
        }
    }
}

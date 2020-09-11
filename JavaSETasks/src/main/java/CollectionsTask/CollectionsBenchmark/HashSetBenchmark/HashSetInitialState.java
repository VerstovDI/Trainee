package CollectionsTask.CollectionsBenchmark.HashSetBenchmark;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.HashSet;
import java.util.Random;

//@State(Scope.Benchmark)
public class HashSetInitialState {
    Random rnd = new Random(System.nanoTime());
    HashSet<Integer> hashSet = new HashSet<>();
    public long iterations = 200;
    public static final int RANDOM_NUMBER = 500;

        //@Setup(Level.Trial)
        public void setUp() {
            for (long i = 0; i < iterations; i++) {
                hashSet.add(rnd.nextInt(RANDOM_NUMBER));
            }
        }
}

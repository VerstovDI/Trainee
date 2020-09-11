package CollectionsTask.CollectionsBenchmark.TreeSetBenchmark;

import CollectionsTask.CollectionsBenchmark.HashSetBenchmark.HashSetInitialState;
import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 1)
@Threads(value = 2)*/
public class TreeSetBenchmark {
    private static final Random rnd = new Random(System.nanoTime());

    //@Benchmark
    public void treeSetAdd(TreeSetInitialState state) {
        state.treeSet.add(rnd.nextInt(TreeSetInitialState.RANDOM_NUMBER));
    }

    //@Benchmark
    public void treeSetContains(TreeSetInitialState state) {
        state.treeSet.contains(rnd.nextInt(TreeSetInitialState.RANDOM_NUMBER));
    }

    //@Benchmark
    public void treeSetRemove(TreeSetInitialState state) {
        state.treeSet.remove(rnd.nextInt(TreeSetInitialState.RANDOM_NUMBER));
    }
}

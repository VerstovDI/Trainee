package CollectionsTask.CollectionsBenchmark.HashSetBenchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 1)
@Threads(value = 2)*/
public class HashSetBenchmark {
    private static final Random rnd = new Random(System.nanoTime());

    //@Benchmark
    public void hashSetAdd(HashSetInitialState state) {
        state.hashSet.add(rnd.nextInt(HashSetInitialState.RANDOM_NUMBER));
    }

    //@Benchmark
    public void hashSetContains(HashSetInitialState state) {
        state.hashSet.contains(rnd.nextInt(HashSetInitialState.RANDOM_NUMBER));
    }

    //@Benchmark
    public void hashSetRemove(HashSetInitialState state) {
        state.hashSet.remove(rnd.nextInt(HashSetInitialState.RANDOM_NUMBER));
    }
}

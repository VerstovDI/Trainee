package CollectionsTask.CollectionsBenchmark.LinkedListBenchmark;

import CollectionsTask.CollectionsBenchmark.ArrayListBenchmark.ArrayListInitialState;
import CollectionsTask.CollectionsBenchmark.ArrayListBenchmark.CollectionObject;
import CollectionsTask.CollectionsBenchmark.TreeSetBenchmark.TreeSetInitialState;
import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 1)
public class LinkedListBenchmark {
    private static final Random rnd = new Random(System.nanoTime());

    @Benchmark
    public void linkedListAdd(LinkedListInitialState state) {
        state.linkedList.add(rnd.nextInt(LinkedListInitialState.RANDOM_NUMBER));
    }

    @Benchmark
    public void linkedListAddAt(LinkedListInitialState state) {
        state.linkedList.add(rnd.nextInt(LinkedListInitialState.RANDOM_NUMBER/2),
                rnd.nextInt(LinkedListInitialState.RANDOM_NUMBER));
    }

    @Benchmark
    public Integer linkedListGet(LinkedListInitialState state) {
        return state.linkedList.get(rnd.nextInt(LinkedListInitialState.RANDOM_NUMBER));
    }

    @Benchmark
    public void linkedListRemove(LinkedListInitialState state) {
        state.linkedList.remove(rnd.nextInt(LinkedListInitialState.RANDOM_NUMBER));
    }
}

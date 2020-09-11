package CollectionsTask.CollectionsBenchmark.ArrayListBenchmark;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 1)
public class ArrayListBenchmark {
    private static final Random rnd = new Random(System.nanoTime());

    //@Benchmark
    public void benchAdd(ArrayListInitialState state) {
        state.arrayList.add(new CollectionObject("Object" + rnd.nextInt(),
                state.iterations));
    }

    //@Benchmark
    public void benchAddAt(ArrayListInitialState state) {
        state
                .arrayList
                .add((int) (state.iterations),
                        new CollectionObject(
                                "Object" + String.valueOf(rnd.nextInt()), state.iterations)
                );
    }

    //@Benchmark
    public CollectionObject benchGet(ArrayListInitialState state) {
        return state.arrayList.get(state.objectsIndex);
    }

    //@Benchmark
    public boolean benchRemove(ArrayListInitialState state) {
        return state.arrayList.remove(state.collectionObject);
    }
}

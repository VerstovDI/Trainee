package CollectionsTask;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class ArrayListInitialState {
    Random rnd = new Random(System.nanoTime());
    ArrayList<CollectionObject> arrayList = new ArrayList<>();
    protected long iterations = 1000;
    CollectionObject collectionObject
            = new CollectionObject("Object1", 123);
    int objectsIndex = 0;

    @Setup(Level.Trial)
    public void setUp() {
        for (long i = 0; i < iterations; i++) {
            arrayList.add(new CollectionObject(String.valueOf(rnd.nextInt()), rnd.nextInt()));
        }
        arrayList.add(collectionObject);
        objectsIndex = arrayList.indexOf(collectionObject);
    }
}

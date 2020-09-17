package ReflectionTasks;

public class Main {
    public static void main(String[] args) {
        SampleClass sampleClass = new SampleClass("Some string");
        MyTestRunner.run(SampleClass.class, sampleClass);
    }
}

package ReflectionTasks;

public class SampleClass {
    String objectFunc1Name;

    public SampleClass(String objectFunc1Name) {
        this.objectFunc1Name = objectFunc1Name;
    }

    @MyTest(name = "SampleClassInfoMethod")
    public String getInfo() {
        System.out.println(objectFunc1Name);
        return objectFunc1Name;
    }

    @MyTest
    public void doSomething() {
        System.out.println("do something");
    }

    @MyTest
    public void doSomething2() {
        System.out.println("do something 2");
    }
}

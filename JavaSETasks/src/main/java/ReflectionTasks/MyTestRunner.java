package ReflectionTasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestRunner {
    public static void run(Class testClass, SampleClass sampleClass) {
        int tests = 0;
        int passed = 0;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyTest.class)) { // ищем нашу аннотацию
                tests++;
                try {
                    m.invoke(sampleClass);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (IllegalAccessException exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}

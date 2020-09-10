package ReflectionTasks;

public class Main {
    public static void main(String[] args) {
        /*Reflection:
        -  реализовать свою собственную аннотацию,
                при использовании которой можно вызвать некоторую бизнес-логику
                (любую, которую вам захочется, самое простое вывод в консоль какой-то строки).*/
    }

    @KeyPhrase(keyPhrase = "Moscow is a city")
    public static String getKeyPhrase() {
        return null;
    }
}

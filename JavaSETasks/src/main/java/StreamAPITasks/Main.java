package StreamAPITasks;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);
        //System.out.println(getDevsWithUniqueLanguages(developerStream));
        developerStream.flatMap(developer -> developer.getLanguages().stream()
                .collect(Collectors.toMap(Function.identity(), e -> developer.getName())).entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .values().stream().filter(strings -> strings.size() == 1).map(strings -> strings.get(0)).collect(Collectors.toSet());
    }

    /*public static Collection<Developer> getDevsWithUniqueLanguages(Stream<Developer> devsStream) {
        return devsStream.flatMap(
                x -> x.getLanguages().stream().filter(
    }*/

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        //seen = new HashSet();

        return t -> seen.add(keyExtractor.apply(t));
    }

}

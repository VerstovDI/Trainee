package CollectionsTask.HashMapTask;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");
        System.out.println(hashMap);
        // Способ 1
        HashMap<String, Integer> reversedHashMap = reverse(hashMap);
        System.out.println(reversedHashMap);
        // Способ 2
        /*Map<Integer, String> swapped = hashMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));*/
        // Способ 3 (улучшение производительности при операции смены ключей на значения)
        // Можно попробовать хранить внутри класса две мапы, одна <K, V>, другая V,K
    }

    public static <K,V> HashMap<V,K> reverse(Map<K,V> map) {
        HashMap<V,K> rev = new HashMap<V, K>();
        for(Map.Entry<K,V> entry : map.entrySet())
            rev.put(entry.getValue(), entry.getKey());
        return rev;
    }
}

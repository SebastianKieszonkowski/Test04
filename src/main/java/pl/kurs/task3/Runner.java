package pl.kurs.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(59);
        integerList.add(null);
        integerList.add(17);
        integerList.add(null);
        integerList.add(4);
        integerList.add(888);
        integerList.add(6);
        integerList.add(147);
        integerList.add(13);
        integerList.add(22);

        List<Integer> integerList2 = List.of(59, 2, 17);

        System.out.println("Pięć największych liczb z listy to: " + getFiveTheGreaterElements(integerList));
    }

    public static List<Integer> getFiveTheGreaterElements(List<Integer> integerList) {
        return Optional.of(
                        Optional.ofNullable(integerList).orElseGet(Collections::emptyList)
                                .stream()
                                .filter(Objects::nonNull)
                                .sorted(Collections.reverseOrder())
                                .limit(5)
                                .collect(Collectors.toList())
                ).filter(x -> x.size() >= 5)
                .orElseGet(Collections::emptyList);

    }
}

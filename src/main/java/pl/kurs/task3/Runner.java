package pl.kurs.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(59, 2, 17, 4, 888, 6, 147, 13, 22);
        List<Integer> integerList2 = List.of(59, 2, 17);

        System.out.println(method(integerList2));

    }

    public static List<Integer> method(List<Integer> integerList) {
        return Optional.of(
                Optional.ofNullable(integerList).orElseGet(Collections::emptyList).stream()
                        .sorted(Collections.reverseOrder())
                        .limit(5)
                        .collect(Collectors.toList())
        ).filter(x -> x.size() >= 5)
                .orElseGet(Collections::emptyList);

    }
}

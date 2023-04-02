package pl.kurs.task1.services;

import pl.kurs.task1.models.MinMax;

import java.util.Collections;
import java.util.List;

public class MinMaxService {

    public static <T extends Comparable> MinMax<T> getMinAndMax(List<T> elements) {
        T max = (T) Collections.max(elements);
        T min = (T) Collections.min(elements);
        return new MinMax<T>(max, min);
    }
}

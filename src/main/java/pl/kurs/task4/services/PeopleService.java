package pl.kurs.task4.services;

import pl.kurs.task4.exception.NoWomenException;
import pl.kurs.task4.models.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PeopleService {

    public static Person findTheOldestWomen(List<Person> personList) throws NoWomenException {
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(x -> x.getName().endsWith("a"))
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new NoWomenException("Nie znaleziono najstarszej kobiety"));
    }

    public static double averageAge(List<Person> personList) {
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static double manAverageAge(List<Person> personList) {
        return averageAgeOfSpecificGender(personList, x -> !x.getName().endsWith("a"));
    }

    public static double womanAverageAge(List<Person> personList) {
        return averageAgeOfSpecificGender(personList, x -> x.getName().endsWith("a"));
    }

    public static double averageAgeOfSpecificGender(List<Person> personList, Predicate<Person> condition) {
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(condition)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static String citWitchTheGreaterNumberOfCitizen(List<Person> personList) {
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(x -> x.getCity() != null)
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(x -> x.getKey())
                .orElseThrow();
    }

    public static Set<String> citesList(List<Person> personList) {
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(x -> x.getCity() != null)
                .map(x -> x.getCity())
                .collect(Collectors.toSet());
    }
}

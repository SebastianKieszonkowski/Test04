package pl.kurs.task4.services;

import pl.kurs.task4.exception.NoWomenException;
import pl.kurs.task4.models.Person;
import pl.kurs.task4.models.Gender;

import java.util.*;
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
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(x -> !x.getName().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static double womanAverageAge(List<Person> personList) {
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(x -> x.getName().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static double averageAgeOfSpecificGender(List<Person> personList, Gender gender) {
        return gender == Gender.MALE ? manAverageAge(personList) : womanAverageAge(personList);
    }

    public static String citWitchTheGreaterNumberOfCitizen(List<Person> personList) {
        return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(x -> x.getBirthCity() != null)
                .collect(Collectors.groupingBy(Person::getBirthCity, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(x -> x.getKey())
                .orElseThrow();
    }

    public static Set<String> citesList(List<Person> personList) {
         return Optional.ofNullable(personList).orElse(Collections.emptyList()).stream()
                .filter(x -> x.getBirthCity() != null)
                .map(x -> x.getBirthCity())
                .collect(Collectors.toSet());
    }
}

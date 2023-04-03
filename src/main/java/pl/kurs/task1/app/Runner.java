package pl.kurs.task1.app;

import pl.kurs.task1.models.MinMax;
import pl.kurs.task1.models.Person;
import pl.kurs.task1.services.MinMaxService;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> stringList = List.of("Adam", "Zenek", "Robert", "Bogusław");
        System.out.println(MinMaxService.getMinAndMax(stringList));

        List<Integer> integerList = List.of(1, 7, 90, 120);
        System.out.println(MinMaxService.getMinAndMax(integerList));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Adam", "Bartosz", 32, 89.0));
        people.add(new Person("Jarosław", "Piwnicki", 17, 70.0));
        people.add(new Person("Roman", "Pawlak", 17, 85.0));
        people.add(new Person("Bolek", "Krawczyk", 10, 15.0));
        people.add(new Person("Karol", "Sobelski", 32, 89.0));

        MinMax<Person> minMax = MinMaxService.getMinAndMax(people);
        System.out.println(minMax.getMax());
        System.out.println(minMax.getMin());

    }
}

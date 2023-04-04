package pl.kurs.task4.app;

import pl.kurs.task4.models.Person;
import pl.kurs.task4.services.PeopleService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PeopleRunner {
    public static void main(String[] args) throws Exception {
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person("Marian", "Sulejman", "Warszawa", 37));
        peopleList.add(new Person("Wiesław", "Nowak", "Kozienice", 26));
        peopleList.add(new Person("Robert", "Traczyk", "Kozienice", 50));
        peopleList.add(new Person("Ada", "Kalbarczyk", "Kozienice", 31));
        peopleList.add(new Person("Karolina", "Turka", null, 42));
        peopleList.add(new Person("Julia", "Wawer", "Radom", 12));
        peopleList.add(new Person("Jarosław", "Dubacki", "Pionki", 60));
        peopleList.add(new Person("Grzegorz", "Lech", "Radom", 17));
        peopleList.add(new Person("Sylwia", "Gocłowska", "Piaseczno", 29));
        peopleList.add(new Person("Piotr", "Paluszek", "Kraków", 20));

        System.out.println("Najstarsza kobieta to: " + PeopleService.findTheOldestWomen(peopleList));
        System.out.println("Średnia wieku osób na liście to: " + PeopleService.averageAge(peopleList));
        System.out.println("Średni wiek mężczyzn z listy to: " + PeopleService.manAverageAge(peopleList));
        System.out.println("Średni wiek kobiet z listy to: " + PeopleService.womanAverageAge(peopleList));

        Predicate<Person> womanPredicate = x -> x.getName().endsWith("a");
        System.out.println("Średni wiek kobiet z listy to: " + PeopleService.averageAgeOfSpecificGender(peopleList, womanPredicate));

        System.out.println("Miasto z największą liczbą osób z listy to: " + PeopleService.citWitchTheGreaterNumberOfCitizen(peopleList));
        System.out.println("Lista miast występujących na liście to: " + PeopleService.citesList(peopleList));
    }
}

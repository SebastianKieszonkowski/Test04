package pl.kurs.task1.models;

public class Person implements Comparable<Person> {

    private String name;
    private String surname;
    private int age;
    private double weight;

    public Person(String name, String surname, int age, double weight) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person o) {
        int result = Integer.compare(age, o.age);
        if (result == 0)
            result = Double.compare(weight, o.weight);
        if (result == 0)
            result = o.surname.compareTo(surname);
        if (result == 0)
            result = o.name.compareTo(name);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

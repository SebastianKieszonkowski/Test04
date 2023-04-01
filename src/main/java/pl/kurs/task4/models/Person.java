package pl.kurs.task4.models;

public class Person {
    private String name;
    private String surname;
    private String birthCity;
    private int age;

    public Person(String name, String surname, String birthCity, int age) {
        this.name = name;
        this.surname = surname;
        this.birthCity = birthCity;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthCity='" + birthCity + '\'' +
                ", age=" + age +
                '}';
    }
}

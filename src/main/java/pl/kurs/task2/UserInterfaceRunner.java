package pl.kurs.task2;

import pl.kurs.task2.exception.InvalidPeselException;
import pl.kurs.task2.services.ValidatorService;

import java.util.Locale;
import java.util.Scanner;

public class UserInterfaceRunner {
    public static void main(String[] args) throws InvalidPeselException {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println("Podaj swoje imie:");
        String name = scanner.nextLine();
        System.out.println("Twoje imie ma długość: " + ValidatorService.nameLength(name).orElseGet(() -> 0));

        System.out.println("Podaj swój numer PESEL:");
        String pesel = scanner.nextLine();
        System.out.println("Twoja data urodzenia to: " + ValidatorService.getBirthFromPesel(pesel));
        scanner.close();
    }
}

package pl.kurs.task5;

import pl.kurs.task5.exception.InvalidBirthDateException;
import pl.kurs.task5.services.BirthService;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class BirthRunner {
    public static void main(String[] args) throws InvalidBirthDateException {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println("Podaj swoją datę urodzenia w formacie YYYY-MM-DD: ");
        String stringDateOfBirth = scanner.nextLine();
        scanner.close();

        LocalDate dateOfBirth = LocalDate.parse(stringDateOfBirth);
        BirthService.verifyDate(dateOfBirth);

        System.out.println("Żyjesz już " + BirthService.daysOld(dateOfBirth) + " dni.");
        System.out.println("Żyjesz już " + BirthService.monthsOld(dateOfBirth) + " miesięcy.");
        System.out.println("Żyjesz już " + BirthService.yearsOld(dateOfBirth) + " lat.");
        System.out.println("Dzień tygodnia w którym się urodziłeś/łaś to: " + BirthService.dayOfWeekYourBirth(dateOfBirth));
        System.out.println("Następny piątek 13-tegoo po twoich urodzinach był: " + BirthService.nextFriday13AfterYourBirth(dateOfBirth));


    }
}

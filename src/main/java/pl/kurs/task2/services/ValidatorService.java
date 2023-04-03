package pl.kurs.task2.services;

import pl.kurs.task2.exception.InvalidPeselException;

import java.time.LocalDate;
import java.util.Optional;

public class ValidatorService {

    public static Integer nameLength(String name) {
        return Optional.ofNullable(name)
                .map(String::length)
                .orElse(0);
    }

    public static LocalDate getBirthFromPesel(String pesel) throws InvalidPeselException {
        return Optional.ofNullable(pesel).filter(x -> x.length() == 11)
                .map(x -> x.substring(0,6))
                .map(ValidatorService::changStringToData)
                .orElseThrow(() -> new InvalidPeselException("Pesel niewłaściwy!"));
    }

    private static LocalDate changStringToData(String inputString) {
        int rawYear = Integer.parseInt(inputString.substring(0, 2));
        int monthAndCentury = Integer.parseInt(inputString.substring(2, 4));
        int day = Integer.parseInt(inputString.substring(4));

        int year;
        int month;
        switch (monthAndCentury / 10) {
            case 8, 9 -> {
                year = 1800 + rawYear;
                month = monthAndCentury - 80;
            }
            case 2, 3 -> {
                year = 2000 + rawYear;
                month = monthAndCentury - 20;
            }
            case 4, 5 -> {
                year = 2100 + rawYear;
                month = monthAndCentury - 40;
            }
            default -> {
                year = 1900 + rawYear;
                month = monthAndCentury;
            }
        }
        return LocalDate.of(year, month, day);
    }
}

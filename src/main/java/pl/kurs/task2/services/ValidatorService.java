package pl.kurs.task2.services;

import pl.kurs.task2.exception.InvalidPeselException;

import java.time.LocalDate;
import java.util.Optional;

public class ValidatorService {

    public static Optional<Integer> nameLength(String name) {
        if (name.isEmpty())
            return Optional.empty();
        return Optional.of(name.length());
    }

    public static LocalDate getBirthFromPesel(String pesel) throws InvalidPeselException {
        if (pesel == null || pesel.length() != 11)
            throw new InvalidPeselException("Pesel niewłaściwy!");
        return changStringToData(pesel.substring(0, 6));
    }

    private static LocalDate changStringToData(String inputString) {
        int lastTwoNumberYear = Integer.parseInt(inputString.substring(0, 2));
        int monthAndCentury = Integer.parseInt(inputString.substring(2, 4));
        int day = Integer.parseInt(inputString.substring(4));

        int year;
        int month;
        switch (monthAndCentury / 10) {
            case 8, 9 -> {
                year = 1800 + lastTwoNumberYear;
                month = monthAndCentury - 80;
            }
            case 2, 3 -> {
                year = 2000 + lastTwoNumberYear;
                month = monthAndCentury - 20;
            }
            case 4, 5 -> {
                year = 2100 + lastTwoNumberYear;
                month = monthAndCentury - 40;
            }
            default -> {
                year = 1900 + lastTwoNumberYear;
                month = monthAndCentury;
            }
        }
        return LocalDate.of(year, month, day);
    }
}

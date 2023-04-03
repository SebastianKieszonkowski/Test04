package pl.kurs.task5.services;

import pl.kurs.task5.exception.InvalidBirthDateException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BirthService {

    static final LocalDate actualData = LocalDate.now();

    public static void verifyDate(LocalDate birthDate) throws InvalidBirthDateException {
        if (birthDate.isAfter(actualData))
            throw new InvalidBirthDateException("Podałeś złą date!");
    }

    public static Long daysOld(LocalDate birthDate) {
        return ChronoUnit.DAYS.between(birthDate, actualData);
    }

    public static Long monthsOld(LocalDate birthDate) {
        return ChronoUnit.MONTHS.between(birthDate, actualData);
    }

    public static Long yearsOld(LocalDate birthDate) {
        return ChronoUnit.YEARS.between(birthDate, actualData);
    }

    public static DayOfWeek dayOfWeekYourBirth(LocalDate birthDate) {
        return birthDate.getDayOfWeek();
    }

    public static LocalDate nextFriday13AfterYourBirth(LocalDate birthDate) {
        LocalDate dateOfFirstFriday13;
        LocalDate startDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), 13);
        int monthCounter = 0;
        while (true) {
            LocalDate iterationData = startDate.plusMonths(monthCounter);
            if (iterationData.getDayOfWeek() == DayOfWeek.FRIDAY && birthDate.isBefore(iterationData)) {
                dateOfFirstFriday13 = iterationData;
                break;
            } else
                monthCounter++;
        }
        return dateOfFirstFriday13;
    }
}

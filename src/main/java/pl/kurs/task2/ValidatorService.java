package pl.kurs.task2;

import pl.kurs.task2.exception.InvalidPeselException;

import java.util.Optional;

public class ValidatorService {

    public static Optional<Integer> nameLength(String name) {
        if (name.isEmpty())
            return Optional.empty();
        return Optional.of(name.length());
    }

    public static String getBirthFromPesel(String pesel) throws InvalidPeselException{
        if (pesel.length() != 11)
            throw new InvalidPeselException("Pesel niewłaściwy!");
        return pesel.substring(0,6);
    }
}

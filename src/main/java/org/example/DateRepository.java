package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateRepository  implements IDateSorter{

    private final static List<Month> patternWithoutR = Arrays.asList(Month.AUGUST, Month.JULY, Month.JUNE, Month.MAY);
    private final static List<Month> patternWithR = Arrays.asList(Month.APRIL, Month.DECEMBER, Month.FEBRUARY,
            Month.JANUARY, Month.MARCH, Month.NOVEMBER,
            Month.OCTOBER, Month.SEPTEMBER);
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        // adding to a new collection and revers sorting months without R in the name
        Collection<LocalDate> listOfMonthWithoutR = unsortedDates
                .stream().
                filter(month -> patternWithoutR.contains(month.getMonth())).toList();

        Collection<LocalDate> sortedWithoutR = listOfMonthWithoutR
                .stream()
                .sorted()
                .toList();

        // adding to a new collection and sorting months with R in the name
        Collection<LocalDate> listOfMonthWithR = unsortedDates
                .stream()
                .filter(month -> patternWithR.contains(month.getMonth())).toList();

        Collection<LocalDate> sortedDateWithR = listOfMonthWithR.stream()
                .sorted()
                .toList();

        return Stream.of(sortedDateWithR, sortedWithoutR)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}

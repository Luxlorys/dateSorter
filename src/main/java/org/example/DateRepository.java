package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class DateRepository  implements IDateSorter{

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        List<Month> patternWithoutR = Arrays.asList(Month.AUGUST, Month.JULY, Month.JUNE, Month.MAY);
        List<Month> patternWithR = Arrays.asList(Month.APRIL, Month.DECEMBER, Month.FEBRUARY,
                Month.JANUARY, Month.MARCH, Month.NOVEMBER,
                Month.OCTOBER, Month.SEPTEMBER);

        // adding to a new collection and revers sorting months without R in the name
        Collection<LocalDate> listOfMonthWithoutR = unsortedDates
                .stream().
                filter(month -> patternWithoutR.contains(month.getMonth()))
                .sorted()
                .toList();



        // adding to a new collection and sorting months with R in the name
        Collection<LocalDate> listOfMonthWithR = unsortedDates
                .stream()
                .filter(month -> patternWithR.contains(month.getMonth())).sorted().toList();


        return Stream.of(listOfMonthWithR, listOfMonthWithoutR)
                .flatMap(Collection::stream)
                .toList();
    }
}

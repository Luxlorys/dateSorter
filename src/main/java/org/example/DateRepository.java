package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DateRepository  implements IDateSorter{
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<Month> patternWithoutR = Arrays.asList(Month.AUGUST, Month.JULY, Month.JUNE, Month.MAY);
        List<Month> patternWithR = Arrays.asList(Month.APRIL, Month.DECEMBER, Month.FEBRUARY,
                                                Month.JANUARY, Month.MARCH, Month.NOVEMBER,
                                                Month.OCTOBER, Month.SEPTEMBER);

        Collection<LocalDate> sortedDates;

        Collection<LocalDate> listOfMonthWithoutR = unsortedDates
                .stream().
                filter(month -> patternWithoutR.contains(month.getMonth())).toList();

        Collection<LocalDate> listOfMonthWithR = unsortedDates.
                stream().
                filter(month -> patternWithR.contains(month.getMonth())).toList();

        listOfMonthWithR.addAll(listOfMonthWithoutR);
        return listOfMonthWithoutR;
    };
}

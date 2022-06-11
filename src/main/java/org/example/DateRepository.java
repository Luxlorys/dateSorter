package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DateRepository  implements IDateSorter{

    private final static List<Month> patternWithoutR = Arrays.asList(Month.AUGUST, Month.JULY, Month.JUNE, Month.MAY);
    private final static List<Month> patternWithR = Arrays.asList(Month.APRIL, Month.DECEMBER, Month.FEBRUARY,
            Month.JANUARY, Month.MARCH, Month.NOVEMBER,
            Month.OCTOBER, Month.SEPTEMBER);
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        Collection<LocalDate> listOfMonthWithoutR = unsortedDates
                .stream().
                filter(month -> patternWithoutR.contains(month.getMonth())).toList();


        Collection<LocalDate> listOfMonthWithR = unsortedDates.
                stream().
                filter(month -> patternWithR.contains(month.getMonth())).toList(); // all months with R in name

        return listOfMonthWithR.stream().sorted().toList();

    };

}

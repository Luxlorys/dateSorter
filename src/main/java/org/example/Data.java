package org.example;

import java.time.LocalDate;

public class Data {

    private final LocalDate localDate;

    public Data(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}

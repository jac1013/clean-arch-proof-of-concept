package com.airline.business.seat;

public enum SeatType {
    REGULAR("R"),
    EMERGENCY("E"),
    FIRST_CLASS("FC"),
    SPECIAL_NEEDS("SN");
    private  String code;

    SeatType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}

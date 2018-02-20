package com.airline.business.passenger;

public enum PassengerType {
    STANDARD("S"),
    SPECIAL_NEEDS("SN"),
    VIP("VIP");
    private String code;

    PassengerType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}

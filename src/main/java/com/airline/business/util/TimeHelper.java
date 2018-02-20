package com.airline.business.util;

import java.time.Duration;
import java.time.Instant;

public class TimeHelper {
    public static Instant getTimeAfterHours(int hours) {
        return Instant.now().plus(Duration.ofHours(hours));
    }
}

package net.wind.anemometr.util;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static java.util.Objects.isNull;

public class CommonUtils {
    public static Instant truncate(final Instant instant) {
        if (isNull(instant)) {
            return null;
        }

        return instant.truncatedTo(ChronoUnit.SECONDS);
    }
}

package baeldung.iteratorEnum;

import java.util.stream.Stream;

/**
 * Created by shengchao wu on 7/19/2018.
 */
public enum DayOfWeekEnum {
    SUNDAY("off"),
    MONDAY("working"),
    TUESDAY("working"),
    WEDNESDAY("working"),
    THURSDAY("working"),
    FRIDAY("working"),
    SATURDAY("off");

    private String typeOfDay;

    DayOfWeekEnum(String typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    public static Stream<DayOfWeekEnum> stream() {
        return Stream.of(DayOfWeekEnum.values());
    }

    public String getTypeOfDay() {
        return typeOfDay;
    }
}

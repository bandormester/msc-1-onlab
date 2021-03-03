package hu.szurdok.msc.booking.model.misc;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;


@Getter
@Setter
public class DailyOpening {
    private Boolean isOpen;
    private LocalTime open;
    private LocalTime close;
    private DayOfWeek day;

    public DailyOpening(Boolean isOpen, LocalTime open, LocalTime close, DayOfWeek day){
        this.isOpen = isOpen;
        this.open = open;
        this.close = close;
        this.day = day;
    }
}

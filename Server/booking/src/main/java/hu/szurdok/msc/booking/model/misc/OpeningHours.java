package hu.szurdok.msc.booking.model.misc;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OpeningHours {
    private List<DailyOpening> openHours;

    public OpeningHours(){
        openHours = new ArrayList<>(7);

        for(DayOfWeek day : DayOfWeek.values()){
            openHours.add(
                    new DailyOpening(false, null, null, day)
            );
        }
    }

    private void setDailyOpen(Boolean isOpen, LocalTime open, LocalTime close, DayOfWeek day){
        for(DailyOpening opening : openHours){
            if(opening.getDay().equals(day)){
                opening.setIsOpen(isOpen);
                opening.setOpen(open);
                opening.setClose(close);
            }
        }
    }
}

package hu.szurdok.msc.booking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    private Long businessId;    //a servicere és a businessre is szeretnék értékelést, bar a serviceben is van business id, a serviceket torolhetore

    private Long serviceId;     //szeretnem megvalositani, viszont nem akarom, hogy a service torlesevel elvesszen az ertekeles

    private Long userId;

    private Float punctuality;

    private Float quality;

    private Float environment;
}

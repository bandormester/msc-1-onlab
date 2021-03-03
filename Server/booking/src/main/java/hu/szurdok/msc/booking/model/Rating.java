package hu.szurdok.msc.booking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rating {
    @Id
    private Long id;
    @Column
    private Long businessId;    //a servicere és a businessre is szeretnék értékelést, bar a serviceben is van business id, a serviceket torolhetore
    @Column
    private Long serviceId;     //szeretnem megvalositani, viszont nem akarom, hogy a service torlesevel elvesszen az ertekeles
    @Column
    private Long userId;
    @Column
    private Float punctuality;
    @Column
    private Float quality;
    @Column
    private Float environment;
}

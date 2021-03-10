package hu.szurdok.msc.booking.model;

import hu.szurdok.msc.booking.model.misc.OpeningHours;
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
public class Business {
    @Id
    private Long id;
    @Column
    private String name;
    //@Column
    //private OpeningHours openingHours;  //serializalva tarolva
    @Column
    private String description;
}

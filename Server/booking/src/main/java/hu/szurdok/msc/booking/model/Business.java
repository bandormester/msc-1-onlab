package hu.szurdok.msc.booking.model;

import hu.szurdok.msc.booking.model.misc.OpeningHours;
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
public class Business {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Column
    private OpeningHours openingHours;  //serializalva tarolva

    private String description;
}

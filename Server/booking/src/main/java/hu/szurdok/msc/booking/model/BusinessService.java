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
public class BusinessService {
    @Id
    @GeneratedValue
    private Long id;

    private Long businessId;

    private String name;

    private String description;

    private Integer duration;   //perceket fog jelenteni

    private Float price;

    private Boolean available;
}

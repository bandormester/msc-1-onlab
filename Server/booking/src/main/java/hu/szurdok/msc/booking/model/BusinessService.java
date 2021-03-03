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
public class BusinessService {
    @Id
    private Long id;
    @Column
    private Long businessId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Integer duration;   //perceket fog jelenteni
    @Column
    private Float price;
    @Column
    private Boolean available;
}

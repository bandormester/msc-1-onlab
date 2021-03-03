package hu.szurdok.msc.booking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PastBooking extends Booking{
    @Column
    private Boolean isSuccess;
    @Column
    private Long ratingId;
}

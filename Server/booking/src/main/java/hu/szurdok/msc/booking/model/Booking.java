package hu.szurdok.msc.booking.model;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    private Long serviceId;

    private Long userId;

    private LocalDateTime startTime;

    private String message;
}

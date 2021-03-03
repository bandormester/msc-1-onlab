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
public class User {
    @Id
    private Long id;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String fullName;
    @Column
    private String password;    //az autentikaciorol nem tudom meg hogy lesz
}

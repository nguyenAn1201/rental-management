package com.example.rentalmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false) private String firstName;

    @Column(name = "last_name", nullable = false) private String lastName;

    @Column(name = "phone_number", nullable = false) private String phoneNumber;

    @Column(name = "email", nullable = false) private String email;

    @Column(name = "created_at") @Temporal(value = TemporalType.TIMESTAMP) private Date createdAt;

    @Column(name = "updated_at") @Temporal(value = TemporalType.TIMESTAMP) private Date updatedAt;

    @Override
    public String toString() {
        return String.format(
            "Owner[id= '%d', firstName: '%s', lastName: '%s', phoneNo: '%s', email: '%s']",
            id, firstName, lastName, phoneNumber, email);
    }
}

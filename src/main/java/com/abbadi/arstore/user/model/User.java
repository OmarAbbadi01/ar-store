package com.abbadi.arstore.user.model;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ar_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "userSequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "userSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false)
    private UserType userType;

}

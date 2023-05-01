package com.abbadi.arstore.account.model;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "accountSequence", sequenceName = "account_sequence", allocationSize = 1)
    @GeneratedValue(generator = "accountSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "account_type", nullable = false)
    private AccountType accountType;
}

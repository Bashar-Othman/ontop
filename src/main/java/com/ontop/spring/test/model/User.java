package com.ontop.spring.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        })
@Data
public class User implements Serializable {

    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    @JsonProperty("name")
    private String username;

    private Long userId;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    @Column
    private BigDecimal walletAmount;

    public User() {
    }

    public User(String username, String email, String password, BigDecimal walletAmount) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.walletAmount = walletAmount;
    }

}

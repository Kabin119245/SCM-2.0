package com.scm.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(length = 10000)
    private String about;
    @Column(length = 10000)
    private String profilePic;
    private String phoneNumber;

    //information
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    //self, google, facebook,linkedin
    private Providers provider=Providers.SELF;
    private String providerUserId;


    //add more fields if needed

    //one-to-many relation to Contact class(one person has many contacts)
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();




}

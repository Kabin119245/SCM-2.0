package com.scm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {

    @Id
    private String id;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String contactAddress;
    private String picture;
    @Column(length = 10000)
    private String description;

    private boolean favourite = false;
    private String websiteLink;


    @ManyToOne
    private User user;


    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();
}

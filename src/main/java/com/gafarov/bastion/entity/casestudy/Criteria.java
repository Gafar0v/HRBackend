package com.gafarov.bastion.entity.casestudy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Criteria {
    @Id
    private Integer id;
    private String criteria;

}
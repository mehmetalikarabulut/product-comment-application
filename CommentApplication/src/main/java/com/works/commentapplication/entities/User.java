package com.works.commentapplication.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Data
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Length(max = 50)
    private String name;

    @Length(max = 50)
    private String surname;

    @Length(max = 50)
    @Email
    private String email;

    @Length(max = 15)
    private String phone;
}

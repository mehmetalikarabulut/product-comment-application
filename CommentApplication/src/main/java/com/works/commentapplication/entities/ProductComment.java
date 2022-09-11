package com.works.commentapplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ProductComment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Length(max = 500)
    private String comment;

    @CreationTimestamp
    private Date createdTime;

    @ManyToOne
    private Product product;

    @OneToOne
    private User user;
}

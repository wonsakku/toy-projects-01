package com.example.toy_01.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "classification")
public class Classification extends TimeBaseEntity{


    @Id @GeneratedValue
    @Column(name = "classification_id")
    private Long id;

    private String name;

}

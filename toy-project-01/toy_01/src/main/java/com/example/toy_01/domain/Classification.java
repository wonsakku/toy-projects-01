package com.example.toy_01.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "classification")
public class Classification extends TimeBaseEntity{


    @Id @GeneratedValue
    @Column(name = "classification_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "classification")
    private List<ContentClassification> contentClassifications = new ArrayList<>();



    public Classification(String name) {
        this.name = name;
    }
}

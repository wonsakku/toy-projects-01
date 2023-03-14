package com.example.toy_01.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "content_classification")
public class ContentClassification  extends TimeBaseEntity{

    @Id @GeneratedValue
    @Column(name = "content_classification_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private Classification classification;

    public ContentClassification(Content content, Classification classification) {
        this.content = content;
        this.classification = classification;
    }
}

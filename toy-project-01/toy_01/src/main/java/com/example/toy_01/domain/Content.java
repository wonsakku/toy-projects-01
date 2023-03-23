package com.example.toy_01.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "content")
public class Content extends TimeBaseEntity{

    @Id @GeneratedValue
    @Column(name = "content_id")
    private Long id;

    private String reference;

    @NotNull
    @Column(name = "body", length = 2000)
    private String body;

    // ToMany 는 Lazy Fetch 가 default
    @OneToMany(mappedBy = "content", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContentClassification> contentClassifications = new ArrayList<>();


    public Content(String reference, String body) {
        this.reference = reference;
        this.body = body;
    }


    public static Content toInsertEntity(String reference, String body) {
        return new Content(reference, body);
    }


}


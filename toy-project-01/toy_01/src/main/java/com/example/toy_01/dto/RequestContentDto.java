package com.example.toy_01.dto;

import com.example.toy_01.domain.Content;
import lombok.Data;

import java.util.List;

@Data
public class RequestContentDto {

    private String reference;
    private String body;
    private  List<Long> classificationIds;

    public RequestContentDto(String reference, String body, List<Long> classificationIds) {
        this.reference = reference;
        this.body = body;
        this.classificationIds = classificationIds;
    }

    public Content toInsertEntity() {
        return Content.toInsertEntity(this.reference, this.body);
    }
}

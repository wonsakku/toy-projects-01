package com.example.toy_01.dto;

import com.example.toy_01.domain.Content;
import lombok.Data;

import java.util.List;

@Data
public class RequestContentDto {

    private String reference;
    private String body;

    public RequestContentDto(String reference, String body) {
        this.reference = reference;
        this.body = body;
    }

    public Content toInsertEntity() {
        return Content.toInsertEntity(this.reference, this.body);
    }
}

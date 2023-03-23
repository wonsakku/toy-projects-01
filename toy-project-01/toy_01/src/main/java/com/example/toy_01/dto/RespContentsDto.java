package com.example.toy_01.dto;

import com.example.toy_01.constants.Time;
import com.example.toy_01.domain.Content;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RespContentsDto {

    private Long id;
    private String reference;
    private String body;

    private List<RespClassificationDto> classifications;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Time.DEFAULT_PATTERN, timezone = Time.ZONE_ASIA_SEOUL)
    private LocalDateTime createdDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Time.DEFAULT_PATTERN, timezone = Time.ZONE_ASIA_SEOUL)
    private LocalDateTime modifiedDateTime;

    public RespContentsDto(Content entity){
        this.id = entity.getId();
        this.reference = entity.getReference();
        this.body = entity.getBody();
        this.classifications = entity.getContentClassifications()
                .stream()
                .map(contentClassification -> new RespClassificationDto(contentClassification.getClassification()))
                .collect(Collectors.toList());
        this.createdDateTime = entity.getCreatedDateTime();
        this.modifiedDateTime = entity.getModifiedDateTime();
    }

}

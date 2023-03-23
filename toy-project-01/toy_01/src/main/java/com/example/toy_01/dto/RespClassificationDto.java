package com.example.toy_01.dto;

import com.example.toy_01.domain.Classification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespClassificationDto {

    private Long id;
    private String name;

    public RespClassificationDto(Classification entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }
}






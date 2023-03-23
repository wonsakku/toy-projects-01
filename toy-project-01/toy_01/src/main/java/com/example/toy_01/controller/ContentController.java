package com.example.toy_01.controller;

import com.example.toy_01.domain.Content;
import com.example.toy_01.dto.RequestContentDto;
import com.example.toy_01.dto.RespContentsDto;
import com.example.toy_01.service.ContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/contents")
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    public ResponseEntity saveContent(@RequestBody @Validated RequestContentDto contentDto,
                                      Errors errors){
        if(errors.hasErrors()){
            throw new IllegalArgumentException(errors.getFieldError().getDefaultMessage());
        }
        contentService.save(contentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("생성되었습니다.");
    }

    @GetMapping
    public ResponseEntity findContents(){

        List<RespContentsDto> results = contentService.findContents();

        return ResponseEntity.ok(results);
    }


}

package com.example.toy_01.controller;

import com.example.toy_01.domain.Classification;
import com.example.toy_01.dto.RespClassificationDto;
import com.example.toy_01.repository.ClassificationRepository;
import com.example.toy_01.service.ClassificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/classifications")
public class ClassificationController {

    private final ClassificationService classificationService;

    @GetMapping("/select-box")
    public ResponseEntity<List<RespClassificationDto>> classificationSelectBox(){
        List<Classification> classifications = classificationService.findAll();

        List<RespClassificationDto> results = classifications.stream()
                .map(RespClassificationDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(results);
    }



}

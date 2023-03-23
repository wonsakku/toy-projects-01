package com.example.toy_01.service;

import com.example.toy_01.domain.Classification;
import com.example.toy_01.repository.ClassificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
@Service
public class ClassificationService {

    private final ClassificationRepository classificationRepository;


    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }
}

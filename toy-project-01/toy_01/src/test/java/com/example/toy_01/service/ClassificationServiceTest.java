package com.example.toy_01.service;

import com.example.toy_01.domain.Classification;
import com.example.toy_01.repository.ClassificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ClassificationServiceTest {

    @Autowired
    ClassificationService classificationService;
    @Autowired
    ClassificationRepository classificationRepository;


    @BeforeEach
    void init() {
        classificationRepository.save(new Classification("분류1"));
        classificationRepository.save(new Classification("분류2"));
    }

    @Test
    void findAllTest(){
        List<Classification> findAll = classificationService.findAll();
        assertThat(findAll).hasSize(2);
        for (Classification classification : findAll) {
            System.out.println("ID : " + classification.getId());
            System.out.println("name : " + classification.getName());
        }
    }

}
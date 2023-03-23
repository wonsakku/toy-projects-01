package com.example.toy_01.service;

import com.example.toy_01.domain.Classification;
import com.example.toy_01.domain.Content;
import com.example.toy_01.domain.ContentClassification;
import com.example.toy_01.dto.RequestContentDto;
import com.example.toy_01.dto.RespContentsDto;
import com.example.toy_01.repository.ClassificationRepository;
import com.example.toy_01.repository.ContentClassificationRepository;
import com.example.toy_01.repository.ContentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Transactional
@SpringBootTest
class ContentServiceTest {

    @Autowired ContentService contentService;
    @Autowired EntityManager em;

    List<Long> classificationIds = new ArrayList<>();
    List<Long> classificationIds2 = new ArrayList<>();

    @BeforeEach
    void init(){
        classificationIds.clear();
        classificationIds2.clear();

        Classification c1 = new Classification("테스트_classification_01");
        Classification c2 = new Classification("테스트_classification_02");
        em.persist(c1);
        em.persist(c2);

        Classification c3 = new Classification("테스트_classification_03");
        Classification c4 = new Classification("테스트_classification_04");
        em.persist(c3);
        em.persist(c4);

        classificationIds.add(c1.getId());
        classificationIds.add(c2.getId());
        classificationIds2.add(c3.getId());
        classificationIds2.add(c4.getId());
    }


    @Test
    @DisplayName("저장 테스트")
    void save_Test(){

        //given
        RequestContentDto dto = new RequestContentDto("슬램덩크 애장판 13권 - 009페이지",
                "채치수 : 항상 폼을 체크해야 해! 지금이 가장 중요한 때다!! " +
                "틀린 폼으로 아무리 연습해봤자 소용없어!!\n" +
                "강백호 : 기본이 중요!! 그렇죠? 고릴라!\n" +
                "채치수 : 그래. 어쨌거나 반복이다. 반복하고 반복해서 몸에 익숙해지도록 하는 수밖에 없다!!", classificationIds);

        Long savedId = contentService.save(dto);

        em.flush();
        em.clear();

        // when
        Content findById = contentService.findById(savedId);
        List<ContentClassification> findByIds = em.createQuery("SELECT cc " +
                        " FROM ContentClassification cc " +
                        " JOIN cc.classification c " +
                        " WHERE c.id IN :classificationIds "
                        , ContentClassification.class)
                .setParameter("classificationIds", classificationIds)
                .getResultList();

        // then
        assertThat(findById).isNotNull();
        assertThat(findById.getReference()).isEqualTo(dto.getReference());
        assertThat(findById.getBody()).isEqualTo(dto.getBody());
        assertThat(findById.getCreatedDateTime()).isNotNull();
        assertThat(findById.getModifiedDateTime()).isNotNull();
        assertThat(findByIds).hasSize(classificationIds.size());
    }


    @Test
    @DisplayName("존재하지 않는 ID로 content 조회 시 findById 예외 테스트")
    void findById_Exception_Test(){
        RequestContentDto dto = new RequestContentDto("테스트 레퍼런스", "테스트 바디", classificationIds);
        Long savedId = contentService.save(dto);
        final Long notExistContentId = savedId + 1;

        em.flush();
        em.clear();

        assertThatThrownBy(() -> {
            contentService.findById(notExistContentId);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("존재하지 않는 content_id 입니다.");
    }

    @Test
    @DisplayName("content List 조회 테스트")
    void findContents(){
        RequestContentDto dto = new RequestContentDto("테스트 레퍼런스", "테스트 바디", classificationIds);
        RequestContentDto dto2 = new RequestContentDto("테스트 레퍼런스2", "테스트 바디2", classificationIds2);

        contentService.save(dto);
        contentService.save(dto2);

        em.flush();
        em.clear();

        List<RespContentsDto> contents = contentService.findContents();

        for (RespContentsDto content : contents) {
            assertThat(content.getId()).isNotNull();
            assertThat(content.getReference()).isNotNull();
            assertThat(content.getBody()).isNotNull();
            assertThat(content.getCreatedDateTime()).isNotNull();
            assertThat(content.getModifiedDateTime()).isNotNull();
            assertThat(content.getClassifications()).hasSize(2);
        }
    }

}


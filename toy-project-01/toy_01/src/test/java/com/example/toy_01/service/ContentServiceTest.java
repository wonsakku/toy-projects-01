package com.example.toy_01.service;

import com.example.toy_01.domain.Content;
import com.example.toy_01.dto.RequestContentDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ContentServiceTest {

    @Autowired ContentService contentService;
    @Autowired EntityManager em;

    @Test
    @DisplayName("저장 테스트")
    void save_Test(){

        //given
        RequestContentDto dto = new RequestContentDto("슬램덩크 애장판 13권 - 009페이지",
                "채치수 : 항상 폼을 체크해야 해! 지금이 가장 중요한 때다!! " +
                "틀린 폼으로 아무리 연습해봤자 소용없어!!\n" +
                "강백호 : 기본이 중요!! 그렇죠? 고릴라!\n" +
                "채치수 : 그래. 어쨌거나 반복이다. 반복하고 반복해서 몸에 익숙해지도록 하는 수밖에 없다!!");

        Long savedId = contentService.save(dto);

        em.flush();
        em.clear();

        // when
        Content findById = contentService.findById(savedId);

        // then
        assertThat(findById).isNotNull();
        assertThat(findById.getReference()).isEqualTo(dto.getReference());
        assertThat(findById.getBody()).isEqualTo(dto.getBody());
        assertThat(findById.getCreatedDateTime()).isNotNull();
        assertThat(findById.getModifiedDateTime()).isNotNull();
    }

    @Test
    @DisplayName("존재하지 않는 ID로 content 조회 시 findById 예외 테스트")
    void findById_Exception_Test(){
        RequestContentDto dto = new RequestContentDto("테스트 레퍼런스", "테스트 바디");
        Long savedId = contentService.save(dto);
        final Long notExistContentId = savedId + 1;

        em.flush();
        em.clear();

        assertThatThrownBy(() -> {
            contentService.findById(notExistContentId);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("존재하지 않는 content_id 입니다.");
    }

}


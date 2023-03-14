package com.example.toy_01.service;

import com.example.toy_01.domain.Classification;
import com.example.toy_01.domain.Content;
import com.example.toy_01.domain.ContentClassification;
import com.example.toy_01.dto.RequestContentDto;
import com.example.toy_01.repository.ClassificationRepository;
import com.example.toy_01.repository.ContentClassificationRepository;
import com.example.toy_01.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ContentService {

    private final ContentRepository contentRepository;
    private final ClassificationRepository classificationRepository;
    private final ContentClassificationRepository contentClassificationRepository;


    @Transactional
    public Long save(RequestContentDto dto) {

        Content content = dto.toInsertEntity();
        List<Long> classificationIds = dto.getClassificationIds();

        // content 저장
        contentRepository.save(content);

        // classification 조회
        List<Classification> classifications = classificationRepository.findClassificationByIds(classificationIds)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 classification_id 입니다."));

        // contentClassification 저장
        for (Classification classification : classifications) {
            contentClassificationRepository.save(new ContentClassification(content, classification));
        }


        return content.getId();
    }

    public Content findById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 content_id 입니다."));
    }
}

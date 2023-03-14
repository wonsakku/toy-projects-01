package com.example.toy_01.service;

import com.example.toy_01.domain.Content;
import com.example.toy_01.dto.RequestContentDto;
import com.example.toy_01.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentService {

    private final ContentRepository contentRepository;


    public Long save(RequestContentDto dto) {
        Content content = dto.toInsertEntity();
        contentRepository.save(content);
        return content.getId();
    }

    public Content findById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 content_id 입니다."));
    }
}

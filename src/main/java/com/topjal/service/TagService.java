package com.topjal.service;



import com.topjal.entity.Tag;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface TagService {
    Tag save(Tag tag);
    Tag update(Tag tag);
    void delete(Long id);
    Optional<Tag> getTag(Long id);
    Page<Tag> getAllTags(int page, int perPageRow);
    Tag isAlreadyExist(String tagName);



}

package org.alcbrains.springbootserver.service.impl;

import org.alcbrains.springbootserver.domain.entity.Title;
import org.alcbrains.springbootserver.domain.entity.TitleId;
import org.alcbrains.springbootserver.domain.repo.TitleRepository;
import org.alcbrains.springbootserver.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TitleServiceRepoImpl implements TitleService {

    private final TitleRepository titleRepository;

    public TitleServiceRepoImpl(@Autowired TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }


    @Override
    public List<Title> findAllTitles() {
        return titleRepository.findAll();
    }

    @Override
    public Optional<Title> getTitleById(TitleId titleId) {
        return titleRepository.findById(titleId);
    }

    @Override
    public void createTitle(Title title) {
        titleRepository.save(title);
    }

    @Override
    public void deleteTitle(TitleId titleId) {
        titleRepository.deleteById(titleId);
    }
}

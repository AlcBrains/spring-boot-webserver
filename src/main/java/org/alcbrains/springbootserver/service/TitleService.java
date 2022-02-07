package org.alcbrains.springbootserver.service;

import org.alcbrains.springbootserver.domain.entity.Title;
import org.alcbrains.springbootserver.domain.entity.TitleId;

import java.util.List;
import java.util.Optional;

public interface TitleService {

    List<Title> findAllTitles();

    Optional<Title> getTitleById(TitleId titleId);

    void createTitle(Title title);

    void deleteTitle(TitleId titleId);



}

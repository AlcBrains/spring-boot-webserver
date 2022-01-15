package org.alcbrains.abstractionsbackend.service;

import org.alcbrains.abstractionsbackend.domain.entity.Title;
import org.alcbrains.abstractionsbackend.domain.entity.TitleId;

import java.util.List;
import java.util.Optional;

public interface TitleService {

    List<Title> findAllTitles();

    Optional<Title> getTitleById(TitleId titleId);

    void createTitle(Title title);

    void deleteTitle(Title title);



}

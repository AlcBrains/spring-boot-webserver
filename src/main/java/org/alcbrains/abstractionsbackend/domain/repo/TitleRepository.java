package org.alcbrains.abstractionsbackend.domain.repo;

import org.alcbrains.abstractionsbackend.domain.entity.Title;
import org.alcbrains.abstractionsbackend.domain.entity.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitleId> {
}

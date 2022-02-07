package org.alcbrains.springbootserver.domain.repo;

import org.alcbrains.springbootserver.domain.entity.Title;
import org.alcbrains.springbootserver.domain.entity.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitleId> {
}

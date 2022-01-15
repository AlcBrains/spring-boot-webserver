package org.alcbrains.abstractionsbackend.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "titles")
public class Title {
    @EmbeddedId
    private TitleId id;

    @Column(name = "to_date")
    private LocalDate toDate;

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public TitleId getId() {
        return id;
    }

    public void setId(TitleId id) {
        this.id = id;
    }
}

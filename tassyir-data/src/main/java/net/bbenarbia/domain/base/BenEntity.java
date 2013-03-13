package net.bbenarbia.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BenEntity extends BaseEntity {

    private Integer groupeId;

    @Column(name = "groupeid", nullable = false)
    public Integer getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(Integer groupeId) {
        this.groupeId = groupeId;
    }
}

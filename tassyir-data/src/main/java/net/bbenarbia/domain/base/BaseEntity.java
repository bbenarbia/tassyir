package net.bbenarbia.domain.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntity implements Comparable<BaseEntity> {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
    protected BaseEntity() {
    }

    /**
     * Constructor setting the id
     * @param id
     */
    protected BaseEntity(long id) {
        this.id = id;
    }

    @Transient
    public boolean isPersistent() {
        return id != 0;
    }

    @Transient
    public String getIdString() {
        return Long.toString(id);
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + id + "]";
    }

    @Override
    public int hashCode() {
        return id == 0 ? super.hashCode() : Long.valueOf(id).hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (other.id == 0 && id == 0) {
            return false;
        }
        // If one of them is a new object (id == 0) and they aren't the same
        // instance (already checked above),
        // then we consider them not equals. This is coherent with the EJB3
        // implementation.
        return other.id == id;
    }

    @Override
    public int compareTo(BaseEntity o) {
        return id < o.id ? -1 : (id == o.id ? 0 : 1);
    }
    
    
    public boolean isNew() {
        return (this.id == null);
    }
    
    
}
package net.bbenarbia.domain.base;

import org.joda.time.LocalDateTime;

/**
 * Interface to identity deletable entities. The dateSuppression need to be updated when deleting
 * the entity.
 * @author moad
 */
public interface IDeletableEntity {

    /**
     * Attribut de la date de Suppression
     */
    public static final String DATE_SUPPRESSION_ATTRIBUTE = "dateSuppression";
    
    public LocalDateTime getDateSuppression();

    public void setDateSuppression(LocalDateTime dateSuppression);
}
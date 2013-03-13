package net.bbenarbia.service.generic;

import java.util.List;

import net.bbenarbia.domain.base.BaseEntity;

public interface IGenericService<Entity extends BaseEntity>  {

    /**
     * @return
     */
    List<Entity> getAll();

    /**
     * @param id
     * @return
     */
    Entity get(Long id);


    /**
     * Inserts a entity object.
     * @param item
     * @return
     */
    Long save(Entity item);

    /**
     * Inserts or updates a CategorieFamille object.
     * @param item
     */
    void saveOrUpdate(Entity item);

    /**
     * @param categorieFamille
     */
    void delete(Entity item);

    void delete(Long id);

    public void merge(Entity item);

}

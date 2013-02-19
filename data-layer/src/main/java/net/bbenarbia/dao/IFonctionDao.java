package  net.bbenarbia.dao;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Fonction;

/**
 * IFonctionDao
 * @author moad
 * @date 26/04/2010 15:38:53
 * @version 1.0
 */
public interface IFonctionDao extends IGenericDao<Fonction> {

    /**
     * Gets the fonction by groupe id and estassociableparraccourci.
     * @param groupdID
     *            the groupd id
     * @return the fonctions.
     */
    List<Fonction> getAllFonctionAssociable(int groupdID);

    /**
     * Gets the function by name.
     * @param label
     * @return
     */
    public Fonction getByLabel(final String label);
}

package net.bbenarbia.dao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Contact;
import net.bbenarbia.domain.enums.EnumTypeContact;

/**
 * IContactDao.
 * @author Generator
 * @date 26/04/2010 15:38:53
 * @version 1.0
 */
public interface IContactDao extends IGenericDao<Contact> {

    /**
     * Retrieve a contact by its name.
     * @param groupeId
     * @param name
     * @param ignoreCase
     * @return the contact by its name, null if not found
     */
    Contact getByName(Integer groupeId, String name, boolean ignoreCase);

    
    /**
     * Gets the contact.
     * @param groupeId
     * @param typeContact
     * @return the contact
     */
    Contact getContact(final Integer groupeId, EnumTypeContact typeContact);


}
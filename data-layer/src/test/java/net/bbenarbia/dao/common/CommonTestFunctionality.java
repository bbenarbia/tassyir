package net.bbenarbia.dao.common;

import net.bbenarbia.dao.IContactDao;
import net.bbenarbia.domain.Contact;
import net.bbenarbia.domain.enums.EnumTypeContact;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author moad
 * @version
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/datasource-hsql.xml", "/dao-context.xml", "/dal-services-context.xml"})
public abstract class CommonTestFunctionality extends AbstractTransactionalJUnit4SpringContextTests {

	    @Autowired
	    IContactDao contactDao;

	    protected static final Logger LOGGER = LoggerFactory.getLogger(CommonTestFunctionality.class);

	    
	    
	protected Contact createContact(Integer groupeId, String nomContact, EnumTypeContact typeContact) {
        Contact contact = new Contact();
        contact.setNomContact(nomContact);
        contact.setGroupeId(groupeId);
        contact.setTypeContact(typeContact);
        contactDao.save(contact);
        return contact;
    }

}

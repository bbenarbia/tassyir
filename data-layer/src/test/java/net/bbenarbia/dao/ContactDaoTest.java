package net.bbenarbia.dao;

import static org.junit.Assert.assertNull;
import net.bbenarbia.domain.Contact;
import net.bbenarbia.domain.enums.EnumTypeContact;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author moad
 * @date 17/05/2010
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/datasource-hsql.xml", "/dao-context.xml" })
@TransactionConfiguration
@Transactional
public class ContactDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	private static final Integer CATGEORY_ID = 1;

	@Autowired
	private IContactDao contactDao;

	@Test
	public void testGetContactByNameEmptyDb() {
		Contact contact = contactDao.getByName(CATGEORY_ID, "constantin12",
				false);
		assertNull(contact);
	}

	@Test
	public void testCreateContact() {

		createContact(CATGEORY_ID, "Contact1", EnumTypeContact.Employe);

		Contact contact1 = contactDao.getByName(CATGEORY_ID, "Contact1", false);

		Assert.assertNotNull(contact1);
		Assert.assertEquals(contact1.getNomContact(), "Contact1");
	}

	private Contact createContact(Integer groupeId, String nomContact,
			EnumTypeContact typeContact) {
		Contact contact = new Contact();
		contact.setNomContact(nomContact);
		contact.setGroupeId(groupeId);
		contact.setTypeContact(typeContact);
		contactDao.save(contact);
		return contact;
	}
	/*
	 * @Test public void testGetContactByNameCaseSensitive() {
	 * createContact(CATGEORY_ID, "Constantin12", EnumTypeContact.Fournisseur);
	 * createContact(CATGEORY_ID, "constantiN12", EnumTypeContact.Fournisseur);
	 * assertNull(contactDao.getByName(CATGEORY_ID, "constantin12", false));
	 * assertNotNull(contactDao.getByName(CATGEORY_ID, "constantiN12", false));
	 * }
	 * 
	 * @Test public void testGetContactByNameCaseInsensitive() {
	 * createContact(CATGEORY_ID, "Constantin12", EnumTypeContact.Fournisseur);
	 * createContact(CATGEORY_ID, "constantiN12", EnumTypeContact.Fournisseur);
	 * assertNotNull(contactDao.getByName(CATGEORY_ID, "constantin12", true)); }
	 * 
	 * 
	 * 
	 * @Test public void testGetContact2EmptyDb() { Contact contact =
	 * contactDao.getContact(CATGEORY_ID, EnumTypeContact.Fournisseur);
	 * assertNull(contact); }
	 */
}

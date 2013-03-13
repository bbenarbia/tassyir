package net.bbenarbia.service.impl;

import net.bbenarbia.dao.IContactDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Contact;
import net.bbenarbia.service.IContactService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
@Transactional
public class ContactService extends GenericService<Contact> implements
		IContactService {

	@Autowired
	private IContactDao contactDao;

	@Override
	@Autowired
	@Qualifier("contactDao")
	public void setGenericDao(IGenericDao<Contact> genericDao) {
		this.genericDao = genericDao;
	}
}

package net.bbenarbia.dao.impl;

import net.bbenarbia.dao.IDepartementDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Departement;

import org.springframework.stereotype.Repository;


@Repository
public class DepartementDao extends GenericDao<Departement> implements IDepartementDao {

}

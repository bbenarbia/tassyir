package net.bbenarbia.dao.impl.immobilier;

import java.util.List;

import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.dao.immobilier.IBienDao;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.BienImmobilier;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BienDao extends GenericDao<BienImmobilier> implements IBienDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> getEntityByType(String type) {
		String queryString = "FROM " + getEntityClass().getName()
				+ " WHERE typeBien = :type";

		Query query = getSession().createQuery(queryString);
		query.setParameter("type", type);

		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> searchBiens(EnumTypeBien typeBien,
			String departement, Double superficieMin, Double superficieMax,
			Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin,
			Double loyerMax,  EnumTypeOperation typeOperation) {

		boolean withAnd = false;
		String and = " AND ";
		String where = " WHERE ";

		StringBuilder sb = new StringBuilder();
		sb.append("FROM " + getEntityClass().getName());


		if (typeBien != null) {
			sb.append(where);
			sb.append(" typeBien = :type ");
			withAnd = true;
		}
		
		if (typeOperation != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			sb.append(" typeOperation = :typeOperation ");
			withAnd = true;
		}

		if (departement != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" departement.reference = :departement ");
		}

		if (superficieMin != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" superficie >= :superficieMin ");
		}
		if (superficieMax != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" superficie <= :superficieMax ");
		}

		if (loyerMin != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" loyerMensuel >= :loyerMin ");
		}

		if (loyerMax != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" loyerMensuel <= :loyerMax ");
		}

		Query query = getSession().createQuery(sb.toString());
		if (typeBien != null) {
			query.setParameter("type", typeBien.toString());
		}
		if (typeOperation != null) {
			query.setParameter("typeOperation", typeOperation);
		}
		
		if (departement != null) {
			query.setParameter("departement", departement.toString());
		}
		if (superficieMin != null) {
			query.setParameter("superficieMin", superficieMin);
		}
		if (superficieMax != null) {
			query.setParameter("superficieMax", superficieMax);
		}

		if (loyerMin != null) {
			query.setParameter("loyerMin", loyerMin);
		}
		if (loyerMax != null) {
			query.setParameter("loyerMax", loyerMax);
		}
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> searchBiens(EnumTypeBien typeBien,
			String departement, Double superficieMin, Double superficieMax,
			Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin,
			Double loyerMax, Boolean ascenseur, Boolean cuisineEquipee,
			Boolean jardin, Boolean interphone, Boolean digicode,
			Boolean gardien, Boolean meuble, Boolean adapteHandicape,
			Boolean piscine, Boolean caves, Boolean parking,
			Boolean terrassesBalcons, EnumTypeOperation typeOperation) {

		boolean withAnd = false;
		String and = " AND ";
		String where = " WHERE ";

		StringBuilder sb = new StringBuilder();
		sb.append("FROM " + getEntityClass().getName());


		if (typeBien != null) {
			sb.append(where);
			sb.append(" typeBien = :type ");
			withAnd = true;
		}
		if (typeOperation != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			sb.append(" typeOperation = :typeOperation ");
			withAnd = true;
		}
		if (departement != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" departement.reference = :departement ");
		}

		if (superficieMin != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" superficie >= :superficieMin ");
		}
		if (superficieMax != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" superficie <= :superficieMax ");
		}

		if (loyerMin != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" loyerMensuel >= :loyerMin ");
		}

		if (loyerMax != null) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" loyerMensuel <= :loyerMax ");
		}

		if (ascenseur) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" ascenseur is true");
		}

		if (cuisineEquipee) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" cuisineEquipee is true");
		}
		if (jardin) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" jardin is true");
		}
		if (interphone) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" interphone is true");
		}
		if (digicode) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" digicode is true");
		}

		if (gardien) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" gardien is true");
		}

		if (meuble) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" meuble is true");
		}

		if (adapteHandicape) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" adapteHandicape is true");
		}
		if (piscine) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" piscine is true");
		}

		if (caves) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" nbCaves > 0");
		}

		if (parking) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" (nbParkingInt > 0  or  nbParkingExt > 0 )");
		}

		if (terrassesBalcons) {
			if (withAnd) {
				sb.append(and);
			} else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" ( nbTerrasses > 0 or  nbBalcons > 0 )");
		}

		Query query = getSession().createQuery(sb.toString());
		if (typeBien != null) {
			query.setParameter("type", typeBien.toString());
		}
		if (typeOperation != null) {
			query.setParameter("typeOperation", typeOperation);
		}
		
		
		if (departement != null) {
			query.setParameter("departement", departement.toString());
		}
		if (superficieMin != null) {
			query.setParameter("superficieMin", superficieMin);
		}
		if (superficieMax != null) {
			query.setParameter("superficieMax", superficieMax);
		}

		if (loyerMin != null) {
			query.setParameter("loyerMin", loyerMin);
		}
		if (loyerMax != null) {
			query.setParameter("loyerMax", loyerMax);
		}
		return query.list();

	}

	@Override
	public BienImmobilier getBienByRef(String refBien) {
		String queryString = "FROM " + getEntityClass().getName()
				+ " WHERE reference = :reference";

		Query query = getSession().createQuery(queryString);
		query.setParameter("reference", refBien);

		return (BienImmobilier) query.uniqueResult();
	}

}

package net.bbenarbia.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.bbenarbia.domain.DroitsUtilisateur;
import net.bbenarbia.domain.Fonction;
import net.bbenarbia.domain.Utilisateur;
import net.bbenarbia.domain.dto.UtilisateurDTO;
import net.bbenarbia.domain.enums.EnumDroit;
import net.bbenarbia.domain.enums.EnumFonction;
import net.bbenarbia.domain.enums.EnumModule;
import net.bbenarbia.domain.enums.EnumRole;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/datasource-hsql.xml", "/dao-context.xml" })
@TransactionConfiguration
@Transactional
public class UtilisateurDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	private static String LOGIN = "Lvasea";
	private static String NAME = "vasea";
	private static Integer GROUPE_ID = 1;
	private static Set<EnumRole> ROLES;
	private Utilisateur utilisateur;

	@Autowired
	private IUtilisateurDao utilisateurDao;
	@Autowired
	private IDroitsUtilisateurDao droitsUtilDao;
	@Autowired
	private IFonctionDao fonctionDao;

	@Before
	public void setUp() {

		Set<DroitsUtilisateur> droits;
		Set<Fonction> fonctions;
		droits = getDroitsUtilisateurs();
		fonctions = getFonctions();
		// save the rights set
		for (DroitsUtilisateur droit : droits) {
			droitsUtilDao.save(droit);
		}
		// save the fonctions set
		for (Fonction fonction : fonctions) {
			fonctionDao.save(fonction);
		}

		Set<EnumRole> roles = new HashSet<EnumRole>();
		roles.add(EnumRole.ADMIN);
		roles.add(EnumRole.UTILISATEUR);
		ROLES = new HashSet<EnumRole>(roles);

		 utilisateur = new Utilisateur();

	        // set up user's info
		 utilisateur.setGroupeId(GROUPE_ID);
		 utilisateur.setLogin(LOGIN);
		 utilisateur.setNomUtilisateur(NAME);
		 utilisateur.setRoles(roles);
	        

		utilisateurDao.save(utilisateur);
	}

	@Test
	public void testSaveUtilisateur() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setGroupeId(GROUPE_ID);
		utilisateur.setLogin("test1");
		Set<String> autorisations = new HashSet<String>();
		DroitsUtilisateur droit1 = new DroitsUtilisateur();
		droit1.setDroit(EnumDroit.RETOUR_PRODUIT);
		droit1.setModule(EnumModule.VE);
		DroitsUtilisateur droit2 = new DroitsUtilisateur();
		droit2.setDroit(EnumDroit.CLOTURER_SESSION);
		droit2.setModule(EnumModule.VE);
		autorisations.add(droit1.getAutorisation());
		autorisations.add(droit2.getAutorisation());
		utilisateur.setAutorisationsAsList(autorisations);
		utilisateurDao.save(utilisateur);

		utilisateurDao.flush();
		utilisateurDao.clear();

		List<Utilisateur> all = utilisateurDao.getUtilisateursByLogin("test1");
		assertEquals(1, all.size());
		assertTrue(all.get(0).getAutorisations().contains("RETOUR_PRODUIT_VE"));
		assertTrue(all.get(0).getAutorisations()
				.contains("CLOTURER_SESSION_VE"));
	}

	/**
	 * Test getting all users.
	 */
	@Test
	public void testGetAll() {
		List<Utilisateur> utiliss;
		Integer expectedSize;
		utiliss = utilisateurDao.getAll();
		expectedSize = 1;
		assertEquals("The list size isn't equal with expected", expectedSize,
				Integer.valueOf(utiliss.size()));
	}

	/**
	 * Test getting user by it's login.
	 */
	@Test
	public void testGetUtilisateurByLogin() {
		Utilisateur utilis;
		utilis = utilisateurDao.getUtilisateurByLogin(GROUPE_ID, LOGIN);
		assertEquals("The user's login doesn't match", LOGIN, utilis.getLogin());
		assertEquals("The user's name doesn't match", LOGIN, utilis.getLogin());
	}

	@Test
	public void testDelete() {
		List<Utilisateur> lstUtilisateur = utilisateurDao.getAll();
		for (Utilisateur utilisateur : lstUtilisateur) {
			// for (Session sess : utilisateur.getSessions()) {
			// sessionDao.delete(sess);
			// }
			utilisateurDao.delete(utilisateur);
		}
		List<Utilisateur> lstVide = utilisateurDao.getAll();
		assertTrue("la liste des utilisateurs doit être vide",
				lstVide.isEmpty());
	}

	@Test
	public void testGetRoles() {
		Utilisateur user = utilisateurDao.getUtilisateurByLogin(GROUPE_ID,
				LOGIN);
		Set<EnumRole> userRoles = user.getRoles();
		assertTrue(
				"La liste de roles ne contient pas tous les roles insérés : ",
				userRoles.containsAll(ROLES));
		assertEquals(
				"Il n'y a pas autant de roles entre l'origine et l'entité stockée : ",
				2, userRoles.size());
	}

	@Test
	public void testGetOnlyUtilisateursAndGestionnaireWithFilter() {
		Utilisateur util = new Utilisateur();
		// util.setCodeUtilisateur(46);
		util.setLogin("loginTest2");
		util.setGroupeId(GROUPE_ID);
		util.setNomUtilisateur("HARRYPOTTER");
		util.setRoles(ROLES);
		utilisateurDao.save(util);

		util = new Utilisateur();
		util.setLogin("loginTest2");
		util.setGroupeId(GROUPE_ID);
		util.setNomUtilisateur("HARRYPOTTER");
		utilisateurDao.save(util);

		util = new Utilisateur();
		util.setLogin("loginTest2");
		util.setGroupeId(GROUPE_ID);
		util.setNomUtilisateur("HARRYPOTTER");
		utilisateurDao.save(util);

		List<String> logins = utilisateurDao.getFilteredLoginsOfUsers("");
		assertEquals(4, utilisateurDao.getAll().size());
		assertEquals(2, logins.size());
	}

	@Test
	public void testAddRolesAndThereforeGetMore() {
		Utilisateur origUser = utilisateurDao.getUtilisateurByLogin(GROUPE_ID,
				LOGIN);
		assertTrue("Cannot add role...",
				origUser.getRoles().add(EnumRole.GESTIONNAIRE));
		utilisateurDao.saveOrUpdate(origUser);
		Utilisateur user = utilisateurDao.getUtilisateurByLogin(GROUPE_ID,
				LOGIN);
		Set<EnumRole> userRoles = user.getRoles();
		assertTrue(
				"La liste de roles ne contient pas tous les roles insérés : ",
				userRoles.contains(EnumRole.GESTIONNAIRE));
		assertEquals(
				"Il n'y a pas autant de roles entre l'original modifié et l'entité stockée : ",
				3, userRoles.size());
	}

	@Test
	public void testRemoveRolesAndThereforeGetLess() {
		Utilisateur origUser = utilisateurDao.getUtilisateurByLogin(GROUPE_ID,
				LOGIN);
		assertTrue("Cannot remove role...",
				origUser.getRoles().remove(EnumRole.ADMIN));
		utilisateurDao.saveOrUpdate(origUser);
		Utilisateur user = utilisateurDao.getUtilisateurByLogin(GROUPE_ID,
				LOGIN);
		Set<EnumRole> userRoles = user.getRoles();
		assertTrue(
				"La liste de roles ne contient pas tous les roles insérés : ",
				!userRoles.contains(EnumRole.ADMIN));
		assertEquals(
				"Il n'y a pas autant de roles entre l'original modifié et l'entité stockée : ",
				1, userRoles.size());
	}

	@Test
	public void testAddDuplicateRole() {
		Utilisateur origUser = utilisateurDao.getUtilisateurByLogin(GROUPE_ID,
				LOGIN);
		assertTrue("Was able to add a duplicate role ! I shouldn't /!\\",
				!origUser.getRoles().add(EnumRole.UTILISATEUR));
		utilisateurDao.saveOrUpdate(origUser);
		Utilisateur user = utilisateurDao.getUtilisateurByLogin(GROUPE_ID,
				LOGIN);
		Set<EnumRole> userRoles = user.getRoles();
		assertTrue(
				"La liste de roles ne contient pas tous les roles insérés : ",
				userRoles.containsAll(ROLES));
		assertEquals(
				"Il n'y a pas autant de roles entre l'original modifié et l'entité stockée : ",
				2, userRoles.size());
	}

	@Test
	public void chercherUtilisateurParNom() {
		Utilisateur util = new Utilisateur();
		util.setLogin("loginTest2");
		util.setGroupeId(GROUPE_ID);
		util.setNomUtilisateur("HARRYPOTTER");
		utilisateurDao.save(util);

		util = new Utilisateur();
		util.setLogin("loginTest2");
		util.setGroupeId(GROUPE_ID);
		util.setNomUtilisateur("HARRYPOTTER");
		utilisateurDao.save(util);

		List<Utilisateur> user = utilisateurDao.getUtilisateursByName(
				GROUPE_ID, "HARRYPOTTER");
		assertNotNull(user);
		assertEquals(2, user.size());
		assertEquals("HARRYPOTTER", user.get(0).getNomUtilisateur());
	}

	
//	 @Test
//	 public void getUtilisateurParRefTest() {
//	
//	 ReferenceIdSequence ref1 = new ReferenceIdSequence();
//	 referenceIdSequenceDao.save(ref1);
//	
//	 Utilisateur user1 = new Utilisateur();
//	 user1.setGroupeId(1);
//	 user1.setRefId(ref1);
//	
//	 ReferenceIdSequence ref2 = new ReferenceIdSequence();
//	 referenceIdSequenceDao.save(ref2);
//	
//	 Utilisateur user2 = new Utilisateur();
//	 user2.setGroupeId(1);
//	 user2.setRefId(ref2);
//	
//	 utilisateurDao.save(user1, user2);
//	
//	 Utilisateur result1 = utilisateurDao.getUtilisateurParRef(ref1.getId());
//	 assertNotNull(result1);
//	 assertEquals(ref1.getId(), result1.getRefId().getId());
//	
//	 Utilisateur result2 = utilisateurDao.getUtilisateurParRef(ref2.getId());
//	 assertNotNull(result2);
//	 assertEquals(ref2.getId(), result2.getRefId().getId());
//	
//	 assertNull(utilisateurDao.getUtilisateurParRef(ref1.getId() +
//	 ref2.getId()));
//	 }

//	 @Test
//	 public void getRefIdUtilisateurByNomUtilisateurTest() {
//	
//	 ReferenceIdSequence ref1 = new ReferenceIdSequence();
//	 referenceIdSequenceDao.save(ref1);
//	
//	 Utilisateur user1 = new Utilisateur();
//	 user1.setGroupeId(1);
//	 user1.setRefId(ref1);
//	 user1.setNomUtilisateur("1");
//	
//	 ReferenceIdSequence ref2 = new ReferenceIdSequence();
//	 referenceIdSequenceDao.save(ref2);
//	
//	 Utilisateur user2 = new Utilisateur();
//	 user2.setGroupeId(1);
//	 user2.setRefId(ref2);
//	
//	 utilisateurDao.save(user1, user2);
//	
//	 Long result1 = utilisateurDao.getRefIdUtilisateurByNomUtilisateur(1,
//	 "1");
//	 assertEquals(Long.valueOf(ref1.getId()), result1);
//	
//	 Long result2 = utilisateurDao.getRefIdUtilisateurByNomUtilisateur(2,
//	 "1");
//	 assertNull(result2);
//	
//	 Long result3 = utilisateurDao.getRefIdUtilisateurByNomUtilisateur(1,
//	 "2");
//	 assertNull(result3);
//	 }

	@Test
	public void getUtilisateurParCodeTest() {

		// On commence les codes Utilisateurs à 2 parce que le save
		// de utilisateurDao dans le setup incrémente les codes utilisateur à 1.
		Utilisateur user1 = new Utilisateur();
		user1.setGroupeId(1);
		user1.setCodeUtilisateur(2);

		Utilisateur user2 = new Utilisateur();
		user2.setGroupeId(1);
		user2.setCodeUtilisateur(3);

		utilisateurDao.save(user1, user2);
		utilisateurDao.flush();
		utilisateurDao.clear();

		Utilisateur result1 = utilisateurDao.getUtilisateurParCode(2);
		assertNotNull(result1);
		assertEquals(Integer.valueOf(2), result1.getCodeUtilisateur());
		assertEquals(Integer.valueOf(1), result1.getGroupeId());
		assertEquals(user1.getId(), result1.getId());

		Utilisateur result2 = utilisateurDao.getUtilisateurParCode(3);
		assertNotNull(result2);
		assertEquals(Integer.valueOf(3), result2.getCodeUtilisateur());
		assertEquals(Integer.valueOf(1), result2.getGroupeId());
		assertEquals(user2.getId(), result2.getId());

		assertNull(utilisateurDao.getUtilisateurParCode(6));
		assertNull(utilisateurDao.getUtilisateurParCode(null));
	}

	 @Test
	 public void getExistentEmployeeListTest() {
	
	 Utilisateur user1 = new Utilisateur();
	 int groupeId = 1000;
	 user1.setGroupeId(groupeId);
	 user1.setNomUtilisateur("user1");
	
	 Utilisateur user2 = new Utilisateur();
	 user2.setGroupeId(2);
	 user2.setNomUtilisateur("user2");
	
	 Utilisateur user3 = new Utilisateur();
	 user3.setGroupeId(groupeId);
	 user3.setNomUtilisateur("abc");
	
	 Utilisateur user4 = new Utilisateur();
	 user4.setGroupeId(groupeId);
	 user4.setNomUtilisateur("abc1");
	 user4.setDateSuppression(new LocalDateTime());
	
	 utilisateurDao.save(user1, user2, user3, user4);
	
	 List<UtilisateurDTO> result1 =
	 utilisateurDao.getExistentEmployeeList(groupeId);
	 assertNotNull(result1);
	 assertEquals(2, result1.size());
	 assertEquals("abc", result1.get(0).getNomUtilisateur());
	 assertEquals("user1", result1.get(1).getNomUtilisateur());
	
	 List<UtilisateurDTO> result2 = utilisateurDao.getExistentEmployeeList(5);
	 assertNotNull(result2);
	 assertEquals(0, result2.size());
	 }

	@Test
	public void getUtilisateurParGroupeIdAndCodeTest() {

		Utilisateur user1 = new Utilisateur();
		user1.setGroupeId(1);
		user1.setCodeUtilisateur(1);

		Utilisateur user2 = new Utilisateur();
		user2.setGroupeId(1);
		user2.setCodeUtilisateur(2);

		Utilisateur user3 = new Utilisateur();
		user3.setGroupeId(3);
		user3.setCodeUtilisateur(3);

		utilisateurDao.save(user1, user2, user3);

		Utilisateur result1 = utilisateurDao.getUtilisateurParGroupeIdAndCode(
				1, 2);
		assertNotNull(result1);
		assertEquals(user2.getGroupeId(), result1.getGroupeId());
		assertEquals(user2.getCodeUtilisateur(), result1.getCodeUtilisateur());

		Utilisateur result2 = utilisateurDao.getUtilisateurParGroupeIdAndCode(
				3, 3);
		assertNotNull(result2);
		assertEquals(user3.getGroupeId(), result2.getGroupeId());
		assertEquals(user3.getCodeUtilisateur(), result2.getCodeUtilisateur());

		assertNull(utilisateurDao.getUtilisateurParGroupeIdAndCode(1, 3));
		assertNull(utilisateurDao.getUtilisateurParGroupeIdAndCode(100, 100));
		assertNull(utilisateurDao.getUtilisateurParGroupeIdAndCode(null, 1));
		assertNull(utilisateurDao.getUtilisateurParGroupeIdAndCode(1, null));
		assertNull(utilisateurDao.getUtilisateurParGroupeIdAndCode(null, null));
	}

	@Test
	public void getUtilisateurGroupeIdByLoginTest() {

		Utilisateur user1 = new Utilisateur();
		user1.setGroupeId(1);
		user1.setLogin("login1");

		Utilisateur user2 = new Utilisateur();
		user2.setGroupeId(1);
		user2.setLogin("login2");

		utilisateurDao.save(user1, user2);

		Integer result1 = utilisateurDao
				.getUtilisateurGroupeIdByLogin("login1");
		assertEquals(user1.getGroupeId(), result1);

		Integer result2 = utilisateurDao
				.getUtilisateurGroupeIdByLogin("login2");
		assertEquals(user2.getGroupeId(), result2);

		assertNull(utilisateurDao.getUtilisateurGroupeIdByLogin(null));
		assertNull(utilisateurDao.getUtilisateurGroupeIdByLogin("login3"));
	}

	@Test
	public void deleteWithSuppressionTest() {

		Utilisateur user1 = new Utilisateur();
		user1.setGroupeId(1);
		user1.setLogin("login1");

		utilisateurDao.save(user1);
		utilisateurDao.deleteWithSuppression(user1);

		Utilisateur result1 = utilisateurDao.get(user1.getId());
		assertNotNull(result1);
		assertNotNull(result1.getDateSuppression());
	}

	@Test
	public void existUserWithCodeTest() {

		Utilisateur user1 = new Utilisateur();
		int groupeId = 1000;
		user1.setGroupeId(groupeId);
		user1.setCodeUtilisateur(1);

		utilisateurDao.save(user1);

		assertTrue(utilisateurDao.existUserWithCode(1, groupeId));
		assertFalse(utilisateurDao.existUserWithCode(1, 2));
		assertFalse(utilisateurDao.existUserWithCode(2, groupeId));
		assertFalse(utilisateurDao.existUserWithCode(2, 2));
		assertFalse(utilisateurDao.existUserWithCode(1, null));
		assertFalse(utilisateurDao.existUserWithCode(null, groupeId));
		assertFalse(utilisateurDao.existUserWithCode(null, null));
	}

	@Test
	public void getUtilisateursByLoginTest() {

		Utilisateur user1 = new Utilisateur();
		user1.setGroupeId(1);
		user1.setLogin("login1");

		Utilisateur user2 = new Utilisateur();
		user2.setGroupeId(2);
		user2.setLogin("login1");

		Utilisateur user3 = new Utilisateur();
		user3.setGroupeId(3);
		user3.setLogin("login1");

		utilisateurDao.save(user1, user2, user3);

		List<Utilisateur> result1 = utilisateurDao
				.getUtilisateursByLogin("login1");
		assertNotNull(result1);
		assertEquals(3, result1.size());
		assertEquals(6,
				user1.getGroupeId() + user2.getGroupeId() + user3.getGroupeId());

		List<Utilisateur> result2 = utilisateurDao
				.getUtilisateursByLogin("login2");
		assertNotNull(result2);
		assertEquals(0, result2.size());

		List<Utilisateur> result3 = utilisateurDao.getUtilisateursByLogin(null);
		assertNotNull(result3);
		assertEquals(0, result3.size());
	}

	public void getUtilisateursByGroupeIdTest() {
		Utilisateur user1 = new Utilisateur();
		user1.setGroupeId(1);
		user1.setLogin("login1");

		Utilisateur user2 = new Utilisateur();
		user2.setGroupeId(2);
		user2.setLogin("login1");

		Utilisateur user3 = new Utilisateur();
		user3.setGroupeId(2);
		user3.setLogin("login2");

		utilisateurDao.save(user1, user2, user3);

		List<Utilisateur> utilisateurs = utilisateurDao
				.getUtilisateursByGroupeId(2);

		assertEquals(2, utilisateurs.size());

	}

	/**
	 * Create an initialized CategorieProfilUtilisateur object.
	 * 
	 * @param droitsUtil
	 *            - user's rights
	 * @param fonctions
	 *            - fonctions
	 * @return an initialized CategorieProfilUtilisateur object
	 */
//	 private CategorieProfilUtilisateur
//	 getCategorieProfilUtilisateur(Set<DroitsUtilisateur> droitsUtil,
//	 Set<Fonction> fonctions) {
//	 CategorieProfilUtilisateur catProfUtil;
//	 catProfUtil = new CategorieProfilUtilisateur();
//	 // set up the user's profile
//	 catProfUtil.setGroupeId(GROUPE_ID);
//	 catProfUtil.setLibelleCategorieProfilUtilisateur("GESTIONAIRE");
//	 catProfUtil.setDroitsUtilisateurs(droitsUtil);
//	 catProfUtil.setFonctions(fonctions);
//	
//	 return catProfUtil;
//	 }

	/**
	 * Create an initialized set of Fonctions.
	 * 
	 * @return an initialized set of Fonctions
	 */
	private Set<Fonction> getFonctions() {
		Set<Fonction> fonctions;
		fonctions = new HashSet<Fonction>();
		fonctions.add(getFonction());

		return fonctions;
	}

	/**
	 * Create an initialized Fonction object.
	 * 
	 * @return an initialized Fonction object
	 */
	private Fonction getFonction() {
		Fonction fonction;
		fonction = new Fonction();
		fonction.setGroupeId(GROUPE_ID);
		fonction.setLibelleFonction("Acceder a emplacements");
		fonction.setTypeFonction(EnumFonction.FONCTION_1);

		return fonction;
	}

	/**
	 * Create an initialized set of DroitsUtilisateur objects.
	 * 
	 * @return an initialized set of DroitsUtilisateur objects
	 */
	private Set<DroitsUtilisateur> getDroitsUtilisateurs() {
		Set<DroitsUtilisateur> droits;
		droits = new HashSet<DroitsUtilisateur>();
		droits.add(getDroit());

		return droits;
	}

	/**
	 * Create an initialized DroitsUtilisateur object.
	 * 
	 * @return an initialized DroitsUtilisateur object
	 */
	private DroitsUtilisateur getDroit() {
		DroitsUtilisateur droit;
		droit = new DroitsUtilisateur();
		droit.setDroit(EnumDroit.RETOUR_PRODUIT);
		droit.setModule(EnumModule.VE);
		final String descriptions = "La description : \n\t- desc1\n\t- desc2";
		droit.setDescription(descriptions);

		return droit;
	}
}
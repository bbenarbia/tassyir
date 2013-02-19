package net.bbenarbia.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.bbenarbia.dao.IUtilisateurDao;
import net.bbenarbia.domain.Utilisateur;
import net.bbenarbia.domain.dto.UtilisateurDTO;
import net.bbenarbia.service.impl.UtilisateurService;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;

public class UtilisateurServiceTest extends UnitilsJUnit4 {

    private static int GROUPE1 = 1;
    private static int CODE_UTILISATEUR = 1;

    @Mock
    @InjectIntoByType
    private IUtilisateurDao utilisateurDao;

    @TestedObject
    UtilisateurService utilisateurService;

    List<Utilisateur> usersList;
    List<UtilisateurDTO> usersListDTO;

    @Before
    public void setUp() {
    	usersListDTO = new ArrayList<UtilisateurDTO>();
    	usersList = new ArrayList<Utilisateur>();
        Utilisateur user1 = createUser(CODE_UTILISATEUR, "loginUser1", "nomUser1");
        Utilisateur user2 = createUser(2, "loginUser2", "nomUser2");
        Utilisateur user3 = createUser(3, "loginUser3", "nomUser3");
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        for (Utilisateur el : usersList) {
        	UtilisateurDTO u = new UtilisateurDTO(el.getNomUtilisateur(),el.getCodeUtilisateur());
        	usersListDTO.add(u);
		}
    }

//    @Test
//    public void testGetAllEmployeeList() throws BusinessException {    	
//        EasyMock.expect(utilisateurDao.getExistentEmployeeList(GROUPE1)).andReturn(usersListDTO);
//        EasyMockUnitils.replay();
//
//        List<UtilisateurDTO> testedValue = utilisateurService.getExistentEmployeeList(GROUPE1);
//
//        int i = 1;
//        for (UtilisateurDTO user : testedValue) {
//            assertEquals(new Integer(i), user.getCodeUtilisateur());
//            assertEquals("nomUser" + i, user.getNomUtilisateur());
//            i++;
//        }
//    }

    @Test
    public void testGetUtilisateurByCode() {

        Utilisateur expected = getUtilisateurByCode(CODE_UTILISATEUR);

        EasyMock.expect(utilisateurDao.getUtilisateurParGroupeIdAndCode(GROUPE1, CODE_UTILISATEUR)).andReturn(expected);
        EasyMockUnitils.replay();

        Utilisateur actual = utilisateurService.getUtilisateurByCode(GROUPE1, CODE_UTILISATEUR);
        Assert.assertEquals(expected.getCodeUtilisateur(), actual.getCodeUtilisateur());

    }

    @Test
    public void testGetUtilisateurAndGestionnaireListOfLogins() {
        Utilisateur expected = getUtilisateurByCode(CODE_UTILISATEUR);

        EasyMock.expect(utilisateurDao.getFilteredLoginsOfUsers(expected.getLogin())).andReturn(
                Collections.singletonList(expected.getLogin()));
        EasyMockUnitils.replay();

        List<String> actual = utilisateurService.getUtilisateurAndGestionnaireListOfLogins(expected.getLogin());
        Assert.assertEquals(expected.getLogin(), actual.get(0));
    }

    @After
    public void tearDown() throws Exception {
    }

    private Utilisateur createUser(int codeUtilisateur, String login, String nomUtilisateur) {
        Utilisateur user = new Utilisateur();
        user.setGroupeId(GROUPE1);
        user.setCodeUtilisateur(codeUtilisateur);
        user.setLogin(login);
        user.setNomUtilisateur(nomUtilisateur);
        return user;
    }

    private Utilisateur getUtilisateurByCode(int codeUtilisateur) {
        for (Utilisateur utilisateur : usersList) {
            if (utilisateur.getCodeUtilisateur() == codeUtilisateur) {
                return utilisateur;
            }
        }
        return null;
    }
}


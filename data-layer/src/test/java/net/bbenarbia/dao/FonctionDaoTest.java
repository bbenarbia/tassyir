package net.bbenarbia.dao;

import junit.framework.Assert;
import net.bbenarbia.domain.Fonction;

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
public class FonctionDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IFonctionDao fonctionDao;

    public static Integer GROUPE_ID1 = 1;
    
    /**
     * The test for testGetAllFonctionAssociable.
     */
    @Test
    public void testGetAllFonctionAssociable() {
        Fonction fonction1 = getFonction();
        Fonction fonction2 = getFonction();
        fonction2.setEstAssociableParRaccourci(false);
        Fonction fonction3 = getFonction();
        fonctionDao.save(fonction1);
        fonctionDao.save(fonction2);
        fonctionDao.save(fonction3);
        Assert.assertEquals("The received list has size great than required size.", 2,
                            fonctionDao.getAllFonctionAssociable(GROUPE_ID1).size());
    }

    @Test
    public void getByLabelTest() {
        Fonction fonction1 = new Fonction();
        fonction1.setLibelleFonction("label1");
        fonction1.setGroupeId(1);

        Fonction fonction2 = new Fonction();
        fonction2.setLibelleFonction("label2");
        fonction2.setGroupeId(1);

        Long fonction1Id = fonctionDao.save(fonction1);
        Long fonction2Id = fonctionDao.save(fonction2);

        Assert.assertTrue(fonctionDao.getAll().size() == 2);

        Assert.assertNotNull(fonctionDao.getByLabel("label1"));
        Assert.assertNotNull(fonctionDao.getByLabel("label2"));

        Assert.assertEquals(fonction1Id, Long.valueOf(fonctionDao.getByLabel("label1").getId()));
        Assert.assertEquals("label1", fonctionDao.getByLabel("label1").getLibelleFonction());

        Assert.assertEquals(fonction2Id, Long.valueOf(fonctionDao.getByLabel("label2").getId()));
        Assert.assertEquals("label2", fonctionDao.getByLabel("label2").getLibelleFonction());
    }
    
    public static Fonction getFonction() {
        Fonction fonction;
        fonction = new Fonction();
        fonction.setEstAssociableParRaccourci(true);
        fonction.setLibelleFonction("New fonction");
        fonction.setGroupeId(GROUPE_ID1);
        return fonction;
    }

}

package net.bbenarbia.service;

import java.util.ArrayList;
import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.base.BaseEntity;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;

public class GenericServiceTest extends UnitilsJUnit4 {

    @Mock
    @InjectIntoByType
    private IGenericDao<BaseEntity> genericDao;

    @TestedObject
    MygenericService mygenericService = new MygenericService();

    long id;
    BaseEntity baseEntity;
    final static int GROUPE_ID = 1;

    class MygenericService extends GenericService<BaseEntity> {

        @Override
        public void setGenericDao(IGenericDao<BaseEntity> genericDao) {
            this.genericDao = genericDao;
        }

    };

    @Before
    public void SetUp() {
        id = 1L;
        baseEntity = new BaseEntity() {
        };
        baseEntity.setId(id);

    }

    @Test
    public void testGet() {
        EasyMock.expect(genericDao.get(id)).andReturn(baseEntity);
        EasyMockUnitils.replay();
        Assert.assertEquals(mygenericService.get(id).getIdString(), Long.toString(id));
        EasyMock.verify(genericDao);
    }

    @Test
    public void testGetAll() {
        List<BaseEntity> baseEntityList = new ArrayList<BaseEntity>();
        baseEntityList.add(baseEntity);
        EasyMock.expect(genericDao.getAll()).andReturn(baseEntityList);
        EasyMockUnitils.replay();
        Assert.assertEquals(mygenericService.getAll().get(0).getIdString(), Long.toString(id));
        EasyMock.verify(genericDao);
    }

    @Test
    public void testGetByGroupeId() {
        List<BaseEntity> baseEntityList = new ArrayList<BaseEntity>();
        baseEntityList.add(baseEntity);
        EasyMock.expect(genericDao.getByGroupeId(GROUPE_ID)).andReturn(baseEntityList);
        EasyMockUnitils.replay();
        Assert.assertEquals(mygenericService.getByGroupeId(GROUPE_ID).get(0).getIdString(), Long.toString(id));
        EasyMock.verify(genericDao);
    }

    @Test
    public void testSave() {
        EasyMock.expect(genericDao.save(baseEntity)).andReturn(id);
        EasyMockUnitils.replay();
        Assert.assertEquals(mygenericService.save(baseEntity), id);
        EasyMock.verify(genericDao);
    }

    @Test
    public void testSaveOrUpdate() {
        genericDao.saveOrUpdate(baseEntity);
        EasyMock.expectLastCall();
        genericDao.flush();
        EasyMock.expectLastCall();
        EasyMockUnitils.replay();
        mygenericService.saveOrUpdate(baseEntity);
        EasyMock.verify(genericDao);
    }

    @Test
    public void testDelete() {
        genericDao.delete(baseEntity);
        EasyMock.expectLastCall();
        EasyMockUnitils.replay();
        mygenericService.delete(baseEntity);
        EasyMock.verify(genericDao);
    }

    @Test
    public void testDeleteById() {
        EasyMock.expect(genericDao.delete(id)).andReturn(1);
        EasyMockUnitils.replay();
        mygenericService.delete(id);
        EasyMock.verify(genericDao);
    }

    @Test
    public void testMerge() {
        genericDao.merge(baseEntity);
        EasyMock.expectLastCall();
        EasyMockUnitils.replay();
        mygenericService.merge(baseEntity);
        EasyMock.verify(genericDao);
    }

}


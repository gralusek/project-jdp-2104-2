package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.dao.GroupDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class GroupTestSuite {

    @Autowired
    private GroupDao groupDao;

    @Test
    public void testSaveOneToMany(){
        //Given
        Group group1 = new Group(1L,"Test", new ArrayList<>());
        Group group2 = new Group(2L,"Test", new ArrayList<>());
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
        group2.getProducts().add(product3);
        //When
        groupDao.save(group1);
        Long group1Id = group1.getGroupId();
        groupDao.save(group2);
        Long group2Id = group2.getGroupId();
        //Then
        assertNotEquals(0,group1Id);
        assertNotEquals(0,group2Id);
        assertEquals(2,group1.getProducts().size());
        assertEquals(1,group2.getProducts().size());
        //Cleanup
        try {
            groupDao.deleteAll();
        } catch (Exception e ){
            //do nothing
        }

    }

}
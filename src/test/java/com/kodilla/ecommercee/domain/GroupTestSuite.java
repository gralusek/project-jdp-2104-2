package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.dao.GroupRepository;
import com.kodilla.ecommercee.dao.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class GroupTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreate(){
        //Given
        Group group1 = new Group(1L,"Test", new ArrayList<>());
        //When
        groupRepository.save(group1);
        Long group1Id = group1.getGroupId();
        //Then
        assertNotEquals(0,group1Id);
        assertEquals(0,group1.getProducts().size());
        //Cleanup
        try {
            groupRepository.deleteAll();
        } catch (Exception e ){
            //do nothing
        }

    }

    @Test
    public void testDelete(){
        //Given
        Group group1 = new Group(1L,"Test", new ArrayList<>());
        long id = group1.getGroupId();
        //When
        groupRepository.save(group1);
        try{
            groupRepository.deleteById(id);
        } catch (Exception e){
            //do nothing
        }
        Optional<Group> output = groupRepository.findById(id);
        //Then
        assertFalse(output.isPresent());
    }

    @Test
    public void testRead(){
        //Given
        Group group1 = new Group(1L,"Test", new ArrayList<>());
        long id = group1.getGroupId();
        //When
        groupRepository.save(group1);
        Optional<Group> output = groupRepository.findById(id);
        //Then
        assertTrue(output.isPresent());
        //Cleanup
        try {
            groupRepository.deleteAll();
        } catch (Exception e ){
            //do nothing
        }
    }

    @Test
    public void testUpdate(){
        //Given
        Group group1 = new Group(1L,"Test", new ArrayList<>());
        //When
        groupRepository.save(group1);
        group1.setName("updated");
        //Then
        assertEquals("updated", group1.getName());
        //Cleanup
        try {
            groupRepository.deleteAll();
        } catch (Exception e ){
            //do nothing
        }
    }

    @Test
    public void testRelations(){
        //Given
        Group group1 = new Group(1L,"Test", new ArrayList<>());
        Product product1 = new Product(1L, group1, new ArrayList<>());
        group1.getProducts().add(product1);
        //When
        groupRepository.save(group1);
        //Then
        assertNotEquals(0,group1.getGroupId());
        assertEquals(1,group1.getProducts().size());
        try {
            groupRepository.deleteAll();
        } catch (Exception e ){
            //do nothing
        }
        assertFalse(productRepository.findById(product1.getProductId()).isPresent());
    }

}
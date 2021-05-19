package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repositories.GroupRepository;
import com.kodilla.ecommercee.repositories.ProductRepository;
import com.kodilla.ecommercee.exceptions.GroupNotExist;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreate(){
        //Given
        Group group1 = new Group("Test");
        //When
        groupRepository.save(group1);
        //Then
        assertTrue(groupRepository.findById(group1.getGroupId()).isPresent());
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
        Group group1 = new Group("Test");
        //When
        groupRepository.save(group1);
        try{
            groupRepository.deleteById(group1.getGroupId());
        } catch (Exception e){
            //do nothing
        }
        Optional<Group> output = groupRepository.findById(group1.getGroupId());
        //Then
        assertFalse(output.isPresent());
    }

    @Test
    public void testRead(){
        //Given
        Group group1 = new Group("Test");
        //When
        groupRepository.save(group1);
        Optional<Group> output = groupRepository.findById(group1.getGroupId());
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
    public void testUpdate() throws GroupNotExist {
        //Given
        Group group1 = new Group("Test");
        //When
        groupRepository.save(group1);
        long id = group1.getGroupId();
        Group output = groupRepository.findById(id).orElseThrow(GroupNotExist::new);
        output.setName("updated");
        //Then
        assertEquals("updated", output.getName());
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
        Product product1 = new Product(1L, "name", "description",
                10.00, group1, new ArrayList<>());
        group1.getProducts().add(product1);
        //When
        groupRepository.save(group1);
        //Then
        assertEquals(1,groupRepository.count());
        try {
            groupRepository.deleteAll();
        } catch (Exception e ){
            //do nothing
        }
        assertFalse(productRepository.findById(product1.getId()).isPresent());
    }

}
package com.kodilla.ecommercee.dbServices;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupDbService {

    private final GroupRepository groupRepository;

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(final Long id){
        return groupRepository.findById(id);
    }

    public Group createGroup(final Group group){ return groupRepository.save(group);}

    public void deleteGroup(final Long id){
        groupRepository.deleteById(id);
    }

    //public Group updateGroup(final Group group){ return GroupRepository.save(group);}

}

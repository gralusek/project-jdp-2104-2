package com.kodilla.ecommercee.dbServices;

import com.kodilla.ecommercee.Dto.GroupDto;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.exceptions.GroupNotExist;
import com.kodilla.ecommercee.mappers.GroupMapper;
import com.kodilla.ecommercee.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupDbService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(final Long id){
        return groupRepository.findById(id);
    }

    public Group saveGroup(final Group group){ return groupRepository.save(group);}

    public void deleteGroup(final Long id){
        groupRepository.deleteById(id);
    }

    public GroupDto updateGroup(final Long groupId, final GroupDto groupDto) throws GroupNotExist {
        return groupRepository.findById(groupId)
                .map(group -> {
                    group.setName(groupDto.getName());
                    groupRepository.save(group);
                    return groupMapper.mapToGroupDto(group);
                })
                .orElseThrow(() -> new GroupNotExist());
    }
}

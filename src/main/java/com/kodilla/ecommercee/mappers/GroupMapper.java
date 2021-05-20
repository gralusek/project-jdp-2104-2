package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.Dto.GroupDto;
import com.kodilla.ecommercee.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    @Autowired
    private ProductMapper productMapper;

    public Group mapToGroup(final GroupDto groupDto){
        return new Group(
                groupDto.getGroupId(),
                groupDto.getName(),
                productMapper.mapToProductList(groupDto.getProductDtoList())
        );
    }

    public GroupDto mapToGroupDto(final Group group){
        return new GroupDto(
                group.getGroupId(),
                group.getName(),
                productMapper.mapToProductDtoList(group.getProducts())
        );
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList){
        return groupList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}

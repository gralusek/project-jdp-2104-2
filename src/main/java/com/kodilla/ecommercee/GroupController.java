package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.GroupDto;
import com.kodilla.ecommercee.dbServices.GroupDbService;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.exceptions.GroupNotExist;
import com.kodilla.ecommercee.mappers.GroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    private final GroupMapper groupMapper;
    private final GroupDbService groupDbService;

    @Autowired
    public GroupController(GroupMapper groupMapper, GroupDbService groupDbService) {
        this.groupMapper = groupMapper;
        this.groupDbService = groupDbService;
    }

    @GetMapping(value="getGroups")
    public List<GroupDto> getGroups() {
        List<Group> groups = groupDbService.getAllGroups();
        return groupMapper.mapToGroupDtoList(groups);
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotExist {
        return groupMapper.mapToGroupDto(
                groupDbService.getGroup(groupId).orElseThrow(GroupNotExist::new)
        );
    }

    @PostMapping(value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        Group group = groupMapper.mapToGroup(groupDto);
        groupDbService.saveGroup(group);
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestParam Long groupId, @RequestBody GroupDto groupDto) throws GroupNotExist {
        return groupDbService.updateGroup(groupId, groupDto);
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {
        groupDbService.deleteGroup(groupId);
    }
}

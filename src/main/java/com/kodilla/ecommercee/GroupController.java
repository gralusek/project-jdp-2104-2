package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.GroupDto;
import com.kodilla.ecommercee.Dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @GetMapping(value="getGroups")
    public List<GroupDto> getGroups() {
        List<GroupDto> groups = new ArrayList<>();
        return groups;
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) {
        return new GroupDto(1L, "test group name", new ArrayList<>());
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {
        System.out.println("Group deleted.");
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestParam GroupDto groupDto) {
        return new GroupDto(1L, "Edited group name", new ArrayList<>());
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {

    }
}

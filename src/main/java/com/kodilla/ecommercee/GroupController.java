package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.GroupDto;
import com.kodilla.ecommercee.Dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/group/")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value="getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(Long groupId) {
        return new GroupDto(1L, "test group name", new List<ProductDto>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ProductDto> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(ProductDto productDto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ProductDto> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends ProductDto> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public ProductDto get(int index) {
                return null;
            }

            @Override
            public ProductDto set(int index, ProductDto element) {
                return null;
            }

            @Override
            public void add(int index, ProductDto element) {

            }

            @Override
            public ProductDto remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ProductDto> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ProductDto> listIterator(int index) {
                return null;
            }

            @Override
            public List<ProductDto> subList(int fromIndex, int toIndex) {
                return null;
            }
        });
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(Long groupId) {

    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(GroupDto groupDto) {
        return new GroupDto(1L, "Edited group name", new List<ProductDto>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ProductDto> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(ProductDto productDto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ProductDto> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends ProductDto> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public ProductDto get(int index) {
                return null;
            }

            @Override
            public ProductDto set(int index, ProductDto element) {
                return null;
            }

            @Override
            public void add(int index, ProductDto element) {

            }

            @Override
            public ProductDto remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ProductDto> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ProductDto> listIterator(int index) {
                return null;
            }

            @Override
            public List<ProductDto> subList(int fromIndex, int toIndex) {
                return null;
            }
        });
    }

    public void createGroup(GroupDto groupDto) {

    }
}

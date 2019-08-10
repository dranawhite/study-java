package com.dranawhite.study.springboot.security;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite
 * @version : MethodSecurityService.java, v 0.1 2019-08-10 10:28 dranawhite Exp $$
 */
@Service
public class MethodSecurityService {

    @PostFilter("filterObject != #filterId")
    public List<Integer> filterById(int filterId) {
        // 过滤掉结果中filterObject != #filterId为false的数值
        List<Integer> list = new ArrayList<>();
        final int size = 10;
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}

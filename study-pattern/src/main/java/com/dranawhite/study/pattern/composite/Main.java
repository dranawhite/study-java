package com.dranawhite.study.pattern.composite;

import com.dranawhite.common.text.JsonUtil;

/**
 * 通过循环和递归从数据库中读取数据组装菜单树
 *
 * @author dranawhite
 * @version : Main.java, v 0.1 2019-08-13 18:39 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        BranchMenu branch1 = new BranchMenu("菜单1");
        BranchMenu branch2 = new BranchMenu("菜单2");
        BranchMenu root = new BranchMenu("根菜单");
        LeafMenu leaf1 = new LeafMenu("叶子1");
        LeafMenu leaf2 = new LeafMenu("叶子2");

        root.addChildren(branch1);
        root.addChildren(branch2);
        branch1.addChildren(leaf1);
        branch1.addChildren(leaf2);

        System.out.println(JsonUtil.toJsonString(root));
    }

}

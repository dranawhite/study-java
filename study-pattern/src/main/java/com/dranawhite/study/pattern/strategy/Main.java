package com.dranawhite.study.pattern.strategy;

/**
 *
 * @author dranawhite
 * @version : Main.java, v 0.1 2019-08-07 18:08 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        UserContext userCtx = new UserContext();
        IUserService rootUserService = userCtx.select("root");
        rootUserService.printUserRole();

        IUserService otherUserService = userCtx.select("other");
        otherUserService.printUserRole();
    }
}

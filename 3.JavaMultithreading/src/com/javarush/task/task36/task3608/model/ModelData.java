package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.Solution;
import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public class ModelData {
    private List<User> users;
    public List<User> getUsers() {
        return users;
    }
    private boolean displayDeletedUserList = false;

    public void setUsers(List<User> users) {
        this.users = users;
    }

//active user
    private User activeUser;

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}

package com.service;

import com.model.User;
import com.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Users list = new Users();

    static {
        list.getUserList().add(new User("name1", "pass1", "email1", "city1"));
        list.getUserList().add(new User("name2", "pass2", "email2", "city2"));
        list.getUserList().add(new User("name3", "pass3", "email3", "city3"));
    }

    public static Users getList() {
        return list;
    }

    public void addUser(User user) {
        list.getUserList().add(user);
    }

}

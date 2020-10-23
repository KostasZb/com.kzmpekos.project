package com.example.demo.viewmodels;

import com.proto.users.User;

public class UserHomeViewModel extends BaseViewModel {
    private User user;
    public UserHomeViewModel(){}
    public UserHomeViewModel(User user){
        super("User Home","User Home");
        setUser(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

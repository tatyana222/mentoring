package com.epam.mentoring.mongodb.repository.friendship;

import com.epam.mentoring.mongodb.model.User;

public class FriendshipResult {

    private int month;
    private User user;
    private int maxNumber;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}

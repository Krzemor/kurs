package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String username;
    private final char gender;
    private final LocalDate birthday;
    private final int postsCount;

    public ForumUser(int id, String username, char gender, LocalDate birthday, int postsCount) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.postsCount = postsCount;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", postsCount=" + postsCount +
                '}';
    }
}

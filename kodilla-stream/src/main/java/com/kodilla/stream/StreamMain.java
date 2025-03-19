package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForum = new Forum();

        Map<Integer, ForumUser> theMapOfUsers = theForum.getUsersList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> Period.between(forumUser.getBirthday(), LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getPostsCount() > 0)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        theMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}

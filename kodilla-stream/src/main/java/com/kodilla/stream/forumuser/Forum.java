package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUsersList = new ArrayList<>();

    public List<ForumUser> getUsersList() {
        theUsersList.add(new ForumUser(1, "death12", 'M', LocalDate.of(1995, 5, 15), 0));
        theUsersList.add(new ForumUser(2, "fishEnjoyer", 'F', LocalDate.of(2000, 12, 6), 45));
        theUsersList.add(new ForumUser(3, "bigBoy", 'M', LocalDate.of(1998, 1, 31), 505));
        theUsersList.add(new ForumUser(4, "cat123", 'F', LocalDate.of(2008, 6, 12), 84));
        theUsersList.add(new ForumUser(5, "asteroidDestroyer2121", 'M', LocalDate.of(2002, 8, 26), 3000));

        return new ArrayList<>(theUsersList);
    }

}

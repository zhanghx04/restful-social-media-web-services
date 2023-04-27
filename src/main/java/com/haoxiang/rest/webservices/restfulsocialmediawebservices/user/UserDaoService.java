package com.haoxiang.rest.webservices.restfulsocialmediawebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Josh", LocalDate.now().minusYears(60)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
        // orElse here will show the webpage with empty page when the url is wrong
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);

        return user;
    }
}

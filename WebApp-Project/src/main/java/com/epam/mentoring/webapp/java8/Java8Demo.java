package com.epam.mentoring.webapp.java8;

import com.epam.mentoring.webapp.domain.Role;
import com.epam.mentoring.webapp.domain.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.mentoring.webapp.domain.Role.ADMIN;
import static com.epam.mentoring.webapp.domain.Role.USER;

public class Java8Demo {

    public static void main(String[] args) {
        List<User> users = prepareUsers();

        System.out.println("Filtering");
        users.stream()
                .filter(u -> u.getRole() == ADMIN)
                .filter(u -> u.getName().startsWith("A"))
                .forEach(System.out::println);

        System.out.println("Sorting");
        users.stream()
                .sorted(Comparator.comparing(User::getName).thenComparingLong(User::getId))
                .forEach(System.out::println);

        System.out.println("Map");
        users.stream()
                .map(User::getEmail)
                .filter(e -> e.contains("kz"))
                .forEach(System.out::println);

        System.out.println("Reduce");
        System.out.println(Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(n -> n > 5)
                .reduce(0, (x, y) -> x + y));

        System.out.println("Collect to map");
        Map<Long, Role> idsToRoles = users.stream()
                .filter(u -> u.getRole() == USER)
                .collect(Collectors.toMap(User::getId, User::getRole));
        System.out.println(idsToRoles);

        System.out.println("Max id");
        OptionalLong max = users.stream()
                .mapToLong(User::getId)
                .peek(System.out::println)
                .max();
        if (max.isPresent()) {
            System.out.println("Max = " + max.getAsLong());
        } else {
            System.out.println("No max value found");
        }

        System.out.println("Min id");
        OptionalLong min = users.stream()
                .mapToLong(User::getId)
                .peek(System.out::println)
                .min();
        if (min.isPresent()) {
            System.out.println("Min = " + min.getAsLong());
        } else {
            System.out.println("No min value found");
        }
    }

    private static List<User> prepareUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "sammy", "user1_password", USER, "Sam", "user1@user-email.com"));
        users.add(new User(2L, "user2", "user2_password", USER, "Axel", "user2@user-email.com"));
        users.add(new User(3L, "yelena_admin", "user3_password", ADMIN, "Yelena", "yelena_admin@admin.kz"));
        users.add(new User(4L, "user4", "user4_password", USER, "Axel", "user4@email.kz"));
        users.add(new User(5L, "admin", "user5_password", ADMIN, "Admin", "admin@admins.kz"));
        return users;
    }
}

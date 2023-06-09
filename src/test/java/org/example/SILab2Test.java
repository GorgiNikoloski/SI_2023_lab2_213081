package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    public void Every_Branch_Test() {

        // Test case 1: Ako nekoe od e-mail i pasvord se null (vrajka runtime exception)
        List<User> allUsers1 = new ArrayList<>();
        User user1 = new User(null, null, "mail@example.com");
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user1, allUsers1));

        // Test case 2: ako imame nevaliden e-mail (vrajka false)
        List<User> allUsers2 = new ArrayList<>();
        User user2 = new User("user", "password123", "nevaliden");
        boolean result2 = SILab2.function(user2, allUsers2);
        Assertions.assertFalse(result2);

        // Test case 3: ako imame nevaliden pasvord i pasvordot da e so prazno mesto i pomalku od 8 karakteri (vrajka false)
        List<User> allUsers3 = new ArrayList<>();
        User user3 = new User("user", "pas 23", "mail@example.com");
        boolean result3 = SILab2.function(user3, allUsers3);
        Assertions.assertFalse(result3);

        // Test case 4: ako imame null username da se setira na email
        List<User> allUsers4 = new ArrayList<>();
        User user4 = new User(null, "password123", "email@example.com");
        SILab2.function(user1, allUsers1);
        Assertions.assertEquals("email@example.com", user1.getUsername());

        // Test case 5: Ako imame postoecki email ili username vo allUsers listata (treba da vrati false)
        List<User> allUsers5 = new ArrayList<>();
        User user5 = new User("username", "newpassword", "username@example.com");
        User existingUser = new User("user", "password456", "user@example.com");
        allUsers5.add(existingUser);
        boolean result5 = SILab2.function(user5, allUsers5);
        Assertions.assertFalse(result5);

    }


}
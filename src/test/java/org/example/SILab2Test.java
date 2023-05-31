package org.example;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    public void Every_Branch_Test() {

        // Test case 1: Null username and password - should throw RuntimeException
        List<User> allUsers1 = new ArrayList<>();
        User user1 = new User(null, null, "johndoe@example.com");
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user1, allUsers1));

        // Test case 2: Invalid email - should return false
        List<User> allUsers2 = new ArrayList<>();
        User user2 = new User("JohnDoe", "password123", "johndoeexample.com");
        boolean result2 = SILab2.function(user2, allUsers2);
        Assertions.assertFalse(result2);

        // Test case 3: Invalid password (contains blank space and less than 8 characters) - should return false
        List<User> allUsers3 = new ArrayList<>();
        User user3 = new User("JohnDoe", "johndoe", "johndoe@example.com");
        boolean result3 = SILab2.function(user3, allUsers3);
        Assertions.assertFalse(result3);

        // Test case 4: Null username - should update username with email
        List<User> allUsers4 = new ArrayList<>();
        User user4 = new User(null, "password123", "johndoe@example.com");
        SILab2.function(user1, allUsers1);
        Assertions.assertEquals("johndoe@example.com", user1.getUsername());

        // Test case 5: Existing email in allUsers list - should return false
        List<User> allUsers5 = new ArrayList<>();
        User user5 = new User("JohnDoe", "newpassword", "johndoe@example.com");
        User existingUser = new User("JaneSmith", "password456", "janesmith@example.com");
        allUsers2.add(existingUser);
        boolean result5 = SILab2.function(user2, allUsers2);
        Assertions.assertFalse(result5);


    }


}
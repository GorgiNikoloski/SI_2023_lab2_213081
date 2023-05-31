package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){
            throw new RuntimeException("Mandatory information missing!");
        }

        if (user.getUsername()==null){
            user.setUsername(user.getEmail());
        }

        int same = 1;
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {
            same = 0;
            for (int i=0;i<allUsers.size();i++) {
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) {
                    same += 1;
                }
                if (existingUser.getUsername() == user.getUsername()) {
                    same += 1;
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) {
            return false;
        }
        else {
            if (!passwordLower.contains(" ")) {
                for (int i = 0; i < specialCharacters.length(); i++) {
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {
                        return same == 0;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {


        List<User> allUsers = new ArrayList<>();
        User postoecki = new User("JohnDoe", "password123", "johndoe@example.com");


        User user1 = new User("username", null, "johndoe@example.com");
        User user2 = new User("JohnDoe", "password123", "nevaliden");
        User user3 = new User("JohnDoe", "pas jj", "johndoe@example.com");
        User user4 = new User(null, "password123", "johndoe@example.com");
        User user5 = new User("JohnDoe", "password123#", "johndoe@example.com");




        boolean result = SILab2.function(user5, allUsers);
        System.out.println("Result: " + result);
    }

}
package com.example.project21.userdata;

import java.util.ArrayList;

public class UserDataHandler {

    private static final ArrayList<User> userlist = new ArrayList<>();

    public static ArrayList<User> getUserList(){
        return userlist;
    }
    public static void addUser(User user){
        userlist.add(user);
    }
    public static void removeUser(User user){

        for(User u : userlist){

            if(u.equals(user)) {
                userlist.remove(u);
                break;
            }

        }

    }
    public static boolean containsUser(User user){

            for (User u : userlist) {

                if (u.equals(user))
                    return true;

            }
        return false;

    }
    public static boolean isAuthenticated(User user){

        return UserDataHandler.containsUser(user);

    }
    public static User getUserByLoginData(String email, String password){

        User user = new User(new UserDataSet(email, password, Role.TEMPORARY_LOGIN));

        for(User u : userlist){

            if(u.equals(user))
                return u;

        }
        return null;

    }
}

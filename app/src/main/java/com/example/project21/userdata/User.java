package com.example.project21.userdata;

public class User {

    private UserDataSet dataset;
    private static User currentUser;
    private static int failAttempts;

    public User(UserDataSet dataset){
        this.dataset = dataset;
    }

    public User(){
        dataset = new UserDataSet(null, null, Role.GUEST);
    }

    public static int getFailAttempts() {
        return failAttempts;
    }

    public static void setFailAttempts(int failAttempts) {
        User.failAttempts = failAttempts;
    }

    public UserDataSet getDataset(){
        return dataset;
    }
    public boolean equals(User user){

        if(user != null && User.hasCurrentUser()) {

            if(this.getDataset().getRole() != Role.GUEST) {

                return this.getDataset().getEmail().equals(user.getDataset().getEmail()) &&
                        this.getDataset().getPassword().equals(user.getDataset().getPassword());

            }
        }
        return false;

    }
    public static User getCurrentUser(){

        return currentUser;

    }
    public static void setCurrentUser(User currentUser){

        if(currentUser != null)
               if(UserDataHandler.containsUser(currentUser))
            User.currentUser = currentUser;
        else
            User.currentUser = null;

    }
    public static boolean hasCurrentUser(){
        return User.currentUser != null;
    }

}

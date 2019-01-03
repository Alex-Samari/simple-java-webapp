package appLayer;

import dataLayer.DB_user;

public class User {

    public boolean isValidUserCredentials(String userName, String userPassword){
        //  creating a new data base user object
        DB_user DB_user_obj = new DB_user();

        //  validating the user credentials
        return DB_user_obj.isValidUserLogin(userName, userPassword);
    }
}

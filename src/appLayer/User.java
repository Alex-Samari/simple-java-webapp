package appLayer;

public class User {

    public boolean isValidUserCredentials(String userName, String userPassword){
        if(userName.equals("Alex") && userPassword.equals("test123")){
            return true;
        }
        else
            return false;
    }
}

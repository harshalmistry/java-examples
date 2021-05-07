package java8.optional;

import java.util.Optional;

/**
 * This class demonstrates how to use Optional in authentication scenario.
 * Idea is how Optional can be used to perform check on input and response in terms of yes/no.
 *
 * @author niharsh
 * @created 07/05/2021 - 23:15
 */
public class AuthenticationUsingOptionalExample {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {
        //Suppose below Credentials are supplied through user inputs.
        Credentials creds = new Credentials("admin", "admin12");
        boolean isValidCred = authenticate(creds);
        System.out.println("Is supplied credentials valid? "+isValidCred);
    }

    private static boolean authenticate(Credentials credentials){
        return Optional
                .ofNullable(credentials)
                .filter(cred -> cred.getUserName().equals(USERNAME))
                .filter(cred -> cred.getPassword().equals(PASSWORD))
                .isPresent();
    }
}

class Credentials{
    private String userName;
    private String password;

    public Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


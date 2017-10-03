package model.user;


import model.Crudable;
import model.internship.Internship;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class User implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    private String infix;
    private String email;
    private String password;
    private boolean isModerator;



    public User() {

    }

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.infix = "aa";
        this.email = "aa";
        this.password = "aa";
        this.isModerator = true;
    }

    User(String firstName, String lastName, String infix, String email, String password, boolean isModerator) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.infix = infix;
        this.email = email;
        this.password = password;
        this.isModerator = isModerator;
    }

    @Override
    public boolean isIncomplete() {
        return firstName == null ||
                lastName == null ||
                email == null ||
                password == null;
    }

    @Override
    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (firstName == null) list.add("firstName");
        if (lastName == null) list.add("lastName");
        if (email == null) list.add("email");
        if (password == null) list.add("password");


        return list;
    }

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }



    //endregion


}
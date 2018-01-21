package model.user;


public class UserBuilder {

    private String firstName = "";

    private String lastName = "";

    private String infix = "";

    private String email = "";

    private String password = "";

    private String study = "";

    private boolean isModerator = false;


    public UserBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastname(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UserBuilder infix(String infix){
        this.infix = infix;
        return this;
    }

    public UserBuilder email(String email){
        this.email = email;
        return this;
    }

    public UserBuilder password(String password){
        this.password = password;
        return this;
    }

    public UserBuilder study(String study){
        this.study = study;
        return this;
    }

    public UserBuilder isModerator(boolean isModerator){
        this.isModerator = isModerator;
        return this;
    }

    public User build(){
        return new User(firstName,lastName,infix,email,password,isModerator, study);
    }

}

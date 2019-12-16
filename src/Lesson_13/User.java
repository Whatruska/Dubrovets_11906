package Lesson_13;

public class User {
    protected String surname;
    protected String name;
    protected String patronym;

    protected String password;
    protected String login;

    public User(String surname, String name, String patronym, String password, String login) {
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
        this.password = password;
        this.login = login;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getFullName(){
        return surname + " " + name + " " + password;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}

package utp.edu.pe.corpgen.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String email;
    private String name;
    private String lastName;
    private String password;


    public User(int id, String email, String name, String lastName, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public static User from(ResultSet rs){

        try {
            return new User(rs.getInt("ID_user"),
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("lastname"),
                    rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


}

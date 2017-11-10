package utp.edu.pe.corpgen.models;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String email;
    private String name;
    private String lastNa;
    private String passwd;


    public User(int id, String email, String name, String lastNa, String passwd) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastNa = lastNa;
        this.passwd = passwd;
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

    public String getLastNa() {
        return lastNa;
    }

    public User setLastNa(String lastNa) {
        this.lastNa = lastNa;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public User setPasswd(String passwd) {
        this.passwd = passwd;
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

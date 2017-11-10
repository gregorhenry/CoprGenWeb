package utp.edu.pe.corpgen.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile {

    private int id;
    private String description;
    private String name;
    private User user;

    public Profile(int id, String description, String name, User user) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.user = user;
    }


    public Profile() {
    }

    public int getId() {
        return id;
    }

    public Profile setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Profile setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Profile setName(String name) {
        this.name = name;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Profile from (ResultSet resultSet, UsersEntitys usersEntitys){
        Profile profile = new Profile();
        try {
            profile.setId(resultSet.getInt("ID_profile"))
                    .setDescription(resultSet.getString("Description"))
                    .setName(resultSet.getString("Name"))
                    .setUser(usersEntitys.findById(resultSet.getInt("ID_user")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

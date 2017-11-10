package utp.edu.pe.corpgen.models;

import sun.dc.pr.PRError;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfilesEntity extends BaseEntity {

    public ProfilesEntity(Connection connection, String tableName){

        super(connection,tableName);
    }

    public ProfilesEntity(){
        super();
        setTableName("profile");
    }


    public Profile findById(int id, UsersEntitys usersEntitys){
        return findByCriteria(
                        String.format("WHERE ID_profile = '%s'", id), usersEntitys).get(0);

    }

    public List<Profile> findByCriteria(String criteria, UsersEntitys usersEntitys){

        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement()
                            .concat(criteria));
            List<Profile> profiles = new ArrayList<>();
            while (resultSet.next())
                profiles.add(Profile.from(resultSet,usersEntitys));

            return profiles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Profile> findAll(UsersEntitys usersEntitys) {
        return findByCriteria("", usersEntitys);
    }

    public boolean create(Profile profile)
    {
        return excuteUpdate(String.format("INSERT INTO %s(ID_profile, Description,Name,ID_user) VALUES('%s','%s','%s', %d )",
                getTableName(), profile.getId(),profile.getDescription(),profile.getName(),profile.getUser().getId()));
    }

    public boolean create(int id, String descriptiom, String name,User user){
        return create(new Profile(id,descriptiom,name,user));
    }

    public boolean update(int id, String description,String name, User user){

        return excuteUpdate(String .format("UPDATE %s SET description = '%s', name = '%s', ID_user = %d WHERE ID_profile = '%s'",getTableName(),description,name,id,user));

    }

    public boolean update(Profile profile){

        return update(profile.getId(),profile.getDescription(),profile.getName(),profile.getUser());
    }


    public boolean erase(int id){

        return excuteUpdate(String.format("DELETE FROM %s WHERE ID_profile = '%s'"));
    }


}



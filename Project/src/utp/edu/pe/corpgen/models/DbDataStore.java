package utp.edu.pe.corpgen.models;

import java.sql.Connection;
import java.util.List;

public class DbDataStore {

    private Connection connection;
    private UsersEntitys user;
    private ProfilesEntity profile;

    public DbDataStore(Connection connection){
        this.connection = connection;
    }

    public  DbDataStore(){

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Profile findProfielbyId(int id){
        if (connection == null)return null;
        return getProfile().findById(id,getUser());
    }

    public User findUserById(int id){
        if (connection == null)return null;
        return getUser().findById(id);
    }

    public List<User> findAllUser(){
        return connection == null ? null: getUser().findAll();
    }

    public User createUser(String email,String name, String lastname, String passwd){
            return connection == null ? null :
                    getUser().create(email,name,lastname,passwd);
    }

    public boolean AuthenticationUser(String email, String passw){

        return getUser().Authentication(email,passw);
    }

    public boolean updateUser(int id, String email, String name, String lastname, String passwd){
        return connection == null ?
                false :
                getUser().update(id,email,name,lastname,passwd);
    }

    public  boolean updateUser(User user){
        return updateUser(user.getId(),user.getEmail(),user.getName(),user.getLastNa(),user.getPasswd());

    }

    public boolean eraseUser(int id){
        return connection == null ? null :
                getUser().erase(id);
    }



    public UsersEntitys getUser() {
        if (user == null){
            user = new UsersEntitys();
            user.setConnection(connection);
        }
        return user;
    }


    public ProfilesEntity getProfile() {
        if (profile == null){
            profile = new ProfilesEntity();
            profile.setConnection(connection);
        }
        return profile;
    }

}

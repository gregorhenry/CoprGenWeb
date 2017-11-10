package utp.edu.pe.corpgen.services;

import utp.edu.pe.corpgen.models.DbDataStore;
import utp.edu.pe.corpgen.models.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CoServices {

    Connection connection;
    DbDataStore dbDataStore;

    public CoServices(){
        try {
            InitialContext context = new InitialContext();
            dbDataStore = new DbDataStore();
            connection = ((DataSource) context
                    .lookup("JDBCResourceMySQL"))
                    .getConnection();
            dbDataStore.setConnection(connection);

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DbDataStore getDbDataStore() {
        return dbDataStore;
    }

    public void setDbDataStore(DbDataStore dbDataStore) {
        this.dbDataStore = dbDataStore;
    }

    public User findUserById(int id){
        return dbDataStore.findUserById(id);
    }

    public User createUser(String email,String name,String lastname, String passwd)
    {
        return  dbDataStore.createUser(email,name,lastname,passwd);
    }
    public List<User> findAllUsers(){return dbDataStore.findAllUser();}

    public boolean AuthenticationUser(String email, String passw){
        return dbDataStore.AuthenticationUser(email,passw);
    }

    public boolean updateUser(int id,String email,String name,String lastname, String passwd ){

        return dbDataStore.updateUser(id,email,name,lastname,passwd);
    }
}

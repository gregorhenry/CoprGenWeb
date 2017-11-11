package utp.edu.pe.corpgen.services;

import utp.edu.pe.corpgen.models.DbDataStore;
import utp.edu.pe.corpgen.models.Products;
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


    /**User**/
    public User findUserById(int id){
        return dbDataStore.findUserById(id);
    }

    public boolean createUser(User user)
    {
        return  dbDataStore.createUser(user);
    }
    public List<User> findAllUsers(){
        return dbDataStore.findAllUser();
    }

    public boolean AuthenticationUser(String email, String password){
        return dbDataStore.AuthenticationUser(email,password);
    }

    /**=========================Se necesita comprobar========================*/
    public boolean AuthenticationUser(User user){
        return dbDataStore.AuthenticationUser(user);
    }
    /**======================================================================*/
    public boolean updateUser(User user){

        return dbDataStore.updateUser(user);
    }

    /**Product**/

    public List<Products> findAllProducts(){
        return dbDataStore.findAllProducts();
    }

    public Products findProductsById(int id){
        return dbDataStore.findProductsById(id);
    }


    public  Products createProduct(Products products){
        return dbDataStore.createProduct(products);
    }

    public boolean updateProduct(Products products){
        return dbDataStore.updateProduct(products);
    }

    public boolean dropProduct(Products products){
        return dbDataStore.dropProduct(products);
    }
}

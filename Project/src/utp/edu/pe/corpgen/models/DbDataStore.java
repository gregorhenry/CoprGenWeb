package utp.edu.pe.corpgen.models;

import java.sql.Connection;
import java.util.List;

public class DbDataStore {

    private Connection connection;
    private UsersEntity usersEntity;
    private ProfilesEntity profilesEntity;
    private ProductEntity productEntity;

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

    
    
    /**User**/

    public UsersEntity getUsersEntity() {
        if (usersEntity == null){
            usersEntity = new UsersEntity();
            usersEntity.setConnection(connection);
        }
        return usersEntity;
    }
    

        /**Listas**/

        public List<User> findAllUser(){
            return connection == null ? null: getUsersEntity().findAll();
        }


        public User findUserById(int id){
        if (connection == null)return null;
        return getUsersEntity().findById(id);
        }

        /**DLM's**/
            public boolean createUser(User user){
                return connection == null ? false :
                getUsersEntity().create(user);
            }
            public boolean AuthenticationUser(String email, String password){
                return getUsersEntity().Authentication(email,password);
            }
/**============**/
            public boolean AuthenticationUser(User user){
                return getUsersEntity().Authentication(user);
            }

/**===========**/

            public boolean updateUser(User user){
                 return connection == null ? false : getUsersEntity().update(user);
            }


            public boolean eraseUser(int id){
                    return connection == null ? false:getUsersEntity().eraseById(id);
            }

            public boolean eraseUser(User user){
                return connection==null ? false : getUsersEntity().eraseById(user.getId());
            }



   

    /**Profile**/

    public Profile findProfileById(int id){
        return connection == null? null:getProfilesEntity().findById(id, getUsersEntity());
    }

    public ProfilesEntity getProfilesEntity() {
        if (profilesEntity == null){
            profilesEntity = new ProfilesEntity();
            profilesEntity.setConnection(connection);
        }
        return profilesEntity;
    }


    /**Products**/

    public ProductEntity getProductEntity(){
        if(productEntity == null){
            productEntity=new ProductEntity();
            productEntity.setConnection(connection);
        }
        return productEntity;
    }
        /**Listas**/

            public Products findProductsById(int id){
                return  connection == null ? null : getProductEntity().findById(id);
            }

            public List<Products> findAllProducts(){
                return connection == null ? null : getProductEntity().findAll();
            }




    /**DML's**/

    public Products createProduct(Products products){
        return connection == null ? null : getProductEntity().create(products);
    }

    public boolean updateProduct(int id ,String name,double price,String picture,String description){
        return connection == null ? false : getProductEntity().update(id,name,price,picture,description);
    }
    public boolean updateProduct(Products products) {
        return updateProduct(products.getId(),products.getName(),products.getPrice(),products.getPicture(),products.getDescription());
    }

    public boolean dropProduct(Products products){
        return connection==null?false:getProductEntity().drop(products);
    }



}

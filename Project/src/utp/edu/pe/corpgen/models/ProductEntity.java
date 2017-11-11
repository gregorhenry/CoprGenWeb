package utp.edu.pe.corpgen.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductEntity extends BaseEntity {

    public ProductEntity(){
        super();
        setTableName("products");
    }

    public ProductEntity(Connection connection, String tableName){
        super(connection,tableName);
    }

    public List<Products> findByCriteria(String criteria){
        try {
            ResultSet rs=getConnection().createStatement().executeQuery(
                    getBaseStatement().concat(criteria));
            List <Products> products = new ArrayList<>();
            while (rs.next()){
                products.add(Products.from(rs));
                return products;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public Products findById(int id){
        return findByCriteria("WHERE ID_product = ".concat(String.valueOf(id))).get(0);
    }


    public Products findByName(String name) {
        return findByCriteria(
                "WHERE Name = '"
                        .concat(name)
                        .concat("'")).get(0);
    }

    public List<Products> findAll() {
        return findByCriteria("");
    }


    private int getMaxId(){
        String sql =  "SELECT MAX(ID_product) AS max_id FROM Products";

        try {
            ResultSet rs = getConnection()
                    .createStatement().executeQuery(sql);
            return rs.next() ? rs.getInt("max_id") : 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    //DLM restantes


    public Products create(Products products) {
        return excuteUpdate(String.format("INSERT INTO %s (ID_product, Name, Price, Picture, Description) VALUES(%d, '%s', '%d', '%s', '%s')",
                getTableName(),products.getId(),products.getName(),products.getPrice(),products.getDescription())) ? products :null;
    }

    /**A usar*/
    public Products create(String name,double price,String picture,String description){
        return create(getMaxId()+1,name,price,picture,description);
    }
    /**------**/

    public Products create(int id, String name,double price,String picture,String description){
        return create(new Products(id,name,picture,description,price));
    }

    public boolean update (int id,String name,double price,String picture,String description){
        return excuteUpdate(String.format("update %s SET ID_product = '%d' , name = '%s', price = '%d' , picture = '%s', Description = '%s'",getTableName(),id,name,price,picture,description));
    }

    public boolean update(Products products) {
        return update(products.getId(),products.getName(),products.getPrice(),products.getPicture(),products.getDescription());
    }

    public boolean drop (int id){
        return excuteUpdate(String.format("delete from %s where ID_product=%d ",getTableName(),id));
    }

    public boolean drop(Products products){
        return excuteUpdate(String.format("delete from %s where ID_product=%d",getTableName(),products.getId()));
    }
}
/**
 public boolean create(int id, String name,double price,String picture,String description){
 return create(getMaxId()+1,name,price,picture,description);
 }

 public boolean create(Country country) {
 return executeUpdate(String.format(
 "INSERT INTO %s(country_id, country_name, region_id) VALUES('%s', '%s', %d)",
 getTableName(), country.getId(), country.getName(), country.getRegion().getId()));
 }

 public boolean create(String id, String name, Region region) {
 return create(new Country(id, name, region));
 }
 **/


/**
 public boolean drop(Products products){
 return drop(products.getId());
 }
 **/
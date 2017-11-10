package utp.edu.pe.corpgen.models;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntitys  extends  BaseEntity{

    public UsersEntitys(){
        super();
        setTableName("user");
    }

    public UsersEntitys(Connection connection, String tableName){
        super(connection,tableName);
    }

    public User findById(int id){
        return findByCriteria(String.format("WHERE ID_user = %d",id)).get(0);
    }

    public List<User> findByCriteria(String criteria)
    {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<User> user = new ArrayList<>();
            while (rs.next())
                user.add(User.from(rs));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public User findByName(String name){

        return findByCriteria(String.format("WHERE name = '%s'",name)).get(0);
    }

    public boolean Authentication(String email, String passwd){
        PreparedStatement preparedStatement;
        ResultSet set = null;
        String consulta = "SELECT * FROM ".concat(tableName)+" WHERE email = ? and password = ?";
        try {
            preparedStatement = getConnection().prepareStatement(consulta);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,passwd);

            set = preparedStatement.executeQuery();
            if (set.absolute(1)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("error");
        }finally {
            if (getConnection()!=null){
                try {
                    getConnection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public List<User> findAll() {
        return findByCriteria("");
    }



    public User create(User user){
        //INSERT INTO %s(region_id, region_name) VALUES(%d, '%s')",
        return excuteUpdate(String .format("INSERT INTO %s (ID_user, email, name, lastname, password) VALUES(%d, '%s', '%s', '%s', '%s')",
                getTableName(), user.getId(),user.getEmail(),user.getName(),user.getLastNa(),user.getPasswd())) ?
                user : null;
    }


    private int getMaxId(){
        String sql =  "SELECT MAX(ID_user) AS max_id FROM user";

        try {
            ResultSet set = getConnection()
                    .createStatement().executeQuery(sql);
            return set.next() ? set.getInt("max_id") : 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public User create(String email,String name,String lastname, String passwd ){
       return create(getMaxId()+1,email,name,lastname,passwd);
    }

   public User create(int id, String email,String name,String lastname, String passwd){
        return create(new User(id,email,name,lastname,passwd));
   }





    //TODO faltan valores en la sentencia sql UPDATE
    public boolean update(int id, String email, String name, String lastname, String passwd){
        return excuteUpdate(String.format("UPDATE %s SET email = '%s', name = %d , lastname = %d, password = %d  WHERE ID_user = %d",getTableName(),email,name,lastname,passwd,id));


    }

    public boolean update(User user){

        return update(user.getId(),user.getEmail(),user.getName(),user.getLastNa(),user.getPasswd());
    }





    public boolean erase(int id) {
        return excuteUpdate(String.format("DELETE FROM %s WHERE ID_user = %d",
                getTableName(), id));
    }

    public boolean erase(User user) {
        return excuteUpdate(String.format("DELETE FROM %s WHERE ID_user = %d",
                getTableName(), user.getId()));
    }


}

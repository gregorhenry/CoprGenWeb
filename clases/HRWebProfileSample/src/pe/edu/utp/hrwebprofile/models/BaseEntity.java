package pe.edu.utp.hrwebprofile.models;

import java.sql.Connection;

public class BaseEntity {
    private Connection connection;
    private String tableName;

    public BaseEntity(Connection connection, String tableName) {
        this.setConnection(connection);
        this.setTableName(tableName);
    }

    public BaseEntity() {
    }

    protected String getBaseStatement() {
        return "SELECT * FROM ".concat(getTableName()).concat(" ");
    }

    public Connection getConnection() {
        return connection;
    }

    public BaseEntity setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public BaseEntity setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
}

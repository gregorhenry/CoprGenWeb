package utp.edu.pe.corpgen.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Products {
    int id;
    String name;
    String picture;
    String description;
    double price;

        public Products(int id, String name, String picture, String description, double price) {
            this.id = id;
            this.name = name;
            this.picture = picture;
            this.description = description;
            this.price = price;
        }

        public Products() {
        }


        public int getId() {
            return id;
        }

        public Products setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Products setName(String name) {
            this.name = name;
            return this;
        }

        public String getPicture() {
            return picture;
        }

        public Products setPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public Products setDescription(String description) {
            this.description = description;
            return this;
        }

        public double getPrice() {
            return price;
        }

        public Products setPrice(double price) {
            this.price = price;
            return this;
        }

    public static Products from(ResultSet rs){

        try {
            return new Products(rs.getInt("ID_product"),
                    rs.getString("Name"),
                    rs.getString("Description"),
                    rs.getString("Picture"),
                    rs.getDouble("Price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
    }

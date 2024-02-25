package fr.demo.database;

import fr.demo.database.utils.DbConnection;
import fr.demo.database.utils.DbCredentials;

import java.sql.SQLException;

public class DatabaseManager {
    private DbConnection demoDB;

    public DatabaseManager() {
        //change this informations to match your database
        this.demoDB = new DbConnection(new DbCredentials("localhost", "3306", "root", "", "demobukkit"));
    }

    public DbConnection getDemoDB() {
        return demoDB;
    }

    public void close() {
        try {
            this.demoDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

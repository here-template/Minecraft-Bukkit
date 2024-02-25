package fr.demo.database.utils;

public class DbCredentials {
    private String host;
    private String port;
    private String username;
    private String password;
    private String database;

    public DbCredentials(String host, String port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public String toURI() {
        return "jdbc:mysql://" + host + ":" + port + "/" + database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

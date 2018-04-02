package org.gatech.repositories;

import org.gatech.models.AdminUser;
import org.gatech.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Steph on 2/24/2018.
 */
@Repository
@PropertySource("classpath:application.properties")
public class UserRepository {

    @Autowired
    private Environment env;

    public User findUserByUserNamePassword(String userName, String password) {
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(env.getProperty("spring.datasource.url"),
                    env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
            String query = "SELECT username, first_name, last_name FROM User where username = ? AND password = ?;";

            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, userName);
            st.setString(2, password);

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user.setUserName(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean createUser(String firstName, String lastName, String userName, String password) {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(env.getProperty("spring.datasource.url"),
                    env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
            String query = "INSERT INTO User (first_name, last_name, username, password) VALUES (?, ?, ?, ?);";

            

            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, firstName);
            st.setString(2, lastName);
            st.setString(3, userName);
            st.setString(4, password);

            count = st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public boolean isAdminUser(User user) {
        boolean isAdminUser = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(env.getProperty("spring.datasource.url"),
                    env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
            String query = "SELECT count(*) as count FROM AdminUser au where username = ?;";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, user.getUserName());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                isAdminUser = rs.getInt("count") > 0;
            }
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return isAdminUser;
    }

    public AdminUser fetchAdminUser(User user) {
        AdminUser adminUser = new AdminUser();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(env.getProperty("spring.datasource.url"),
                    env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
            String query = "SELECT au.username, au.position, u.first_name, u.last_name FROM AdminUser au INNER JOIN User u on au.username = u.username where au.username = ?;";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, user.getUserName());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                adminUser.setUserName(rs.getString("username"));
                adminUser.setPosition(rs.getString("position"));
                adminUser.setFirstName(rs.getString("first_name"));
                adminUser.setLastName(rs.getString("last_name"));
            }
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return adminUser;
    }

    public boolean savePosition(User user) {
        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(env.getProperty("spring.datasource.url"),
                    env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
            String query = "UPDATE AdminUser set position = ? where username = ?";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, user.getPosition());
            st.setString(2, user.getUserName());
            int count = st.executeUpdate();

            success = count > 0;
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}

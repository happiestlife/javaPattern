package DaoPattern;

import sun.security.util.Password;
import test.Person;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PasswordDaoWithSqlite implements PasswordDAO{
    private final String DB_NAME = "site_personal_info";
    private final String DB_TABLE_NAME = "id_password";

    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;

    public PasswordDaoWithSqlite() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
            statement = connection.createStatement();
            statement.setQueryTimeout(60);
            final String table = " (url text PRIMARY KEY, id text, password text)";

            statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(PasswordInfo p) {
        try {
            String fmt = "INSERT INTO %s VALUES('%s', '%s', '%s')";
            String q = String.format(fmt, DB_TABLE_NAME, p.getUrl(), p.getId(), p.getPassword());

            statement.execute(q);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PasswordInfo> findAll() {
        ArrayList<PasswordInfo> list = new ArrayList<>();
        try {
            rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
            while(rs.next()){
                list.add(new PasswordInfo(rs.getString("url"),
                        rs.getString("id"), rs.getString("password")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public PasswordInfo findByKey(String url) {
        try {
            String fmt = "SELECT * FROM %s WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, url);

            rs = statement.executeQuery(q);
            if(rs.next()){
                return new PasswordInfo(rs.getString("url"),
                        rs.getString("id"), rs.getString("password"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(PasswordInfo p) {
        PasswordInfo pi = findByKey(p.getUrl());
        if(pi != null) {
            String fmt = "UPDATE %s SET id = '%s', password = '%s' WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, p.getUrl(), p.getId(), p.getPassword());
            try {
                statement.execute(q);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else
            System.out.println("no data");
    }

    @Override
    public void delete(String url) {
        PasswordInfo pi = findByKey(url);
        if(pi != null) {
            String fmt = "DELETE FROM %s WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, url);
            try {
                statement.execute(q);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else
            System.out.println("no data with url " + url);
    }

    @Override
    public void delete(PasswordInfo p) {
        PasswordInfo pi = findByKey(p.getUrl());
        if(pi != null) {
            String fmt = "DELETE FROM %s WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, p.getUrl());
            try {
                statement.execute(q);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else
            System.out.println("no data with url " + p.getUrl());
    }
}

package com.dz.dao.impl;

import com.dz.dao.NewsUserDAO;
import com.dz.entity.NewsUser;
import com.dz.utils.JDBCDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsUserDAOImpl implements NewsUserDAO {

    /**
     * @param newsUser 查询
     * @return 查询结果 newsUsers集合
     */
    @Override
    public List<NewsUser> select(NewsUser newsUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from news_user";
        boolean flag = false;
        if (newsUser != null &&
                (newsUser.getUserName() != null) && !(newsUser.getUserName().trim().equals("")) &&
                (newsUser.getPassword() != null) && (!newsUser.getUserName().trim().equals(""))) {
            sql += " where userName= ? and password=?";
            flag = true;
        }
        List<NewsUser> newsUsers = null;
        try {
            connection = JDBCDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (flag) {
                preparedStatement.setString(1, newsUser.getUserName());
                preparedStatement.setString(2, newsUser.getPassword());
            }
            resultSet = preparedStatement.executeQuery();
            newsUsers = new ArrayList();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer userType = resultSet.getInt("userType");
                newsUsers.add(new NewsUser(id, userName, password, email, userType));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCDruid.close(resultSet, preparedStatement, connection);
        }
        return newsUsers;
    }


    @Override
    public Integer insert(NewsUser newsUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO news_user(id,userName,PASSWORD,email) VALUE (NULL,?,?,?)";
        int i = 0;
        try {
            connection = JDBCDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newsUser.getUserName());
            preparedStatement.setString(2, newsUser.getPassword());
            preparedStatement.setString(3, newsUser.getEmail());
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCDruid.close(null, preparedStatement, connection);
        }
        return i;
    }

    @Override
    public Integer update(NewsUser newsUser) {
//        int i = 0;
//        try {
//            String sql = "update news_user set userName=? where id=?";
//            connection = JDBCDruid.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "1111");
//            preparedStatement.setInt(2, 293);
//            i = preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            return i;
//        }
        return null;
    }

    @Override
    public Integer delete(NewsUser newsUser) {
//        int i = 0;
//        try {
//            String sql = "delete from news_user where userName=?";
//            connection = JDBCDruid.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "admin8888");
//            i = preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            return i;
//        }
        return null;
    }


    @Override
    public List<NewsUser> getByUser(NewsUser newsUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from news_user where userName= ?";

        List<NewsUser> newsUsers = null;
        try {
            connection = JDBCDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newsUser.getUserName());
            resultSet = preparedStatement.executeQuery();
            newsUsers = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer userType = resultSet.getInt("userType");
                newsUsers.add(new NewsUser(id, userName, password, email, userType));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCDruid.close(resultSet, preparedStatement, connection);
        }
        return newsUsers;
    }

    @Override
    public List<NewsUser> getByLimit(Integer pag, Integer views) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select * from news_user limit ?,?";
        List<NewsUser> newsUsers = null;
        try {
            connection = JDBCDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, (pag - 1) * views);
            preparedStatement.setObject(2, views);
            resultSet = preparedStatement.executeQuery();
            newsUsers = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer userType = resultSet.getInt("userType");
                newsUsers.add(new NewsUser(id, userName, password, email, userType));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCDruid.close(resultSet, preparedStatement, connection);
        }
        return newsUsers;
    }

    @Override
    public Integer getCount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) as count from news_user";
        int count = 0;
        try {
            connection = JDBCDruid.getConnection();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCDruid.close(resultSet, preparedStatement, connection);
        }
        return count;
    }
}

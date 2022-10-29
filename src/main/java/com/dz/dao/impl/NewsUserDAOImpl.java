package com.dz.dao.impl;

import com.dz.dao.NewsUserDAO;
import com.dz.entity.NewsUser;
import com.dz.utils.JDBCDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
//        int x = 0;
//        try {
//            String sql = "insert into news_user value (null ,?,?,?,?)";
//            connection = JDBCDruid.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
////            for (int i = 1; i < 21; i++) {
//            int a = (int) (Math.random() * 10 + 1);
//            int b = (int) (Math.random() * 10 + 1);
//            int c = (int) (Math.random() * 2);
//            preparedStatement.setString(1, "admin8888");
//            preparedStatement.setString(2, "333333");
//            preparedStatement.setString(3, "qimu@qq.com");
//            preparedStatement.setInt(4, 1);
//            x = preparedStatement.executeUpdate();
////            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            return x;
//        }
        return null;
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
}

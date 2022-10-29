import com.dz.utils.JDBCDruid;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class test {
    private static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    @Test
    public void a() {
        try {
            // (1)添加
            add();
            // (2)修改
            change();
            // (3)删除 username为李四的数据
            del();
            //查询
            select();
        } catch (
                Exception throwables) {
            throwables.printStackTrace();
        } finally {

            JDBCDruid.close(null, preparedStatement, connection);
        }
    }




    // 新增20条用户信息
    public static void add() throws Exception {
        String sql = "insert into news_user value (null ,?,?,?,?)";
        connection = JDBCDruid.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        int x = 0;
        for (int i = 1; i < 21; i++) {
            int a = (int) (Math.random() * 10 + 1);
            int b = (int) (Math.random() * 10 + 1);
            int c = (int) (Math.random() * 2);
            preparedStatement.setString(1, "admin" + i);
            preparedStatement.setString(2, a + "p" + b + b + i + a);
            preparedStatement.setString(3, a + "" + i + "" + b + "" + b + "" + i + "" + a + "@kgc.cn");
            preparedStatement.setString(4, c + "");
            x = preparedStatement.executeUpdate();
        }
        System.out.println(x > 0 ? "添加成功" : "添加失败");
    }

    //删：删除ID大于15的数据
    public static void del() throws Exception {
        String sql = "delete from news_user where id>? ";
        connection = JDBCDruid.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 15);
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "删除成功" : "删除失败");
    }

    //    将所有ID大于13的数据的password属性修改为 admin123
    public static void change() throws Exception {
        String sql = "update news_user set password=? where id>?";
        connection = JDBCDruid.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "admin123");
        preparedStatement.setInt(2, 13);
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "修改成功" : "修改失败");
    }

    //    实现根据用户名的前后模糊查询以及根据邮箱的后模糊查询
    public static void select() throws Exception {
        String sql = "select * from news_user where userName LIKE ? and email like ?;";
        connection = JDBCDruid.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "u%");
        preparedStatement.setString(2, "%@kgc.cn");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String userType = resultSet.getString("userType");
            System.out.println("ID :" + id + " " + "用户名：" + userName + " " + "密码：" + password + " " + "邮箱：" + email + " " + "用户类型：" + userType);
        }
    }
}

import com.dz.controller.PageLimit;
import com.dz.controller.UserController;
import com.dz.dao.impl.NewsUserDAOImpl;

import com.dz.entity.NewsUser;
import com.dz.service.NewsUserService;
import com.dz.service.impl.NewsUserServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestNewsUser {
    private PageLimit pageLimit =new PageLimit();

    @Test
    public void select() {
//        List<NewsUser> select = new NewsUserDAOImpl().select(null);
//        for (NewsUser newsUser : select) {
//            System.out.println(newsUser);
//        }
        NewsUserService newsUserService = new NewsUserServiceImpl();
        List<NewsUser> select = newsUserService.select(null);
        for (NewsUser newsUser : select) {
            System.out.println(newsUser);
        }
    }

    @Test
    public void insert() {
        Integer insert = new NewsUserDAOImpl().insert(null);
        System.out.println(insert > 0 ? "添加成功" : "添加失败");
    }

    @Test
    public void update() {
        Integer update = new NewsUserDAOImpl().update(null);
        System.out.println(update > 0 ? "修改成功" : "修改失败");
    }

    @Test
    public void delete() {
        Integer delete = new NewsUserDAOImpl().delete(null);
        System.out.println(delete > 0 ? "删除成功" : "删除失败");
    }

    @Test
    public void limit() {
        List<NewsUser> byLimit = pageLimit.getByLimit(0, 3);
        byLimit.forEach(System.out::println);
    }
}

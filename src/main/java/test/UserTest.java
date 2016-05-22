package test;

import dao.UserDao;
import dao.UserDaoHibImpl;
import dao.UserInfoDao;
import dao.UserInfoDaoHibImpl;
import domain.User.User;
import domain.User.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;
import service.UserServiceImpl;

import java.util.Date;

/**
 * Created by cqx on 16/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:src/applicationContext.xml"})
public class UserTest {

    @Before
    public void setUp() throws Exception
    {
//    	userService = new UserServiceImpl();

    }


	 @Test
	 public void testFindAll() {


		 UserService userService = new UserServiceImpl();
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 UserDao userDao = new UserDaoHibImpl();
		 User user = new User();
		 user.setPassword("123");
		 user.setUsername("admin01");
		 userService.generateToken(user);
		 UserInfo userInfo = new UserInfo();
		 userInfo.setAcademy("rg");
		 userInfo.setAge(22);
		 userInfo.setEnrolmentDate(new Date(2013, 9, 1));
		 userInfo.setInfoVisible(true);
		 userInfo.setLabel("llllll哈");

		 user.setUserInfo(userInfo);
//        userService.createUser(user);
//        userDao.save(user);
		 UserInfoDao userInfoDao = new UserInfoDaoHibImpl();
		 userInfoDao.save(userInfo);
		 userService.createUser(user);
		 System.out.println("done!");
	    }


}

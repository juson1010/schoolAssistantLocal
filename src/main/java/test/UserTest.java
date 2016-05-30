package test;

import dao.UserDao;
import dao.UserInfoDao;
import domain.User.User;
import domain.User.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;
import java.util.Date;

/**
 * Created by cqx on 16/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/java/applicationContext.xml")
public class UserTest {


	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserInfoDao userInfoDao;


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Before
    public void setUp() throws Exception
    {

	}


	 @Test
	 public void testFindAll() {


		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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
//		 userInfoDao.save(userInfo);
		 userService.createUser(user);
		 System.out.println("done!");
	    }




}

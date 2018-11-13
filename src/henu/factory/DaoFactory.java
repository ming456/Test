package henu.factory;

import henu.dao.IUserDao;
import henu.dao.impl.UserDaoImpl;

public class DaoFactory {
	public static IUserDao getUserDaoInstance() {
		return new UserDaoImpl();
	}

}

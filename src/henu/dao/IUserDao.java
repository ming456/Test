package henu.dao;

import henu.bean.User;

import java.util.List;

public interface IUserDao {
	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 若登录成功返回true，否则false
	 */
	public boolean login(String username, String password);

	/**
	 * 保存用户
	 * 
	 * @param user
	 *            用户名
	 * @return 受影响的记录个数
	 */
	public int save(User user);

	/**
	 * 根据用户名删除
	 * 
	 * @param username
	 *            用户名
	 * @return 受影响的记录个数
	 */
	public int delete(String username);

	/**
	 * 根据用户名修改用户信息
	 * 
	 * @param username
	 *            用户名
	 * @param user
	 *            新的用户信息
	 * @return 受影响的记录个数
	 */
	public int update(String username, User user);

	/**
	 * 查找所有用户信息
	 * 
	 * @return List类型的用户信息
	 */
	public List<User> findAll();

	/**
	 * 根据用户名查找单个用户
	 * 
	 * @param username
	 *            用户名
	 * @return User 对象
	 */
	public User findByUsername(String name);
}

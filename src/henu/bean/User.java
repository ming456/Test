package henu.bean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import henu.utils.DbcpPool;

public class User {
	/**
	 * 依据数据表结构，声明成员变量
	 */
	private String fd_username;
	private String fd_password;
	private String fd_usertype;
	private String fd_gender;
	private String fd_hobby;
	private String fd_birthdate;
	private String fd_email;
	private String fd_introduction;

	/**
	 * 无参构造方法
	 */
	public User() {
	}

	/**
	 * 为属性提供setter和getter方法，public类型
	 */
	public String getFd_username() {
		return fd_username;
	}

	public void setFd_username(String fd_username) {
		this.fd_username = fd_username;
	}

	public String getFd_password() {
		return fd_password;
	}

	public void setFd_password(String fd_password) {
		this.fd_password = fd_password;
	}

	public String getFd_usertype() {
		return fd_usertype;
	}

	public void setFd_usertype(String fd_usertype) {
		this.fd_usertype = fd_usertype;
	}

	public String getFd_gender() {
		return fd_gender;
	}

	public void setFd_gender(String fd_gender) {
		this.fd_gender = fd_gender;
	}

	public String getFd_hobby() {
		return fd_hobby;
	}

	public void setFd_hobby(String fd_hobby) {
		this.fd_hobby = fd_hobby;
	}

	public String getFd_birthdate() {
		return fd_birthdate;
	}

	public void setFd_birthdate(String fd_birthdate) {
		this.fd_birthdate = fd_birthdate;
	}

	public String getFd_email() {
		return fd_email;
	}

	public void setFd_email(String fd_email) {
		this.fd_email = fd_email;
	}

	public String getFd_introduction() {
		return fd_introduction;
	}

	public void setFd_introduction(String fd_introduction) {
		this.fd_introduction = fd_introduction;
	}

	/**
	 * 用户注册功能
	 * 
	 * @param user
	 * @return 注册成功返回true，否则返回false
	 */
	public boolean regist(User user) {
		String sql = "INSERT INTO tb_users(fd_username,fd_password,fd_gender,fd_usertype"
				+ ",fd_email,fd_birthdate,fd_hobby,fd_introduction) VALUES (?,?,?,?,?,?,?,?)";
		int result = 0;
		// 调用henu.util.DbUtil工具类的方法创建PreparedStatement对象
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		try {
			ps.setString(1, user.getFd_username());
			ps.setString(2, user.getFd_password());
			ps.setString(3, user.getFd_gender());
			ps.setString(4, user.getFd_usertype());
			ps.setString(5, user.getFd_email());
			ps.setString(6, user.getFd_birthdate());
			ps.setString(7, user.getFd_hobby());
			ps.setString(8, user.getFd_introduction());
			result = ps.executeUpdate();
			DbcpPool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0)
			return true;
		else
			return false;
	}
	public String toString() {
		return "User [fd_username=" + fd_username + ", fd_password=" + fd_password + ", fd_usertype=" + fd_usertype
				+ ", fd_gender=" + fd_gender + ", fd_hobby=" + fd_hobby + ", fd_birthdate=" + fd_birthdate
				+ ", fd_email=" + fd_email + ", fd_introduction=" + fd_introduction + "]";
	}
	

}

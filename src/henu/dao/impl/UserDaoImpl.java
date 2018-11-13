package henu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import henu.bean.User;
import henu.dao.IUserDao;
import henu.utils.DbcpPool;

public class UserDaoImpl implements IUserDao{

	@Override
	public int save(User user) {
		String sql = "INSERT INTO tb_users (fd_username,fd_password,"
				+ "fd_gender,fd_birthdate"
				+ ",fd_email,fd_hobby,fd_introduction,fd_usertype) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, user.getFd_username());
			ps.setString(2, user.getFd_password());
			ps.setString(3, user.getFd_gender());
			ps.setString(4, user.getFd_birthdate());
			ps.setString(5, user.getFd_email());
			ps.setString(6, user.getFd_hobby());
			ps.setString(7, user.getFd_introduction());
			ps.setString(8, user.getFd_usertype());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public int delete(String username) {
		String sql = "DELETE FROM tb_users WHERE fd_username = '" + username + "'";
		int result = 0;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String username, User user) {
		String sql = "UPDATE tb_users SET fd_password=?, fd_gender=?,"
				+ "fd_birthdate=?,fd_usertype=?,fd_email=?,fd_hobby=?,"
				+ "fd_introduction=? WHERE fd_username=?";
		
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			
			ps.setString(1, user.getFd_password());
			ps.setString(2, user.getFd_gender());
			ps.setString(3, user.getFd_birthdate());
			ps.setString(5, user.getFd_email());
			ps.setString(6, user.getFd_hobby());
			ps.setString(7, user.getFd_introduction());
			ps.setString(4, user.getFd_usertype());
			ps.setString(8, username);
			result = ps.executeUpdate();
			//System.out.println("result:" + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT * FROM tb_users WHERE fd_username ='" + username + "'";
		User user = new User();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if(rs.next())
			{
				user.setFd_birthdate(rs.getString("fd_birthdate"));
				user.setFd_email(rs.getString("fd_email"));
				user.setFd_gender(rs.getString("fd_gender"));
				user.setFd_hobby(rs.getString("fd_hobby"));
				user.setFd_introduction(rs.getString("fd_introduction"));
				user.setFd_password(rs.getString("fd_password"));
				user.setFd_username(rs.getString("fd_username"));
				user.setFd_usertype(rs.getString("fd_usertype"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return user;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM tb_users ORDER BY fd_username ";
		List<User> list = new ArrayList<User>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while(rs.next())
			{
				User user = new User();
				user.setFd_birthdate(rs.getString("fd_birthdate"));
				user.setFd_email(rs.getString("fd_email"));
				user.setFd_gender(rs.getString("fd_gender"));
				user.setFd_hobby(rs.getString("fd_hobby"));
				user.setFd_introduction(rs.getString("fd_introduction"));
				user.setFd_password(rs.getString("fd_password"));
				user.setFd_username(rs.getString("fd_username"));
				user.setFd_usertype(rs.getString("fd_usertype"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public boolean login(String username, String password) {
		String sql = "SELECT count(*) AS NUM FROM tb_users WHERE fd_username='" 
				+ username + "' AND fd_password = '" + password + "'";
		ResultSet rs = DbcpPool.executeQuery(sql);
		int result = 0;
		try {
			if(rs.next())
			{
				result = rs.getInt("NUM");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		if(result > 0)
			return true;
		else
			return false;
	}

}

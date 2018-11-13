package henu.servlet;

import henu.bean.User;
import henu.dao.IUserDao;
import henu.factory.DaoFactory;
import henu.utils.DbcpPool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class U
 */
@WebServlet("/U")
public class U extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public U() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action(request, response);
	}

	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("stype");

		if ("login".equals(action)) {
			login(request, response);
		} else if ("add".equals(action)) {
			add(request, response);
		}
		else if ("delete".equals(action)) {
			delete(request, response);
		}
		else if ("update".equals(action)) {
			update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			User user = new User();
			String username = request.getParameter("username");
			user.setFd_birthdate(request.getParameter("birthdate"));
			user.setFd_email(request.getParameter("email"));
			
			user.setFd_introduction(request.getParameter("introduction"));
			user.setFd_password(request.getParameter("password"));
			user.setFd_gender(request.getParameter("gender"));
			String[] h = request.getParameterValues("hobby");
			String hobby = "";
			for(String s:h)
			{
				hobby = hobby + " " + s;
			}
			user.setFd_hobby(hobby);
			user.setFd_usertype(request.getParameter("usertype"));
			
			IUserDao userDao = DaoFactory.getUserDaoInstance();
			if(userDao.update(username, user)>0){
				HttpSession session = request.getSession();
				String sql = "SELECT * FROM tb_users";
				//将查询结果存入session名为search的属性中
				session.setAttribute("search", DbcpPool.sqlsb(sql));
				
				try {
					response.sendRedirect("user/userAdmin.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					response.sendRedirect("error.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		int result=DaoFactory.getUserDaoInstance().delete(username);
//		System.out.println(result);
		if(result>0){
			HttpSession session = request.getSession();
			String sqlSearch = "SELECT * FROM tb_users";
			StringBuffer sb=DbcpPool.sqlsb(sqlSearch);
			//将查询结果存入session名为search的属性中
			session.setAttribute("search",sb);
			try {
				response.sendRedirect("user/userAdmin.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else{
				try {
					response.sendRedirect("error.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String birthdate = request.getParameter("birthdate");
		String introduction = request.getParameter("introduction");
		System.out.println(username);
		user.setFd_birthdate(request.getParameter("birthdate"));
		user.setFd_email(request.getParameter("email"));
		user.setFd_gender(request.getParameter("gender"));
		String[] h = request.getParameterValues("hobby");
		String hobby = "";
		for (String s : h) {
			hobby = hobby + " " + s;
		}
		user.setFd_hobby(hobby);
		user.setFd_introduction(request.getParameter("introduction"));
		user.setFd_password(request.getParameter("password"));
		user.setFd_username(request.getParameter("username"));
		user.setFd_usertype(request.getParameter("usertype"));
		String sql = "INSERT INTO tb_users(fd_username,fd_password,fd_usertype,fd_gender,fd_email,fd_birthdate,fd_introduction,fd_hobby)VALUES(?,?,?,?,?,?,?,?)";
		int result=DbcpPool.Result(sql,username,password,usertype,gender,email,birthdate,introduction,hobby);
		if(result>0){
			HttpSession session = request.getSession();
			String sqlSearch = "SELECT * FROM tb_users";
			StringBuffer sb=DbcpPool.sqlsb(sqlSearch);
			//将查询结果存入session名为search的属性中
			session.setAttribute("search",sb);
			try {
				response.sendRedirect("user/userAdmin.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else{
				try {
					response.sendRedirect("error.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if ("admin".equals(request.getParameter("username"))
				&& "pwd".equals(request.getParameter("password"))) {
			try {
				response.sendRedirect("index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

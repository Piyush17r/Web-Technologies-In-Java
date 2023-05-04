package controller;

import java.io.IOException;
import java.util.Random;

import javax.mail.Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.UserDao;
import Model.User;
import service.services;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("action");
		
		
		if (action.equalsIgnoreCase("Register")) {
			User u = new User();
			u.setFirst_name(request.getParameter("first_name"));
			u.setLast_name(request.getParameter("last_name"));
			u.setMobile(Long.parseLong(request.getParameter("mobile")));
			u.setGender(request.getParameter("gender"));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			
			UserDao.signup(u);
			request.setAttribute("msg", "Account Registred Succesfully.");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} 
		else if (action.equalsIgnoreCase("login")) {
			User u = new User();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			User u1 = UserDao.login(u);
			if (u1 == null) {
			request.setAttribute("msg","Account Login Succesfully.");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "password is incorrect");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("change password")) {
			User u = new User();
			int id = Integer.parseInt(request.getParameter("id"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = UserDao.checkOldPassword(id,op);
			if(flag==true) {
				if(np.equals(cnp)) {
					UserDao.changePasswrod(id, np);
					response.sendRedirect("Home.jsp");
				}
				else {
					request.setAttribute("msg1", "old password and new password not matched");
					request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Old password incorrect");
				request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("GET OTP")) {
			String email = request.getParameter("email");
			boolean flag = UserDao.checkEmail(email);
			if (flag == true) {
				services s = new services();
				Random r = new Random();
				int num = r.nextInt(999999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("user-verify-otp.jsp").forward(request, response);
			} else {

			}
			
		}
			else if (action.equalsIgnoreCase("verify")) {
				String email = request.getParameter("email");
				int otp1 = Integer.parseInt(request.getParameter("otp1"));
				int otp2 = Integer.parseInt(request.getParameter("otp2"));
				if (otp1 == otp2) {
					request.setAttribute("email", email);
					request.getRequestDispatcher("user-new-password.jsp").forward(request, response);
				} else {
					request.setAttribute("email", email);
					request.setAttribute("otp", otp1);
					request.setAttribute("msg", "otp not matched");
					request.getRequestDispatcher("user-verify-otp.jsp").forward(request, response);
				}
			} else if (action.equalsIgnoreCase("Update Password")) {
				String email = request.getParameter("email");
				String np = request.getParameter("np");
				String cnp = request.getParameter("cnp");
				if (np.equals(cnp)) {
					UserDao.ChangeNewPasswrod(email, np);
					response.sendRedirect("login.jsp");
				} else {
					request.setAttribute("msg", "password not matched");
					request.setAttribute("email", email);
					request.getRequestDispatcher("user-verify-otp.jsp").forward(request, response);
				} 
			}else if (action.equalsIgnoreCase("Update Password")) {
					String email = request.getParameter("email");
					String np = request.getParameter("np");
					String cnp = request.getParameter("cnp");
					if (np.equals(cnp)) {
						UserDao.ChangeNewPasswrod(email, cnp);
						response.sendRedirect("login.jsp");
					} else {
						request.setAttribute("msg", "np and cnp not matched");
						request.setAttribute("email", email);
						request.getRequestDispatcher("user-verify-otp.jsp").forward(request, response);
			}
	}
}
}

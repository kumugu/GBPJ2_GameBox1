package com.gamebox.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamebox.dao.UsersDAO;
import com.gamebox.dto.UsersDTO;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO = new UsersDAO();


	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // UTF-8 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
		String action = request.getParameter("action");
		
		switch (action) {
		case "create":
			createUser (request, response);
			break;
		case "update":
			updateUser (request, response);
			break;
		case "delete":
			deleteUser (request, response);
		}
	}


	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // UTF-8 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
		String action = request.getParameter("action");
		
		if ("read".equals(action)) {
			readUser (request, response);
		}
	}


	// 회원 등록
	private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UsersDTO user = new UsersDTO();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setProfileImage(request.getParameter("profileImage"));
		
		boolean isCreated = usersDAO.insertUser(user);
		
		if (isCreated) {
			response.getWriter().println("회원 등록 성공!");
		} else {
			response.getWriter().println("회원 등록 실패");
		}
	}

	// 회원 조회
	private void readUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		UsersDTO user = usersDAO.getUserById(userId);
		
		if (user != null) {
			response.getWriter().println("회원 정보: " + user.getUsername() + ", " + user.getEmail());
		} else {
			response.getWriter().println("회원을 찾을 수 없습니다.");
		}
	}
	
	// 회원 수정
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UsersDTO user = new UsersDTO();
		
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setProfileImage(request.getParameter("profileImage"));
		
		boolean isUpdated = usersDAO.updateUser(user);
		
		if (isUpdated) {
			response.getWriter().println("회원 정보 수정 완료!");
		} else {
			response.getWriter().println("회원 정보 수정 실패");
		}
	}

	// 회원 삭제
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		boolean isDeleted = usersDAO.deleteUser(userId);
		
		if (isDeleted) {
			response.getWriter().println("회원 삭제 성공");
		} else {
			response.getWriter().println("회원 삭제 실패");
		}
	}

}

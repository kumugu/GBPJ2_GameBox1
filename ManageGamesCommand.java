package com.gamebox.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageGamesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   String alertMessage = (String) request.getSession().getAttribute("adminAlert");
        if (alertMessage != null) {
            System.out.println(alertMessage);
            request.setAttribute("adminAlert", alertMessage);
            request.getSession().removeAttribute("adminAlert");
        }
        return "/WEB-INF/views/admin/manage_games.jsp";
    }

}

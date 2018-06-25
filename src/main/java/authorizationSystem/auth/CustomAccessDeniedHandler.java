package authorizationSystem.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
			throws IOException, ServletException {
		response.sendRedirect("/accessdenied");
		
	}
	//
}

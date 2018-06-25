package authorizationSystem.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		boolean admin=false;
		for (GrantedAuthority auth : authentication.getAuthorities()) {
            if(auth.getAuthority().equals("ROLE_ADMIN"))
            	admin=true;
        }
		//there is possibility to do more tasks as check for USER
		if(admin) {
			response.sendRedirect("/admin");	
		}
		else
			response.sendRedirect("/getuser");
	}

}

package authorizationSystem.auth;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class MyController {
	
	
	User user;
	
	///////////////////////////////////////////////////////////////////////////
	@RequestMapping("/")
	public String main() throws IOException {
		return "mainpage";
	}
	////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/admin")
	public String adminPanel() throws IOException {
		return "admin";
	}
	////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/blog")
	public String blog() throws IOException {
		return "blog";
	}
	@RequestMapping(value="/login")
	public String login(Model model) throws IOException {		
		user=new User();
		model.addAttribute("user", user);
		return "/loginpage";
	}
	/////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/getuser")
	public String getuser() throws IOException {
		return "user";
	}
	////////////////////////////////////////////////////////////////
	@RequestMapping("/showerror")
	public String giveError() {
		return "/errorpage";
	}
	////////////////////////////////////////////////////////////////////
	@RequestMapping("/accessdenied")
	public String accessError() {
		return "/accessdenied";
	}
}
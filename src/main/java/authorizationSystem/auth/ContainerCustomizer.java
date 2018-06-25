package authorizationSystem.auth;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

public class ContainerCustomizer implements EmbeddedServletContainerCustomizer {
	
	@Bean
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// container.addErrorPages(new AccessDeniedPageException("message"), "/denied");
	 }


}
/*class AccessDeniedPageException extends Exception {
	public AccessDeniedPageException(String message) {
		super(message);
	}
	
}*/


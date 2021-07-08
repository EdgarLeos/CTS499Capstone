package e_shelf.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import e_shelf.domains.info.MyUserDetails;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		System.out.println("Username" + username);
		
		Collection<? extends GrantedAuthority> authorities = loggedInUser.getAuthorities();
		authorities.forEach(auth -> System.out.println(auth.getAuthority()));
		
		String redirectURL = request.getContextPath();
		System.out.println(redirectURL);
		
		if(authorities.toString().equals("[Admin]")) {;
			redirectURL += "/admin";
		}
		else if(authorities.toString().equals("[Teacher]")) {;
		redirectURL += "/teacher";
	}
		
		   response.sendRedirect(redirectURL);
	}

	
}

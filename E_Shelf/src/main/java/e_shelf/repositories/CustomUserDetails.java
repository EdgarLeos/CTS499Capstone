package e_shelf.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import e_shelf.domains.database.User;

public class CustomUserDetails implements UserDetails {
    private User user;
     
    public CustomUserDetails(User user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	String roles = user.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         

            authorities.add(new SimpleGrantedAuthority(roles));
 
        return authorities;
    }
 
     
    public boolean hasRole(String roleName) {
        return this.user.hasRole(roleName);
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}



     
    // other overriden methods are not shown
}
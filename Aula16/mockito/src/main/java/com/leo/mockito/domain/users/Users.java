package com.leo.mockito.domain.users;



import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	
	private String login;
	
	
	private String password;
	
	
	private UsersRole role;
	
	public Users(String login, String password, UsersRole role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}
	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UsersRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new  SimpleGrantedAuthority("ROLE+USERS"));
		else return List.of(new SimpleGrantedAuthority("Role_USERS"));
	}


	@Override
	public String getUsername() {
		// TODO Stub de método gerado automaticamente
		return login;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Stub de método gerado automaticamente
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Stub de método gerado automaticamente
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Stub de método gerado automaticamente
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Stub de método gerado automaticamente
		return true;
	}
	
	
	
	
	
}

package com.generation.blogpessoal.security;
//aqui é onde esta os direitos de acesso oque ele pode ou não pode fazer
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;

	//esse é o construtor que a gente usa no details service
	public UserDetailsImpl(Usuario usuario) {
		this.userName = usuario.getUsuario();
		this.password = usuario.getSenha();
	}

	public UserDetailsImpl() {
	}

	//vai pegar as altorizações , como não implementou autorização então ele pega tudo
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {

		return userName;
	}

	//a conta não espira
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//a conta não bloqueia
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

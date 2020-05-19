//package com.example.thread.entity;
//
//import java.util.Collection;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Table(name="user")
//@Entity
//public class AccountEntity implements UserDetails {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) 
//	private int id;
// 
//	private String username;
// 
//	private String password;
// 
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
// 
//	// ユーザ名を返却する
//	@Override
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	// クライアントから受け取ったパスワードと一致するか確認
//	@Override
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
// 
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return null;
//	}
//	@Override
//	public boolean isAccountNonExpired() {	
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//}
//

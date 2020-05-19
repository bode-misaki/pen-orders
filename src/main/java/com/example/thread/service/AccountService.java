//package com.example.thread.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import com.example.thread.entity.AccountEntity;
//import com.example.thread.repository.AccountRepository;
//
//@Service
//public class AccountService implements UserDetailsService {
//	@Autowired
//	private AccountRepository accountRepository;
//	@Autowired
//	PasswordEncoder passwordEncoder;	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// usernameが空か確認
//		if (StringUtils.isEmpty(username)) {
//			throw new UsernameNotFoundException("ユーザー名を入力してね");
//		}
// 
//		// usernameを元にDBからアカウント情報が取得できたら、アカウント情報を生成
//		AccountEntity account = accountRepository.findByUsername(username);
//		if (account == null) {
//			throw new UsernameNotFoundException("ユーザー名が違うよ");
//		}
//		
//		String hashedPass = passwordEncoder.encode(account.getPassword());	
//		System.out.println(hashedPass);	
//		return account;
//	}
//	
//}
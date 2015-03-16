package br.com.ifrn.workbook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.UserAccount;
import br.com.ifrn.workbook.repository.UserRepository;

@Service
public class UserService extends BaseService<UserAccount, Long> {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	
	@Inject
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super(userRepository);
		this.userRepository = userRepository;		
		this.passwordEncoder = passwordEncoder;
	}

	public UserAccount getByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}
	
	public UserAccount registerNewUserAccount(UserAccount user) {
		user.setPassword(encodePassword(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public List<UserAccount> getAll() {	
		return userRepository.findAll(new Sort("email"));
	}
	
	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}
	
}

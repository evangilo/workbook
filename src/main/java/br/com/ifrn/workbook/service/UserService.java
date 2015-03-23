package br.com.ifrn.workbook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.exceptions.EmailException;
import br.com.ifrn.workbook.exceptions.UsernameException;
import br.com.ifrn.workbook.model.user.UserAccount;
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

	public UserAccount getByEmail(String email) throws UsernameNotFoundException {
		UserAccount user = userRepository.findOneByEmail(email);
		if (user.isActive()) return user;
		throw new UsernameNotFoundException("usuário supenso :(");
	}
	
	public UserAccount registerNewUserAccount(UserAccount user) throws EmailException {
		validarUser(user);
		user.setPassword(encodePassword(user.getPassword()));
		return userRepository.save(user);
	}
	
	public void updatePassword(UserAccount user, String password) {
		user.setPassword(encodePassword(password));
		super.update(user);
	}	
	
	@Override
	public List<UserAccount> getAll() {	
		return userRepository.findAll(new Sort("email"));
	}
	
	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}
	

	private void validarUser(UserAccount user) throws EmailException {
		UserAccount account = userRepository.findOneByEmail(user.getEmail());
		if (account != null) throw new EmailException("Email inválido.");
	}
}

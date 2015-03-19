package br.com.ifrn.workbook.model.servico;

import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.exceptions.PasswordResetTokenException;
import br.com.ifrn.workbook.model.PasswordResetToken;
import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.repository.PasswordResetTokenRepository;
import br.com.ifrn.workbook.service.BaseService;
import br.com.ifrn.workbook.service.UserService;

@Service
public class PasswordResetTokenService extends BaseService<PasswordResetToken, Long> {
	
	private PasswordResetTokenRepository passwordRepository;
	private UserService userService;

	@Inject
	public PasswordResetTokenService(PasswordResetTokenRepository passwordRepository, UserService userService) {
		super(passwordRepository);
		this.passwordRepository = passwordRepository;
		this.userService = userService;
	}
	
	public PasswordResetToken createPasswordReset(UserAccount user) {
		PasswordResetToken reset = passwordRepository.findByUser(user);		
		String token = UUID.randomUUID().toString();			
		if (reset == null) {
			reset = new PasswordResetToken(token, user);
		} else {
			reset.setToken(token);
		}		
		return super.create(reset);
	}
	
	public void resetPassword(Long user, String newPassword, String token) throws PasswordResetTokenException {		
		PasswordResetToken reset = passwordRepository.findByToken(token);
		if (reset == null || validateToken(reset)) {
			throw new PasswordResetTokenException("token inválido!");
		}
		userService.updatePassword(reset.getUser(), newPassword);
		super.delete(reset.getId());
	}
	
	private boolean validateToken(PasswordResetToken reset) {
		Date now = new Date();
		return now.after(reset.getExpiryDate());
	}
	
	

}

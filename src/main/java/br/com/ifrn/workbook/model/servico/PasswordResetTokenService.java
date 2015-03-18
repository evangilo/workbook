package br.com.ifrn.workbook.model.servico;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.PasswordResetToken;
import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.repository.PasswordResetTokenRepository;
import br.com.ifrn.workbook.service.BaseService;

@Service
public class PasswordResetTokenService extends BaseService<PasswordResetToken, Long> {
	
	private PasswordResetTokenRepository passwordRepository;

	@Inject
	public PasswordResetTokenService(PasswordResetTokenRepository passwordRepository) {
		super(passwordRepository);
		this.passwordRepository = passwordRepository;
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

}

package br.com.ifrn.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrn.workbook.model.PasswordResetToken;
import br.com.ifrn.workbook.model.user.UserAccount;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
	
	PasswordResetToken findByUser(UserAccount user);

}

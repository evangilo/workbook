package br.com.ifrn.workbook.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifrn.workbook.model.user.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
	
	UserAccount findOneByEmail(String email);
	
	List<UserAccount> findByEmailIn(Collection<String> emails);

}

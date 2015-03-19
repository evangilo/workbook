package workbook;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import br.com.ifrn.workbook.Application;
import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class UsuarioReposioryTest {

	@Inject UserRepository userRosistory;
	
	@Test
	public void buscar_usuarios_por_uma_lista_de_emails() {
		Collection<String> emails = Arrays.asList("evangilo@gmail.com", "antonio@gmail.com");
		List<UserAccount> users = userRosistory.findByEmailIn(emails);
		Assert.notEmpty(users);
		Assert.isTrue(users.size() == 2, "2 usuários cadastrados");
		Assert.hasText("evangilo@gmail.com", users.get(0).getEmail());
	}

}

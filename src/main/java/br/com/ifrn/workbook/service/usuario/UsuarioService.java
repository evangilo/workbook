package br.com.ifrn.workbook.service.usuario;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.Usuario;
import br.com.ifrn.workbook.repository.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario, Long> {
	
	private UsuarioRepository usuarioRepository;
	
	
	@Inject
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super(usuarioRepository);
		this.usuarioRepository = usuarioRepository;		
	}

	public Usuario getByEmail(String email) {
		return usuarioRepository.findOneByEmail(email);
	}
	
	public Usuario registerNewUserAccount(Usuario usuario) {
		usuario.setPassword(encodePassword(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public List<Usuario> getAll() {	
		return usuarioRepository.findAll(new Sort("email"));
	}
	
	private String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
}

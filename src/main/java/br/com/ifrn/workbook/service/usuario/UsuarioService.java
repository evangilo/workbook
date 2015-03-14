package br.com.ifrn.workbook.service.usuario;

import javax.inject.Inject;

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
	
}

package br.com.ifrn.workbook.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.servico.Destaque;
import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.repository.DestaqueRepository;

@Service
public class DestaqueService extends BaseService<Destaque, Long> {
	
	private final DestaqueRepository destaqueRepository;
	private final ServicoService servicoService;
	
	@Inject
	public DestaqueService(DestaqueRepository destaqueRepository, ServicoService servicoService) {
		super(destaqueRepository);
		this.destaqueRepository = destaqueRepository;
		this.servicoService = servicoService;
	}
	
	public List<Destaque> getServicosEmDestaque(UserAccount user) {
		return destaqueRepository.findAllUserServicos(user.getId());
	}
	
	@Override
	public void delete(Long id) {
		Destaque destaque = getById(id);
		atualizarServico(destaque.getServico(), false);
		super.delete(id);
	}

	@Override
	public Destaque create(Destaque destaque) {
		destaque.setSituacao(Destaque.PENDENTE);
		destaque.setAtualizado(new Date());
		return super.create(destaque);
	}
	
	@Transactional
	public void aprovarDestaque(Long destaqueID) {
		atualizarDestaque(destaqueID, Destaque.APROVADO, true);
	}
	
	@Transactional
	public void cancelarDestaque(Long destaqueID) {
		atualizarDestaque(destaqueID, Destaque.CANCELADO, false);
	}
	
	private void atualizarDestaque(Long destaqueID, int situacao, boolean patrocinado) {
		Destaque destaque = getById(destaqueID);
		destaque.setAtualizado(new Date());
		destaque.setSituacao(situacao);				
		this.update(destaque);
		atualizarServico(destaque.getServico(), patrocinado);
	}
	
	private void atualizarServico(Servico servico, boolean patrocinado) {		
		servico.setPatrocinado(patrocinado);
		servicoService.update(servico);
	}

}

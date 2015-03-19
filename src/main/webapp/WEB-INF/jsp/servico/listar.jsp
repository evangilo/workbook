<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<layout:base>
	<aside id="main" class="col-md-12">
		<div class="row">
			<div class="col-sm-6">
				<h1>Meus Serviços</h1>
			</div>
			<div class="col-sm-6 text-right">
				<a class="btn btn-primary" href="criar">Cadastrar Serviço</a>
			</div>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${!empty servicos}">
					<c:forEach items="${servicos}" var="servico">
						<div class="col-sm-6 col-md-4 col-lg-3">
							<div class="thumbnail">
								<img src="http://placehold.it/350x120" alt="">
								<div class="caption">
									<h3>
										<a href="detalhar/${servico.id}">${servico.titulo}</a>
									</h3>
								</div>
								<div class="hidden-xs">
									<p class="text-list">${servico.descricao}</p>
								</div>
								<div class="pull-right">
									<a href="editar/${servico.id}"><i
										class="glyphicon glyphicon-edit"></i> Editar</a> <a
										href="deletar/${servico.id}"><i
										class="glyphicon glyphicon-trash"></i>Excluir</a>
								</div>
								<div class="ratings">
									<layout:stars value="${servico.media}" />
								</div>
								<div>
									<a href="/destaques/solicitar/${servico.id}">Colocar em detaque</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div>Não há itens para exibir</div>
				</c:otherwise>
			</c:choose>
		</div>
	</aside>
</layout:base>
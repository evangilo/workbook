<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<layout:base>
	<aside id="left" class="col-sm-3">
		<div class="list-group">
			<div class="list-group-item"><b>Categorias</b></div>
			<c:url value="/servico/buscar" var="buscarUrl">
  				<c:param name="s" value="${param.s}" />
			</c:url>
			<a class="list-group-item <c:if test="${empty param.c}">active</c:if>" href="${buscarUrl}">Todas as categorias</a>
			<c:forEach items="${categorias}" var="categoria">
			<c:url value="/servico/buscarPorCategoria" var="buscarUrl">
  				<c:param name="s" value="${param.s}" />
  				<c:param name="c" value="${categoria.id}" />
			</c:url>
			<a class="list-group-item <c:if test="${categoria.id == param.c}">active</c:if>" href="${buscarUrl}">${categoria.nome}</a>
			</c:forEach>
			<div>
				Filtrar por avaliação: <input type="number" id="star-rating" class=" pull-left rating caption" data-size="xs" value="0" data-show-clear="false" data-show-caption="false">
			</div>
		</div>
	</aside>
	<aside id="main" class="col-md-9">
		<div class="row">
			<div class="col-sm-3">
				<h1>Meus Serviços</h1>
			</div>
			
			<div class="col-sm-9 text-right">
				<div class="col-sm-3 pull-right">
					<a class="btn btn-primary" href="criar">Cadastrar Serviço</a>
				</div>
				
				
			</div>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${!empty servicos}">
					<c:forEach items="${servicos}" var="servico">
						<div class="col-sm-12 col-md-4 col-lg-4">
							<div class="thumbnail">
								<img src="<c:url value='/servico/image/${servico.id}' />" alt="Image" width="350" height="120" />
								<!-- <img src="http://placehold.it/350x120" alt="">-->
								<div class="caption">
									<h4>
										<a href="detalhar/${servico.id}">${servico.titulo}</a>
									</h4>
								<div id="servicoList">
									<p class="text-list">${servico.descricao}</p>
								</div>
								</div>
								<div class="pull-right caption">
									<a href="editar/${servico.id}"><i
										class="glyphicon glyphicon-edit"></i> Editar</a> <a
										href="deletar/${servico.id}"><i
										class="glyphicon glyphicon-trash"></i>Excluir</a>
								</div>

								<div class="ratings caption">
									<input type="number" id="star-rating" class=" pull-left rating caption" data-readonly="true" data-size="xs" value="${servico.media }" data-show-clear="false" data-show-caption="false">
								</div>
								<div class="caption">
									<a class='btn btn-default btn-block' href="/destaques/solicitar/${servico.id}">DESTACAR</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="well text-center">Não há serviços à serem exibidos</div>
				</c:otherwise>
			</c:choose>
		</div>
	</aside>
</layout:base>
<script type="text/javascript">
$(function($){
	$("#star-rating").on('rating.change', function(event, value, caption) {
		window.location.href= '<c:url value="/servico/listarPorAvaliacao"><c:param name="s" value="${param.s}" /><c:param name="c" value="${categoria.id}" /></c:url>&avaliacao'+value;
	});
});
</script>

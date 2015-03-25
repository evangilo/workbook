$('.dropdown-toggle').dropdown()
$("#pesquisaAvaliacao").click(function(){
	location.href= "/servico/listarPorAvaliacao/"+ Math.round($("this").val());
});


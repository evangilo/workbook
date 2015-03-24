$('.dropdown-toggle').dropdown()
$("#pesquisaAvaliacao").click(function(){
	location.href= "/servico/listarPorAvaliacao/"+$("this").val();
});


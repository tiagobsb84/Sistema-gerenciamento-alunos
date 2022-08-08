//Funcao para gera numero de matricula.
function gerarMatricula(){
	var texto = "ACB";
	var aleatorio = Math.floor(Math.random() * 150000);
	document.getElementById("inputMatricula").value = (texto  + aleatorio);
}
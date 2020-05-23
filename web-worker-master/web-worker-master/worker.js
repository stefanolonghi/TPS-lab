this.onmessage = e =>{
	const start = performance.now();
	var sec = e.data;

	while (performance.now() - start < 1000);//attendo 1 sec
	sec++;
	this.postMessage(sec); //passo il numero di secondi passati incrementato, che verrà stampatos
}
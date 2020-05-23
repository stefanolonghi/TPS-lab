this.onmessage = e =>{
	const number = e.data;
	var somma = 0;

	const start = performance.now();
	while (performance.now() - start < 5000); //simulo un'attività che richieda almeno 10 secondi di calcolo

	//Sommo i primi N numeri naturali
	for(i=0;i<number;i++){
		somma+=i;
	}

	this.postMessage(somma);
}
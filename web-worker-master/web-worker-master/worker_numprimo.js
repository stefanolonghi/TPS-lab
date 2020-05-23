this.onmessage = e =>{
	const number = e.data;
	
	const start = performance.now();
	while (performance.now() - start < 10000);//simulo un'attività che richieda almeno 10 secondi di calcolo

	var isPrimo = 'true'; //va a false se scopro che non è primo nei controlli
	var divisore = 2;

	while(divisore<number){
		if(number%divisore == 0){
			isPrimo = 'false';
		}
		
		divisore++;
	}

	this.postMessage(isPrimo);
}
  
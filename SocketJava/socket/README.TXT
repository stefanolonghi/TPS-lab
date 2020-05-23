Quando un client si connette a un server usa un numero di porta RANDOM per sè stesso.
Per evitare che un server non sia disponibile a nessun altro quando sta comunicando
con un client si usa il MULTITHREADING.
Se io passo clientsocket a un thread, esso ha tutte le info per comunicare con
un mittente. 
La versione multithread del server estende la classe thread.

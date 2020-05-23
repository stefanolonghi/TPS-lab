<?php
//array che contiene i nomi
$a = array("Anna","Brigitta","Claudio","Carmela","Evelina","Franco","Giovanna","Luca","Matteo","Gabriele","Marta","Martina","Manuela","Michela","Monica","Nanni","Pamela","Paolo","Paola","Pietro","Vincenzo","Alessandro","Riccardo","Chiara","Eva","Marina","Maddalena","Marco","Michelle","Antonio","Giuseppe","Lisa","Elisabetta","Giuliana","Arnoldo","Uberto","Umberto");
// salvo campo GET letto dalla pagina precedente
$q = $_GET["stringa"];
$response = "";
// verifica se campo esiste
if (strlen($q) > 0){
  $risposta = "";
  // ciclo di ricerca nell'array
  for($i = 0; $i < count($a); $i++){
    // controllo se nome trasformato in minuscolo è stato trovato
    if (strtolower($q) == strtolower(substr($a[$i], 0, strlen($q)))){
      // viene aggiunto il nome alla stringa separandolo dal tag di invio a capo
      $risposta .= $a[$i] . "<BR>";
    }
  }
}
// verifico se $risposta è vuota restituisco stringa "Nessun nome trovato"
if ($risposta == ""){
  $response = "Nessun nome trovato";
}
else{                       //assegnazione stringa di risposta
  $response = $risposta;
}
// invio risposta alla pagina chiamante
echo $response;
?>


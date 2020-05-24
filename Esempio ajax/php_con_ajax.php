<?php
//carico il contenuto del file in una stringa
$myfile = fopen("lista.txt", "r") or die("Unable to open file!");
$stringa = fread($myfile,filesize("lista.txt"));
fclose($myfile);

// salvo campo GET letto dalla pagina precedente
$q = $_GET["stringa"];
$response = "";

// verifica se campo esiste
if (strlen($q) > 0){
  $q.="<br>"; //concateno un br al nome per avere l'invio a capo nella pagina web
  $stringa.=$q; //concateno il nuovo nome alla stringa dei nomi presi dal file

  $myfile = fopen("lista.txt", "w") or die("Unable to open file!");
  fwrite($myfile, $stringa);
  fclose($myfile);
}

// invio risposta alla pagina chiamante
echo $stringa;
?>


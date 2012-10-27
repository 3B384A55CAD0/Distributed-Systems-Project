* Partita n. fisso di giocatori (può diminuire)
* Uno solo è il Wumpus
* Vince chi rimane vivo da solo

Ci sono tante room:
* Gestione room centralizzata (server web o server Java)
* Un giocatore crea una room e stabilisce n. min e max di giocatori.
  A quel punto parte un timeout di x secondi. Se si raggiunge il max prima
  dello scadere del timeout, la partita comincia subito. Se allo scadere
  del timeout si è raggiunto il min, la partita comincia. Altrimenti la 
  partita viene annullata, oppure viene chiesto al creatore se vuole
  fare ripartire il timeout.

Giocatore:
* campo visivo (dist. Manhattan)
* max distanza movimenti (dist. Manhattan)
* vita
* armi (lista o array)

Arma:
* danni
* Ogni classe non astratta poi aggiunge le sue caratteristiche peculiari,
  esempio distanza di lancio per la lancia (o dipende dalla forza del pers.?)

Messaggio di "Mossa" inviato da ogni client giocatore:
* posizione finale
* posizione attacco (caso Wumpus: non viene usato)
* arma usata (caso Wumpus: non viene usato)
NOTA: si assume che siano dati "corretti", ovvero non ci siano giochi crakkati.

INIZIO DI UNA PARTITA (dato da server centrale):
* Il server centrale avverte gli N processi in gioco che devono iniziare 
  e anche chi sono gli altri N-1.

Processo i-esimo:
* Elezione leader.
* Il leader sceglie per ogni giocatore il suo personaggio, in maniera randomica,
  assegnando il Wumpus ad uno solo di essi.
  Inoltre, sceglie le posizioni di partenza di tutti i giocatori, in maniera
  "oculata".
  Comunica tutto a tutti (anche a se stesso per comodità di programmazione).
  Aspetta ack.
* A questo punto tutti cominciano a giocare.

Gestione turni
=====================

Versione 1
---------------------
Il leader fa da organizzatore centrale.
* Leader dice "inizio turno" a tutti, e attende risposta da tutti. Attende
  un tempo pari a "tempo turno" + "tempo max ritardi ammessi". Un timeout
  diverso per giocatore o un timeout per tutti, a partire dall'ultimo giocatore
  considerato?
* Il processo che riceve "inizio turno":
  * Fa partire conto alla rovescia locale: se scade senza che l'utente abbia
    mosso, prepara "Mossa" contenente stessa posizione di prima e nessun attacco
    e nessuna arma. Altrimenti, prepara "Mossa" con la scelta fatta dall'utente.
  * Invia "Mossa" al leader.

Versione 2
---------------------
* Tutti preparano la mossa in locale. Tutti inviano la mossa a tutti.
* Tutti ricevono la mossa da tutti.
* Tutti sanno se ci sono stati conflitti in qualche casella. Solo il 
  leader li risolve e li comunica a tutti (che erano già in attesa perché 
  sapevano).














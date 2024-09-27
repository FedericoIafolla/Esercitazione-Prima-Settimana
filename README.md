# Lettore Multimediale

## Descrizione del Progetto

Il progetto **Lettore Multimediale** è un'applicazione Java progettata per gestire e riprodurre diversi tipi di contenuti multimediali, inclusi immagini, audio e video. Grazie all'implementazione della Programmazione Orientata agli Oggetti (OOP), il progetto è organizzato in classi modulari e facilmente estensibili, offrendo un'interfaccia interattiva per gli utenti.

## Caratteristiche Principali

- **Gestione dei Contenuti Multimediali**: Gli utenti possono aggiungere, riprodurre e modificare elementi multimediali, garantendo un'interazione semplice e intuitiva.
- **Tipi di Contenuti**:
  - **Immagini**: Possibilità di modificare il titolo e la luminosità.
  - **Audio**: Possibilità di modificare il titolo e il volume.
  - **Video**: Possibilità di modificare il titolo, il volume e la luminosità.
- **Interfaccia Utente Intuitiva**: Gli utenti possono navigare tra le varie opzioni tramite un menu interattivo.
- **Validazione Input**: L'applicazione gestisce input non validi, richiedendo nuovamente all'utente di inserire informazioni corrette.
- **Feedback Dinamico**: Gli utenti ricevono feedback immediato sulle modifiche apportate agli elementi multimediali.

## Funzionalità

### Menu Principale

L'interfaccia principale del lettore multimediale offre le seguenti opzioni:

1. **Riproduci Elemento**: Visualizza un elenco di elementi multimediali disponibili. L'utente può selezionare un elemento da riprodurre.
2. **Modifica Elemento**: Permette all'utente di selezionare un elemento e modificarne le impostazioni, come titolo, volume o luminosità.
3. **Esci**: Consente all'utente di uscire dall'applicazione dopo una conferma.

### Sezione di Riproduzione

Dopo aver selezionato l'opzione "Riproduci Elemento", l'utente può vedere l'elenco di elementi e scegliere quale riprodurre. Selezionando un elemento, l'applicazione avvierà la riproduzione del contenuto.

### Sezione di Modifica

Nella sezione "Modifica Elemento", l'utente può selezionare un elemento e scegliere quale aspetto modificare. A seconda del tipo di elemento (Immagine, Audio, Video), l'applicazione mostrerà le impostazioni correnti e offrirà opzioni per modificarle.

- **Immagini**:
  - Visualizza titolo e luminosità attuale.
  - Permette di modificare il titolo o la luminosità.

- **Audio**:
  - Visualizza titolo e volume attuale.
  - Permette di modificare il titolo o il volume.

- **Video**:
  - Visualizza titolo, volume e luminosità attuale.
  - Permette di modificare il titolo, il volume o la luminosità.

### Gestione dell'Uscita

Quando l'utente sceglie di uscire, il programma richiede una conferma. Se l'input non è valido (diverso da 'y' o 'n'), il programma ripropone la domanda fino a quando non viene ricevuta una risposta valida.

## Tecnologie Utilizzate

- **Java**: Linguaggio di programmazione principale utilizzato per lo sviluppo dell'applicazione.
- **Programmazione Orientata agli Oggetti (OOP)**: Approccio utilizzato per strutturare il codice e gestire i vari tipi di contenuti multimediali.

## Istruzioni per l'Installazione

1. Clona il repository:
   ```bash
   git clone https://github.com/tuo-username/lettore-multimediale.git

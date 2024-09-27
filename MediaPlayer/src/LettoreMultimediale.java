import java.util.Scanner;

public class LettoreMultimediale {
    private ElementoMultimediale[] elementi = new ElementoMultimediale[5];
    private Scanner scanner = new Scanner(System.in);

    public LettoreMultimediale() {
        for (int i = 0; i < elementi.length; i++) {
            System.out.print("Inserisci il " + (i + 1) + "° titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("Selezionare la tipologia (1: immagine, 2: Audio, 3: Video): ");
            int tipo = scanner.nextInt();
            if (tipo == 1) {
                System.out.print("Inserisci luminosità (0-100): ");
                int luminosità = scanner.nextInt();
                elementi[i] = new Immagine(titolo, luminosità);
            } else if (tipo == 2) {
                System.out.print("Inserisci durata (in secondi): ");
                int durata = scanner.nextInt();
                System.out.print("Inserisci volume (0-100): ");
                int volume = scanner.nextInt();
                elementi[i] = new Audio(titolo, durata, volume);
            } else if (tipo == 3) {
                System.out.print("Inserisci durata (in secondi): ");
                int durata = scanner.nextInt();
                System.out.print("Inserisci volume (0-100): ");
                int volume = scanner.nextInt();
                System.out.print("Inserisci luminosità (0-100): ");
                int luminosità = scanner.nextInt();
                elementi[i] = new Video(titolo, durata, volume, luminosità);
            }
            scanner.nextLine();  // Consuma la nuova riga
        }
    }

    public void esegui() {
        boolean running = true;

        while (running) {
            mostraMenu();
            int scelta = scanner.nextInt();

            if (scelta == 1) {
                mostraElementi();
                System.out.print("Seleziona l'elemento da riprodurre (1-5) o digita 0 per tornare al menu: ");
                int indice = scanner.nextInt() - 1;
                if (indice == -1) {
                    continue; // Torna al menu principale
                } else if (indice >= 0 && indice < elementi.length && elementi[indice] != null) {
                    elementi[indice].play();
                } else {
                    System.out.println("Elemento non valido.");
                }
            } else if (scelta == 2) {
                mostraElementi();
                System.out.print("Seleziona l'elemento da modificare (1-5) o digita 0 per tornare al menu: ");
                int indice = scanner.nextInt() - 1;
                if (indice == -1) {
                    continue; // Torna al menu principale
                } else if (indice >= 0 && indice < elementi.length && elementi[indice] != null) {
                    modificaImpostazioni(elementi[indice]);
                } else {
                    System.out.println("Elemento non valido.");
                }
            } else if (scelta == 0) {
                boolean confermaUscita = false;
                while (!confermaUscita) {
                    System.out.print("Sei sicuro di voler uscire? (y/n): ");
                    char conferma = scanner.next().charAt(0);
                    if (conferma == 'y' || conferma == 'Y') {
                        System.out.println("Grazie per aver usato il nostro MediaPlayer!");
                        running = false;
                        confermaUscita = true;
                    } else if (conferma == 'n' || conferma == 'N') {
                        confermaUscita = true; // Torna al menu principale
                    } else {
                        System.out.println("Input non valido. Riprova.");
                    }
                }
            } else {
                System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private void mostraMenu() {
        System.out.println("\n--- Menu Lettore Multimediale ---");
        System.out.println("1. Riproduci elemento");
        System.out.println("2. Modifica elemento");
        System.out.println("0. Esci");
    }

    private void mostraElementi() {
        System.out.println("Elementi disponibili:");
        for (int i = 0; i < elementi.length; i++) {
            if (elementi[i] != null) {
                System.out.println((i + 1) + ". " + elementi[i].getTitolo());
            }
        }
    }

    private void modificaImpostazioni(ElementoMultimediale elemento) {
        boolean modificheAttive = true;

        while (modificheAttive) {
            System.out.println("Modifica impostazioni per: " + elemento.getTitolo());
            if (elemento instanceof Immagine) {
                System.out.println("Titolo: " + elemento.getTitolo());
                System.out.println("Luminosità attuale: " + ((Immagine) elemento).getLuminosità());
                System.out.println("1. Modifica Titolo");
                System.out.println("2. Modifica Luminosità");
                System.out.println("0. Torna indietro");
            } else if (elemento instanceof Audio) {
                System.out.println("Titolo: " + elemento.getTitolo());
                System.out.println("Volume attuale: " + ((Audio) elemento).getVolume());
                System.out.println("1. Modifica Titolo");
                System.out.println("2. Modifica Volume");
                System.out.println("0. Torna indietro");
            } else if (elemento instanceof Video) {
                System.out.println("Titolo: " + elemento.getTitolo());
                System.out.println("Volume attuale: " + ((Video) elemento).getVolume());
                System.out.println("Luminosità attuale: " + ((Video) elemento).getLuminosità());
                System.out.println("1. Modifica Titolo");
                System.out.println("2. Modifica Volume");
                System.out.println("3. Modifica Luminosità");
                System.out.println("0. Torna indietro");
            }

            System.out.print("Scegli un'opzione: ");
            int sceltaModifica = scanner.nextInt();

            if (sceltaModifica == 1) {
                System.out.print("Inserisci il nuovo titolo: ");
                scanner.nextLine(); // Consuma la nuova riga
                String nuovoTitolo = scanner.nextLine();
                elemento.setTitolo(nuovoTitolo);
                System.out.println("Titolo aggiornato a: " + nuovoTitolo);
            } else if (sceltaModifica == 2) {
                System.out.print("Inserisci di quanto aumentare o diminuire il volume (numero negativo per diminuire): ");
                int variazioneVolume = scanner.nextInt();
                if (elemento instanceof Audio) {
                    if (variazioneVolume > 0) {
                        ((Audio) elemento).alzaVolume(variazioneVolume);
                    } else {
                        ((Audio) elemento).abbassaVolume(-variazioneVolume);
                    }
                } else if (elemento instanceof Video) {
                    if (variazioneVolume > 0) {
                        ((Video) elemento).alzaVolume(variazioneVolume);
                    } else {
                        ((Video) elemento).abbassaVolume(-variazioneVolume);
                    }
                }
            } else if (sceltaModifica == 3) {
                System.out.print("Inserisci di quanto aumentare o diminuire la luminosità (numero negativo per diminuire): ");
                int variazioneLuminosita = scanner.nextInt();
                if (elemento instanceof Video) {
                    if (variazioneLuminosita > 0) {
                        ((Video) elemento).aumentaLuminosita(variazioneLuminosita);
                    } else {
                        ((Video) elemento).diminuisciLuminosita(-variazioneLuminosita);
                    }
                } else if (elemento instanceof Immagine) {
                    if (variazioneLuminosita > 0) {
                        ((Immagine) elemento).aumentaLuminosita(variazioneLuminosita);
                    } else {
                        ((Immagine) elemento).diminuisciLuminosita(-variazioneLuminosita);
                    }
                }
            } else if (sceltaModifica == 0) {
                modificheAttive = false; // Torna al menu precedente
            } else {
                System.out.println("Opzione non valida.");
            }
        }
    }

    public static void main(String[] args) {
        LettoreMultimediale lettore = new LettoreMultimediale();
        lettore.esegui();
    }
}

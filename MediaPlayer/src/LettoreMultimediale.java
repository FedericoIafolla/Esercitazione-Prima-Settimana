import java.util.Scanner;

public class LettoreMultimediale {
    private ElementoMultimediale[] elementi = new ElementoMultimediale[10];
    private Scanner scanner = new Scanner(System.in);
    private int conteggioElementi = 0;

    public LettoreMultimediale() {
        System.out.println("Benvenuto nel MediaPlayer!");
    }

    public static void main(String[] args) {
        LettoreMultimediale lettore = new LettoreMultimediale();
        lettore.avvia();
    }

    public void avvia() {
        while (conteggioElementi < 5) {
            System.out.print("Inserisci il " + (conteggioElementi + 1) + "° titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("Selezionare la tipologia (1: Immagine, 2: Audio, 3: Video): ");
            int tipo = scanner.nextInt();
            if (tipo == 1) {
                System.out.print("Inserisci luminosità (0-100): ");
                int luminosità = scanner.nextInt();
                elementi[conteggioElementi] = new Immagine(titolo, luminosità);
            } else if (tipo == 2) {
                System.out.print("Inserisci durata (in secondi): ");
                int durata = scanner.nextInt();
                System.out.print("Inserisci volume (0-100): ");
                int volume = scanner.nextInt();
                elementi[conteggioElementi] = new Audio(titolo, durata, volume);
            } else if (tipo == 3) {
                System.out.print("Inserisci durata (in secondi): ");
                int durata = scanner.nextInt();
                System.out.print("Inserisci volume (0-100): ");
                int volume = scanner.nextInt();
                System.out.print("Inserisci luminosità (0-100): ");
                int luminosità = scanner.nextInt();
                elementi[conteggioElementi] = new Video(titolo, durata, volume, luminosità);
            }
            conteggioElementi++;
            scanner.nextLine();
        }
        esegui();
    }

    public void esegui() {
        boolean running = true;
        while (running) {
            mostraMenu();
            int scelta = scanner.nextInt();
            if (scelta == 1) {
                mostraElementi();
                System.out.print("Seleziona l'elemento da riprodurre (1-" + conteggioElementi + ") o digita 0 per tornare al menu: ");
                int indice = scanner.nextInt() - 1;
                if (indice == -1) {
                    continue;
                } else if (indice >= 0 && indice < conteggioElementi && elementi[indice] != null) {
                    elementi[indice].play();
                } else {
                    System.out.println("Elemento non valido.");
                }
            } else if (scelta == 2) {
                mostraElementi();
                System.out.print("Seleziona l'elemento da modificare (1-" + conteggioElementi + ") o digita 0 per tornare al menu: ");
                int indice = scanner.nextInt() - 1;
                if (indice == -1) {
                    continue;
                } else if (indice >= 0 && indice < conteggioElementi && elementi[indice] != null) {
                    modificaImpostazioni(elementi[indice]);
                } else {
                    System.out.println("Elemento non valido.");
                }
            } else if (scelta == 3) {
                if (conteggioElementi < 10) {
                    System.out.print("Inserisci il " + (conteggioElementi + 1) + "° titolo: ");
                    scanner.nextLine();
                    String titolo = scanner.nextLine();
                    System.out.print("Selezionare la tipologia (1: Immagine, 2: Audio, 3: Video): ");
                    int tipo = scanner.nextInt();
                    if (tipo == 1) {
                        System.out.print("Inserisci luminosità (0-100): ");
                        int luminosità = scanner.nextInt();
                        elementi[conteggioElementi] = new Immagine(titolo, luminosità);
                    } else if (tipo == 2) {
                        System.out.print("Inserisci durata (in secondi): ");
                        int durata = scanner.nextInt();
                        System.out.print("Inserisci volume (0-100): ");
                        int volume = scanner.nextInt();
                        elementi[conteggioElementi] = new Audio(titolo, durata, volume);
                    } else if (tipo == 3) {
                        System.out.print("Inserisci durata (in secondi): ");
                        int durata = scanner.nextInt();
                        System.out.print("Inserisci volume (0-100): ");
                        int volume = scanner.nextInt();
                        System.out.print("Inserisci luminosità (0-100): ");
                        int luminosità = scanner.nextInt();
                        elementi[conteggioElementi] = new Video(titolo, durata, volume, luminosità);
                    }
                    conteggioElementi++;
                } else {
                    System.out.println("Hai raggiunto il numero massimo di elementi.");
                }
            } else if (scelta == 4) {
                mostraListaElementi();
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
                        confermaUscita = true;
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
        System.out.println("3. Aggiungi un elemento extra");
        System.out.println("4. Lista elementi");
        System.out.println("0. Esci");
    }

    private void mostraElementi() {
        System.out.println("Elementi disponibili:");
        for (int i = 0; i < conteggioElementi; i++) {
            if (elementi[i] != null) {
                System.out.println((i + 1) + ". " + elementi[i].getTitolo());
            }
        }
    }

    private void mostraListaElementi() {
        System.out.println("Lista degli elementi:");
        StringBuilder immagini = new StringBuilder("Immagini: ");
        StringBuilder audio = new StringBuilder("Audio: ");
        StringBuilder video = new StringBuilder("Video: ");

        for (int i = 0; i < conteggioElementi; i++) {
            if (elementi[i] instanceof Immagine) {
                immagini.append("\"").append(elementi[i].getTitolo()).append("\"; Luminosità: ").append(((Immagine) elementi[i]).getLuminosità()).append(", ");
            } else if (elementi[i] instanceof Audio) {
                audio.append("\"").append(elementi[i].getTitolo()).append("\"; Volume: ").append(((Audio) elementi[i]).getVolume()).append(", Durata: ").append(((Audio) elementi[i]).getDurata()).append("s, ");
            } else if (elementi[i] instanceof Video) {
                video.append("\"").append(elementi[i].getTitolo()).append("\"; Volume: ").append(((Video) elementi[i]).getVolume()).append(", Luminosità: ").append(((Video) elementi[i]).getLuminosità()).append(", Durata: ").append(((Video) elementi[i]).getDurata()).append("s, ");
            }
        }

        System.out.println(immagini.toString());
        System.out.println(audio.toString());
        System.out.println(video.toString());
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
                System.out.println("Durata: " + ((Audio) elemento).getDurata() + "s");
                System.out.println("1. Modifica Titolo");
                System.out.println("2. Modifica Volume");
                System.out.println("0. Torna indietro");
            } else if (elemento instanceof Video) {
                System.out.println("Titolo: " + elemento.getTitolo());
                System.out.println("Volume attuale: " + ((Video) elemento).getVolume());
                System.out.println("Luminosità attuale: " + ((Video) elemento).getLuminosità());
                System.out.println("Durata: " + ((Video) elemento).getDurata() + "s");
                System.out.println("1. Modifica Titolo");
                System.out.println("2. Modifica Volume");
                System.out.println("3. Modifica Luminosità");
                System.out.println("0. Torna indietro");
            }

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Nuovo titolo: ");
                    String nuovoTitolo = scanner.nextLine();
                    elemento.setTitolo(nuovoTitolo);
                    System.out.println("Titolo aggiornato!");
                    break;
                case 2:
                    if (elemento instanceof Audio) {
                        System.out.print("Nuovo volume (0-100): ");
                        int nuovoVolume = scanner.nextInt();
                        ((Audio) elemento).setVolume(nuovoVolume);
                        System.out.println("Volume aggiornato!");
                    } else if (elemento instanceof Immagine) {
                        System.out.print("Nuova luminosità (0-100): ");
                        int nuovaLuminosità = scanner.nextInt();
                        ((Immagine) elemento).setLuminosità(nuovaLuminosità);
                        System.out.println("Luminosità aggiornata!");
                    } else if (elemento instanceof Video) {
                        System.out.print("Nuovo volume (0-100): ");
                        int nuovoVolumeVideo = scanner.nextInt();
                        ((Video) elemento).setVolume(nuovoVolumeVideo);
                        System.out.println("Volume aggiornato!");
                    }
                    break;
                case 3:
                    if (elemento instanceof Video) {
                        System.out.print("Nuova luminosità (0-100): ");
                        int nuovaLuminositàVideo = scanner.nextInt();
                        ((Video) elemento).setLuminosità(nuovaLuminositàVideo);
                        System.out.println("Luminosità aggiornata!");
                    } else {
                        System.out.println("Opzione non disponibile per questo tipo di elemento.");
                    }
                    break;
                case 0:
                    modificheAttive = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}

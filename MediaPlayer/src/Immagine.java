public class Immagine extends ElementoMultimediale {
    private int luminosità;

    public Immagine(String titolo, int luminosità) {
        super(titolo);
        this.luminosità = luminosità;
    }

    public int getLuminosità() {
        return luminosità;
    }

    public void aumentaLuminosita(int variazione) {
        luminosità = Math.min(100, luminosità + variazione);
        System.out.println("Luminosità attuale: " + luminosità);
    }

    public void diminuisciLuminosita(int variazione) {
        luminosità = Math.max(0, luminosità - variazione);
        System.out.println("Luminosità attuale: " + luminosità);
    }

    @Override
    public void play() {
        System.out.println("Visualizzo immagine: " + titolo);
        show(); // Mostra l'immagine utilizzando il metodo show
    }

    @Override
    public void show() {
        System.out.println(titolo + " " + "*".repeat(luminosità));
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Dettagli Immagine: " + titolo + ", Luminosità: " + luminosità);
    }
}

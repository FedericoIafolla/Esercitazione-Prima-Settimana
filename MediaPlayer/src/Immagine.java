public class Immagine extends ElementoMultimediale {
    private int luminosità;

    public Immagine(String titolo, int luminosità) {
        super(titolo);
        this.luminosità = Math.max(0, Math.min(100, luminosità));
    }

    public int getLuminosità() {
        return luminosità;
    }

    public void setLuminosità(int luminosità) {
        this.luminosità = Math.max(0, Math.min(100, luminosità));
        System.out.println("Luminosità attuale: " + this.luminosità);
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

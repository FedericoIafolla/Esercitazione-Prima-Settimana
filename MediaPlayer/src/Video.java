public class Video extends ElementoMultimediale {
    private int durata;
    private int volume;
    private int luminosità;

    public Video(String titolo, int durata, int volume, int luminosità) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosità = luminosità;
    }

    public int getVolume() {
        return volume;
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

    public void abbassaVolume(int variazione) {
        volume = Math.max(0, volume - variazione);
        System.out.println("Volume attuale: " + volume);
    }

    public void alzaVolume(int variazione) {
        volume = Math.min(100, volume + variazione);
        System.out.println("Volume attuale: " + volume);
    }

    @Override
    public void play() {
        System.out.println("Inizio riproduzione di " + titolo);
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosità));
        }
    }

    @Override
    public void show() {
        System.out.println("Video: " + titolo + ", Durata: " + durata + ", Volume: " + volume + ", Luminosità: " + luminosità);
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Dettagli Video: " + titolo + ", Durata: " + durata + ", Volume: " + volume + ", Luminosità: " + luminosità);
    }
}

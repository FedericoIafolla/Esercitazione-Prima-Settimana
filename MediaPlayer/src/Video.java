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

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("Volume attuale: " + this.volume);
    }

    public int getLuminosità() {
        return luminosità;
    }

    public void setLuminosità(int luminosità) {
        this.luminosità = Math.max(0, Math.min(100, luminosità));
        System.out.println("Luminosità attuale: " + this.luminosità);
    }

    public int getDurata() {
        return durata;
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

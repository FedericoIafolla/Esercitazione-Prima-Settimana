public class Audio extends ElementoMultimediale {
    private int durata;
    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume)); // Ensure volume stays between 0 and 100
        System.out.println("Volume attuale: " + this.volume);
    }

    @Override
    public void play() {
        System.out.println("Inizio riproduzione di " + titolo);
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
        }
    }

    @Override
    public void show() {
        System.out.println("Audio: " + titolo + ", Durata: " + durata + ", Volume: " + volume);
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Dettagli Audio: " + titolo + ", Durata: " + durata + ", Volume: " + volume);
    }
}

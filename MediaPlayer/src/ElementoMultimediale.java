public abstract class ElementoMultimediale {
    protected String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public abstract void play();

    public abstract void show();

    public abstract void mostraDettagli();
}

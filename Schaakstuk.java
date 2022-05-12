package week3;

public class Schaakstuk {
     private String naam;
     private String kleur;
    public Schaakstuk(String stukNaam,String stukKleur){
        this.naam = stukNaam;
        this.kleur = stukKleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String getKleur() {
        return kleur;
    }
    public void print(){
        System.out.println(naam+" "+kleur);
    }
}

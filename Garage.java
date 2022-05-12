package week3;

import java.util.Scanner;

public class Garage {
    static Klant[] klanten = new Klant[5];
    static Auto[] autos = new Auto[5];
    static int amount = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        maakAutos();
        maakKlanten();
        getKlanten();
        System.out.println("Kies klant:");
        int id = input.nextInt();
        String wow = String.format("Welkom %s bij de garage – kies een auto",klanten[id].getNaam());
        System.out.println(wow);
        getAutos();
        int id2 = input.nextInt();
        String wow2 = String.format("Dank voor je aankoop – je hebt de %s gekocht",autos[id2].getNaam());
        String wow3 = String.format("De garage heeft nu %s in de kassa.",amount+autos[id2].getVerkoopPrijs());
        boolean b = checkBedrag(klanten[id],autos[id2]);
        if (b){
            System.out.println(wow2+"\n"+wow3);
        } else {
            System.out.println("NEGATORY");
        }
    }

    public static void maakAutos(){
        autos[0] = new Auto("Rolce Royce","Zilver",100000);
        autos[1] = new Auto("batMobiel","zwart",250000);
        autos[2] = new Auto("catMobiel","zwart",200000);
        autos[3] = new Auto("kawasakiNinjaB","blauw",15000);
        autos[4] = new Auto("kawasakiNinjaR","rood",10000);
    }
    public static void maakKlanten(){
        klanten[0] = new Klant(1,"Alfred",100000);
        klanten[1] = new Klant(2,"bruce",250000);
        klanten[2] = new Klant(3,"cat",200000);
        klanten[3] = new Klant(4,"grayson",15000);
        klanten[4] = new Klant(5,"robin",10000);
    }
    public static void getKlanten(){
        for (int i = 0; i<klanten.length; i++){
            klanten[i].print();
        }
    }
    public static void getAutos(){
        for (int i = 0; i<autos.length; i++){
            autos[i].print();
        }
    }
    public static boolean checkBedrag(Klant klant, Auto auto){
        return klant.getBedrag() >= auto.getVerkoopPrijs();
    }
}

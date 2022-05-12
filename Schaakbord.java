package week3;

public class Schaakbord {
    public static Schaakstuk[][] bord = new Schaakstuk[8][8];
    public static String[][] legenda = new String[8][8];
    public Schaakbord(){
        maakNieuwBordOp();
        maakLegenda();
        printSchaakbord();
    }
    public static void maakNieuwBordOp(){
        for (int i = 0; i < bord.length; i++){
            bord[1][i] = new Schaakstuk("Pion","Zwart");
            bord[6][i] = new Schaakstuk("Pion","Wit");
        }
        for (int i = 0; i < bord.length; i++){
            for (int j = 2; j < 6; j++){
                bord[j][i] = new Schaakstuk("Leeg","Leeg");
            }
        }
        bord[0][0] = new Schaakstuk("Toren","Zwart");
        bord[0][7] = new Schaakstuk("Toren","Zwart");
        bord[7][0] = new Schaakstuk("Toren","Wit");
        bord[7][7] = new Schaakstuk("Toren","Wit");

        bord[0][1] = new Schaakstuk("Paard","Zwart");
        bord[0][6] = new Schaakstuk("Paard","Zwart");
        bord[7][1] = new Schaakstuk("Paard","Wit");
        bord[7][6] = new Schaakstuk("Paard","Wit");

        bord[0][2] = new Schaakstuk("Loper","Zwart");
        bord[0][5] = new Schaakstuk("Loper","Zwart");
        bord[7][2] = new Schaakstuk("Loper","Wit");
        bord[7][5] = new Schaakstuk("Loper","Wit");

        bord[0][3] = new Schaakstuk("Dame","Zwart");
        bord[7][3] = new Schaakstuk("Dame","Wit");

        bord[0][4] = new Schaakstuk("Koning","Zwart");
        bord[7][4] = new Schaakstuk("Koning","Wit");
    }
    public static void getBord() {
        for (int i = 0; i < bord.length; i++) {
            for (int j = 0; j < bord.length; j++) {
                bord[j][i].print();
            }
        }
    }
    public int[] getArrayPosities(String code){
        int[] wouw = new int[2];
        for (int i = 0; i<legenda.length; i++){
            for (int j = 0; j<legenda.length; j++) {
                if (legenda[i][j].equals(code)) {
                    wouw[0] = i;
                    wouw[1] = j;
                    return wouw;
                }
            }
        }
        return wouw;
    }
    public static void printSchaakbord(){
        for (int i = 0; i<bord.length; i++){
            for (int j = 0; j<bord.length; j++){
                String print = String.format("%s: %s | ",legenda[i][j],bord[i][j].getNaam()+"("+bord[i][j].getKleur()+")");
                System.out.print(print);
                if (j == 7){
                    System.out.print("\n");
                }
            }
        }

        String print2 = String.format("%s: %s |",legenda[0][1],bord[0][1].getNaam()+"("+bord[0][1].getKleur()+")");

    }
    public void doeZet(String vanCode, String naarCode){
        int[] van = getArrayPosities(vanCode);
        int[] naar = getArrayPosities(naarCode);
        Schaakstuk a = bord[van[0]][van[1]];
        bord[naar[0]][naar[1]] = a;
        bord[van[0]][van[1]] = new Schaakstuk("Leeg","Leeg");
        printSchaakbord();
    }
    public void maakLegenda() {
        legenda[0][0] = "A8";
        legenda[0][1] = "B8";
        legenda[0][2] = "C8";
        legenda[0][3] = "D8";
        legenda[0][4] = "E8";
        legenda[0][5] = "F8";
        legenda[0][6] = "G8";
        legenda[0][7] = "H8";
        legenda[1][0] = "A7";
        legenda[1][1] = "B7";
        legenda[1][2] = "C7";
        legenda[1][3] = "D7";
        legenda[1][4] = "E7";
        legenda[1][5] = "F7";
        legenda[1][6] = "G7";
        legenda[1][7] = "H7";
        legenda[2][0] = "A6";
        legenda[2][1] = "B6";
        legenda[2][2] = "C6";
        legenda[2][3] = "D6";
        legenda[2][4] = "E6";
        legenda[2][5] = "F6";
        legenda[2][6] = "G6";
        legenda[2][7] = "H6";
        legenda[3][0] = "A5";
        legenda[3][1] = "B5";
        legenda[3][2] = "C5";
        legenda[3][3] = "D5";
        legenda[3][4] = "E5";
        legenda[3][5] = "F5";
        legenda[3][6] = "G5";
        legenda[3][7] = "H5";
        legenda[4][0] = "A4";
        legenda[4][1] = "B4";
        legenda[4][2] = "C4";
        legenda[4][3] = "D4";
        legenda[4][4] = "E4";
        legenda[4][5] = "F4";
        legenda[4][6] = "G4";
        legenda[4][7] = "H4";
        legenda[5][0] = "A3";
        legenda[5][1] = "B3";
        legenda[5][2] = "C3";
        legenda[5][3] = "D3";
        legenda[5][4] = "E3";
        legenda[5][5] = "F3";
        legenda[5][6] = "G3";
        legenda[5][7] = "H3";
        legenda[6][0] = "A2";
        legenda[6][1] = "B2";
        legenda[6][2] = "C2";
        legenda[6][3] = "D2";
        legenda[6][4] = "E2";
        legenda[6][5] = "F2";
        legenda[6][6] = "G2";
        legenda[6][7] = "H2";
        legenda[7][0] = "A1";
        legenda[7][1] = "B1";
        legenda[7][2] = "C1";
        legenda[7][3] = "D1";
        legenda[7][4] = "E1";
        legenda[7][5] = "F1";
        legenda[7][6] = "G1";
        legenda[7][7] = "H1";
    }


}

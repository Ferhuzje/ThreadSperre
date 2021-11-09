public class Program {
    public static void main(String[] args) throws Exception {
        // 1. Konto mit einem Guthaben = 100
        // 2. Geldkarten/EC-Karte heben gleichzeitig Geld ab

        Konto konto = new Konto(100);

        Geldkarte karte1 = new Geldkarte(konto);
        Geldkarte karte2 = new Geldkarte(konto);
        Geldkarte karte3 = new Geldkarte(new Konto(100));

        karte1.geldAbheben(80);
        karte2.geldAbheben(60);
        karte3.geldAbheben(70);

        karte1.start();
        karte2.start();
        karte3.start();


    }
}

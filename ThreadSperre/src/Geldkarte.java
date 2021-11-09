import java.util.*;
//import java.lang.Thread;

public class Geldkarte extends Thread {

    Konto konto;
    double betrag; // Betrag, der vom Konto abgehoben werden soll

    public Geldkarte(final Konto konto) {
        this.konto = konto;
    }

    public void geldAbheben(final double betrag) {
        this.betrag = betrag;
    }
    
    @Override
    public void run() {

        //solange ein Thread diesen Quellcode durchlaeuft, muessen andere Threads warten
        synchronized(konto) {
            if(konto.getGuthaben() >= betrag) {
                try {
                    Thread.sleep(new Random().nextInt(2000) + 1000);
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                
               // System.out.println("test");
                konto.setGuthaben( konto.getGuthaben() - betrag );
                System.out.println("Geldbetrag " + betrag + "wurde ausgezahlt. Kontostand: " + konto.getGuthaben());
                System.out.println("Kontostand: " + konto.getGuthaben());
            }
            else {
                System.out.println("Keine Auszahlung! Nicht genügend Guthaben");
            }
        }
    }

}

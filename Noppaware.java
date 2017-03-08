
import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Noppaware {
    
    public static void main(String[] args) {
        if (args.length == 1) {
            if (args[0].equals("apua")) {
                tulostaApua();
            } else {
                try {
                    int slPituus = Integer.parseInt(args[0]);
                    luoSalaLauseet(slPituus, 10);
                } catch (NumberFormatException e) {
                    System.out.println("Virheelliset argumentit." 
                            + " Suorita 'java Noppaware apua' saadaksesi lisätietoja.");
                    return;
                }
            }
        } else if (args.length == 2) {
            try {
                int slPituus = Integer.parseInt(args[0]);
                int slMaara = Integer.parseInt(args[1]);
                luoSalaLauseet(slPituus, slMaara);
            } catch (NumberFormatException e) {
                System.out.println("Virheelliset argumentit."
                        + " Suorita 'java Noppaware apua' saadaksesi lisätietoja.");
                return;
            }
        } else {
            luoSalaLauseet(6, 10);
        }
    }
    
    private static void tulostaApua() {
        System.out.println("Noppaware 1.0, Noppaware -sanalistaan perustuva salalausegeneraattori");
        System.out.println("Käyttö:");
        System.out.println(" java Noppaware [sl_pituus] [sl_maara]\n");
        System.out.println("Argumentit:");
        System.out.println(" sl_pituus,\tsalalauseen mitta sanoina");
        System.out.println(" sl_maara,\tgeneroitavien salalauseiden määrä\n");
        System.out.println("Oletus (ei argumentteja):");
        System.out.println(" sl_pituus: 6");
        System.out.println(" sl_maara: 10");

    }
    
    private static void luoSalaLauseet(int slPituus, int slMaara) {
        Random rand = new SecureRandom();
        List<String> sanalista = lueSanaTiedosto("noppaware.txt");
        int sanaListanKoko = sanalista.size();
        double sanaListanEntropia = Math.log(sanaListanKoko) / Math.log(2);
        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("Sanalista: noppaware.txt");
        System.out.println("Sanalista sisältää: " 
                + sanalista.size() + " sanaa");
        System.out.println("Sanalistan entropia: " 
                + df.format(sanaListanEntropia) + " bittiä/sana");
        System.out.println("Salalauseen entropia: " 
                + df.format(sanaListanEntropia * slPituus)
                + " bittiä\n");
        
        for (int i = 0; i < slMaara; i++) {
            for (int j = 0; j < slPituus; j++) {
                int index = rand.nextInt(sanaListanKoko);
                System.out.print(sanalista.get(index) + " ");
            }
            System.out.println();
        }        
    }
    
    private static List<String> lueSanaTiedosto(String sanaTiedosto) {
        List<String> sanat = new ArrayList<>();
        try {
            File sanaListaTiedosto = new File(sanaTiedosto);
            Scanner tiedostoLukija = new Scanner(sanaListaTiedosto);
            while (tiedostoLukija.hasNextLine()) {
                sanat.add(tiedostoLukija.nextLine());
            }
            tiedostoLukija.close();
        } catch (FileNotFoundException e) {
            System.out.println("Virhe: " + e);
        }        
        return sanat;
    }
    
}

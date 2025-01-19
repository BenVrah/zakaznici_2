import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cesta = "src/main/resources/zakaznici.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(cesta))) {
            String radek = br.readLine();
            if (radek != null) {
                String[] zaznamy = radek.split(";");

                System.out.println("Zákazníci s jménem 'Ivana' a ID < 50:");
                for (String zaznam : zaznamy) {
                    String[] casti = zaznam.split(" ", 2);
                    if (casti.length == 2) {
                        int id = Integer.parseInt(casti[0]);
                        String jmeno = casti[1];
                        if (jmeno.startsWith("Ivana") && id < 50) {
                            System.out.println("ID: " + id);
                        }
                    }
                }
            } else {
                System.out.println("Soubor je prázdný.");
            }
        } catch (IOException e) {
            System.err.println("Chyba při čtení souboru: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Chybný formát ID v souboru.");
        }
    }
}
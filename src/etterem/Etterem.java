package etterem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Etterem {
    
    public static boolean elfogad(){
        System.out.println("Megelégedett ezekkel a termékekkel?(i - igen, n - nem)");
        Scanner scan = new Scanner(System.in);
        char n = scan.next().charAt(0);
        while(n != 'i' && n != 'n'){
            System.out.println("Hibas adat");
            n = scan.next().charAt(0);
        }
        if(n == 'i'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Üdvözlöm!");
        System.out.println("Egy vagy két terméket szeretne rendelni?(Maximum kettő)");
        Integer db;
        Scanner scan = new Scanner(System.in);
        db = scan.nextInt();
        while(db != 1 && db != 2){
            System.out.println("Nem megfelelő érték");
            db = scan.nextInt();
        }
        System.out.println("Adja meg hogy milyen összegben szeretne rendelni: (a minimum osszeg egy étel rendelés esetén: 700Ft, két étel esetén: 1400Ft. Ez az összeg nem tartalmazza a szállítási költséget)");
        Integer osszeg = scan.nextInt();
        while(osszeg<700*db){
            System.out.println("Nem megfelelő összeg");
            osszeg = scan.nextInt();
        }
        
        File file = new File("C:\\Users\\albre\\OneDrive\\Dokumentumok\\NetBeansProjects\\Etterem\\src\\etterem\\etlap.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String s;
        ArrayList<Etlap> etlap = new ArrayList<Etlap>();
        boolean etel = true;
        int osszegig;
        int meddig = 0;
        int elso = 0;
        int masodik = 0;
        while((s = br.readLine()) != null){
            Etlap e = new Etlap();
            e.etel = s;
            s = br.readLine();
            e.ar = Integer.parseInt(s);
            if(db == 1){
                if(e.ar <= osszeg){
                    meddig++;
                }
            }else{
                if(e.ar + 700 <= osszeg){
                    meddig++;
                }
            }
            
            etlap.add(e);
        }
        
        
        Random r = new Random();
        boolean elfogadva = false;
        while(elfogadva == false){
            if(db == 1){
                Integer sorszam = r.nextInt(meddig);
                elso = sorszam;
                System.out.println(etlap.get(sorszam).etel);
                System.out.println(etlap.get(sorszam).ar);
                if(elfogad() == true){
                    elfogadva = true;
                }
            }else{
                Integer sorszam = r.nextInt(meddig);
                System.out.println(etlap.get(sorszam).etel);
                System.out.println(etlap.get(sorszam).ar);
                elso = sorszam;
                Integer elozo = etlap.get(sorszam).ar;
                sorszam = r.nextInt(meddig);
                while(elozo + etlap.get(sorszam).ar > osszeg){
                    sorszam = r.nextInt(meddig);
                }
                masodik = sorszam;
                System.out.println(etlap.get(sorszam).etel);
                System.out.println(etlap.get(sorszam).ar);
                if(elfogad() == true){
                    elfogadva = true;
                }
            }
            
        }
        System.out.println("Elvitelre szertene rendelni, vagy kiszállítással?(e: elvitel, k: kiszallitas)");
        boolean kisz = false;
        char n = scan.next().charAt(0);
        while(n != 'k' && n != 'e'){
            System.out.println("Hibas adat");
            n = scan.next().charAt(0);
        }
        if(n == 'k'){
            kisz = true;
        }else{
            kisz = false;
        }
        
        ArrayList<Etlap> ren = new ArrayList<Etlap>();
        Integer ossz;
        if(db == 2){
            ren.add(etlap.get(elso));
            ren.add(etlap.get(masodik));
            ossz = etlap.get(elso).ar+etlap.get(masodik).ar;
        }else{
            ren.add(etlap.get(elso));
            ossz = etlap.get(elso).ar;
        }
        
        Rendeles rendeles = new Rendeles(ren, ossz);
        
        if(kisz == true){
            System.out.println("Hova szeretné a kiszállítást?(b: belváros, k: külváros, a: aglomeráció)");
            n = scan.next().charAt(0);
            RendelesEnum a;
            while(n != 'b' && n != 'k' && n != 'a'){
                System.out.println("Hibas adat");
                n = scan.next().charAt(0);
            }
            if(n == 'b'){
                a = RendelesEnum.Belvaros;
            }else if(n == 'k'){
                a = RendelesEnum.Kulvaros;
            }else{
                a = RendelesEnum.Aglomeracio;
            }
            Rendeles_kiszallitas rend = new Rendeles_kiszallitas(rendeles, a.koltseg());
            rend.toFile2();
        }else{
            Rendeles_elvitel rend = new Rendeles_elvitel(rendeles, db);
            rend.toFile2();
        }
        
        
        
        
        
        
    }
    
}

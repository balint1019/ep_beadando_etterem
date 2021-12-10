
package etterem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Rendeles_elvitel extends Rendeles{
    
    private Integer csomagok_szama;
    
    public void setCsomagok_szama(Integer cs){
        this.csomagok_szama = cs;
    }
    public Integer getCsomagok_szama(){
        return this.csomagok_szama;
    }
    
    public Rendeles_elvitel(Rendeles rend, Integer cs){
        this.rendelt_etel = rend.rendelt_etel;
        this.csomagok_szama = cs;
        this.vegosszeg = rend.vegosszeg + cs*10;
    }
    
    public void toFile2() throws IOException{
      File file = new File("C:\\Users\\albre\\OneDrive\\Dokumentumok\\NetBeansProjects\\Etterem\\src\\etterem\\Rendeles.txt");
    Writer out = new FileWriter(file);
      for(Etlap i : this.rendelt_etel){
          out.write(i.etel + '\n');
          out.write(String.valueOf(i.ar)+ '\n');
      }
      out.write("Csomagok száma: " + String.valueOf(this.csomagok_szama) + '\n');
      out.write("Vegosszeg: " + String.valueOf(this.vegosszeg) + '\n');
      
      out.close();
    }
    
}

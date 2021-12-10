
package etterem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class Rendeles_kiszallitas extends Rendeles{
    
    private Integer szallitasi_koltseg; 
    
    public void setSzallitasi_koltseg(Integer sz){
        this.szallitasi_koltseg = sz;
    }
    public Integer getSzallitasi_koltseg(){
        return this.szallitasi_koltseg;
    }
    public Rendeles_kiszallitas(Rendeles r, Integer kisz){
        this.rendelt_etel = r.rendelt_etel;
        this.szallitasi_koltseg = kisz;
        this.vegosszeg = r.vegosszeg + kisz;
    }
    
    public void toFile2() throws IOException{
      File file = new File("C:\\Users\\albre\\OneDrive\\Dokumentumok\\NetBeansProjects\\Etterem\\src\\etterem\\Rendeles.txt");
    Writer out = new FileWriter(file);
      for(Etlap i : this.rendelt_etel){
          out.write(i.etel + '\n');
          out.write(String.valueOf(i.ar)+ '\n');
      }
      out.write("Szállítási költség: " + String.valueOf(this.szallitasi_koltseg) + '\n');
      out.write("Vegosszeg: " + String.valueOf(this.vegosszeg) + '\n');
      
      out.close();
    }
}

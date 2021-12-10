
package etterem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;


public class Rendeles {
    protected ArrayList<Etlap> rendelt_etel = new ArrayList<Etlap>();
    protected Integer vegosszeg;

    public Rendeles(){
        
    }
    
    public Rendeles(ArrayList<Etlap> rendelt_etel, Integer osszeg){
        this.rendelt_etel = rendelt_etel;
        this.vegosszeg = osszeg;
    }
    
    public void toFile() throws IOException{
      File file = new File("C:\\Users\\albre\\OneDrive\\Dokumentumok\\NetBeansProjects\\Etterem\\src\\etterem\\Rendeles.txt");
    Writer out = new FileWriter(file);
    //BufferedWriter out = new BufferedWriter(new FileWriter(file));
      for(Etlap i : this.rendelt_etel){
          out.write(i.etel + '\n');
          out.write(String.valueOf(i.ar)+ '\n');
      }
      out.write("Vegosszeg: " + String.valueOf(this.vegosszeg) + '\n');
      
      out.close();
    }



}



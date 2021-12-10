
package etterem;


public enum RendelesEnum {
    
    Belvaros(100), Kulvaros(200), Aglomeracio(450);
    
    private final Integer koltseg;
    private RendelesEnum(Integer k){
        this.koltseg = k;
    }
    public Integer koltseg(){
        return koltseg;
    }
    
}

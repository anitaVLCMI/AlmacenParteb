package Modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Mueble extends Producto {

    public enum Madera {
        PINO, ROBLE, HAYA
    };

    private LocalDate anyoFab;
    private Madera tipoMadera;
    private String estilo;

    public Mueble() {
        super();
    }


    @Override
    public String imprimirProducto() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yy");
        
        String format="%s El año de Fabricsacion: %s Tipo de madera: %s El estilo: %s";
        String res=String.format(format,super.imprimirProducto(),sdf.format(anyoFab),this.tipoMadera,getEstilo());
//        String res = super.imprimirProducto() + "el año de fabricación: " + sdf.format(anyoFab) + " el tipo de madera: " + this.tipoMadera + "el estilo: " + getEstilo();
        return res;

    }

    @Override
    public void setPrecio(double precioBase) {
         this.precio=precioBase;
  
    }

    public LocalDate getAnyoFab() {
        return anyoFab;
    }

    public void setAnyoFab(LocalDate anyoFab) {
        this.anyoFab = anyoFab;
    }

    public Madera getTipoMadera() {
        return tipoMadera;
    }

    public void setTipoMadera(Madera madera) {
        this.tipoMadera = madera;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

}

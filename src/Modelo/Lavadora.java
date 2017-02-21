
package Modelo;


public class Lavadora extends Electrodomestico {
    int revoluciones;
    double carga;
    public Lavadora(){
        super();
    }
    
    @Override
    public void setPrecio(double precioBase){
      this.precio=precioBase;
        
    }

    public int getRevoluciones() {
        return revoluciones;
    }

    public void setRevoluciones(int revoluciones) {
        this.revoluciones = revoluciones;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
    
    @Override
    public String imprimirProducto(){
        String format=" %s de revoluciones: %s con carga: %s";
        String res=String.format(format,super.imprimirProducto(),this.revoluciones,this.carga);
//        String res = super.imprimirProducto() + "de revoluciones: "+this.revoluciones+ "con carga: "+this.carga;
        return res;
    }
    
 
}


package Modelo;


public  abstract class Electrodomestico extends Producto {
    protected String marca;
    protected double tamanyo;
    protected String fabricante;
    
    public Electrodomestico(){
        super();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(double tamanyo) {
        this.tamanyo = tamanyo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    @Override
    public String  imprimirProducto(){
        String format=" %s de marca: %s de tamaño: %s fabricado por: %s ";
        String res=String.format(format,super.imprimirProducto(),this.getMarca(),this.tamanyo ,this.getFabricante());
//        String res = super.imprimirProducto() + " de marca: "+this.getMarca() + " de tamaño: "+this.tamanyo+ " fabricado por: "+this.getFabricante();
        return res;
    }
    
    
}

        

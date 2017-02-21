package Modelo;

import java.util.Scanner;

public class Mayorista extends Cliente {

    private String cif;
    private TipoMayorista tipoMayorista;
    private double descuento;

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public TipoMayorista getTipoMayorista() {
        return tipoMayorista;
    }

    public void setTipoMayorista(TipoMayorista tipoMayorista) {
        this.tipoMayorista = tipoMayorista;
    }
    

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String imprimir() {
        String format="%s CIF: %s Tipo de Mayorista: %s Descuento: %s ";
        //cif, tipo mayorista y descuento.
        String res=String.format(format,super.imprimir(), this.cif ,this.tipoMayorista,this.descuento );
//        String res = super.imprimir() + "CIF: " + this.cif + " Tipo mayorista: " + this.tipoMayorista + " descuento: " + this.descuento;
        return res;

    }

 

}

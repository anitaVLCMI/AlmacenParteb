/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Lavadora;
import Modelo.Mueble;
import Modelo.Producto;
import Modelo.Televisor;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw
 */
public class ProductosService {
     private List<Producto> productos;
    
    ProductosService(){
        productos = new ArrayList();
    }
    
    public void introducirProducto(Producto p) {

        try {
            productos.add(p);
        } catch (Exception e) {
            throw new RuntimeException("Error al introducir el producto\n" + e.getMessage());
        }
    }
    
    public Producto buscarProducto(int np) throws Exception {
        Producto producto = null;
        boolean esta = false;
        for (int i = 0; i < productos.size() && esta == false; i++) {
            if (productos.get(i).getId() == np) {
                producto = productos.get(i);
                esta = true;
            }
        }

        if (producto == null) {
            throw new Exception("El producto no existe.");
        }
        return producto;
    }
    
    public void elimninarProducto(int nproducto) {
        try {
            Producto productoEliminar = null;
            //Eliminamos de ventas el producto seleccionado
            List<Venta> ventasEliminar = new ArrayList();
            for (Venta v : ventas) {
                if (v.getProducto().getId() == nproducto) {
                    ventasEliminar.add(v);
                }
            }
            ventas.removeAll(ventasEliminar);

            //Eliminamos el producto
            for (Producto p : productos) {
                if (p.getId() == nproducto) {
                    productoEliminar = p;
                }
            }
            productos.remove(productoEliminar);

        } catch (Exception e) {
            throw new RuntimeException("imposible eliminar producto");
        }

    }
    
        public String imprimirTodosProductos() {
        String res = "";
        if (productos.isEmpty()) {
            res = "No hay productos introducidos.";
            
        } else {
            for (Producto p : productos) {
                if (p instanceof Televisor) {
                    
                    String patron="\n ID: %s Nombre: %s Precio: %s Marca: %s Fabricante: $s Tamaño: %s Tipo: %s Pulgadas: %s";
                    Televisor t = (Televisor) p;
//                    res += "\n ID NOMBRE  PRECIO  MARCA   FABRICANTE  TAMAÑO   TIPO    PULGADAS" + "\n" + t.getId() + "   " + t.getNombre() + "   " + t.getPrecio() + t.getMarca() + "   " + t.getFabricante() + "   " + t.getTamanyo() + t.getTipo() + "  " + t.getPulgadas();
                    res=String.format(patron,t.getId(), t.getNombre(),t.getPrecio(),t.getMarca(),t.getFabricante(),t.getTamanyo(),t.getTipo(),t.getPulgadas());
                }

                    String patron="\n ID: %s Nombre: %s Precio: %s Marca: %s Fabricante: $s Revoluciones: %s Carga: %s ";
                if (p instanceof Lavadora) {
                    Lavadora l = (Lavadora) p;
//                    res += "\n ID NOMBRE  PRECIO  MARCA   FABRICANTE  REVOLUCIONES  CARGA" + "\n" + l.getId() + "   " + l.getNombre() + "   " + l.getPrecio() + "  " + l.getMarca() + "         " + l.getFabricante() + "   " + l.getTamanyo() + "     " + l.getRevoluciones() + "     " + l.getCarga();
                res=String.format(patron,l.getId(),l.getNombre(),l.getPrecio(),l.getMarca(),l.getFabricante(),l.getTamanyo(),l.getRevoluciones(),l.getCarga());
                }

                if (p instanceof Mueble) {
                    Mueble m = (Mueble) p;
                    res += "\n ID NOMBRE  PRECIO     AÑO FABRICACION              MADERA  ESTILO" + "\n" + m.getId() + "   " + m.getNombre() + "   " + m.getPrecio() + "  " + m.getAnyoFab() + "   " + m.getTipoMadera() + "     " + m.getEstilo();

                }
            }
        }
        return res;
    }
    
    
}

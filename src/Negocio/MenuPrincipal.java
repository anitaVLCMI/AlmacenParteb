package Negocio;

import Modelo.Cliente;
import Modelo.FormatoFechaErroneo;
import Modelo.Lavadora;
import Modelo.Mayorista;
import Modelo.Mueble;
import Modelo.Particular;
import Modelo.Producto;
import Modelo.Televisor;
import Modelo.TipoMayorista;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MenuPrincipal {

    NegociosService servicio;
    ProductosService producto;

    MenuPrincipal() {
        Producto =new ProductosService();
        servicio = new NegociosService();
    }

    public void inciarAplicacion() {
        try {
            // menu Principal
            int opcion = -1;
            do {
                System.out.println("1.Productos");
                System.out.println("2.Clientes");
                System.out.println("3.Ventas");
                System.out.println("0. Para Salir");
                System.out.println("Introduzca la opcion");
                Scanner sc = new Scanner(System.in);
                opcion = sc.nextInt();
                if (opcion == 1) {
                    menuProductos();
                }
                if (opcion == 2) {
                    menuClientes();
                }
                if (opcion == 3) {
                    menuVentas();
                }

            } while (opcion != 0);

            System.out.println("Gracias por usar nuestra aplicacion");
            System.out.println("Hasta la proxima");

        } catch (Exception e) {
            System.out.println("Opcion no valida");
            this.inciarAplicacion();
        }
    }

    private void menuProductos() {
        try {
            int opcionProductos = -1;
            do {
                System.out.println("1.Introducir Producto");
                System.out.println("2.Dar de baja un producto");
                System.out.println("3.Imprimir los datos de un producto");
                System.out.println("4.Imprimir todos los productos");
                System.out.println("0. Salir del menu");
                Scanner sc = new Scanner(System.in);
                opcionProductos = sc.nextInt();

                if (opcionProductos == 1) {
                    Producto p = datosProducto();
                    servicio.introducirProducto(p);
                }
                if (opcionProductos == 2) {
                    System.out.println("Introduzca el número de producto: ");
                    int num = sc.nextInt();
                    servicio.elimninarProducto(num);
                }
                if (opcionProductos == 3) {
                    System.out.println("Introduzca el número de producto: ");
                    int nprod = sc.nextInt();
                    System.out.println(servicio.buscarProducto(nprod).imprimirProducto());
                }
                if (opcionProductos == 4) {
                    System.out.println(servicio.imprimirTodosProductos());
                }

            } while (opcionProductos != 0);
        } catch (Exception e) {
            System.out.println("Opcion no valida" + e.getMessage());
            this.menuProductos();
        }
    }

    public Producto datosProducto() throws Exception {
        Scanner sc = new Scanner(System.in);
        Producto producto = null;
        String nombre;
        double precio;
        int opcion = -1;
        do {
            System.out.println("Introduzca el nombre: ");
            nombre = sc.nextLine();

            System.out.println("Introduzca precio base: ");
            precio = Double.parseDouble(sc.nextLine());

            System.out.println("Introduzca el tipo de producto: ");
            System.out.println("1. Mueble");
            System.out.println("2. Lavadora");
            System.out.println("3. Televisor");
            opcion = sc.nextInt();
            if (opcion == 1) {
                producto = pedirMueble();
            }
            if (opcion == 2) {
                producto = pedirLavadora();
            }
            if (opcion == 3) {
                producto = pedirTelevisor();
            }
            if (producto != null) {
                producto.setNombre(nombre);
                producto.setPrecio(precio);
            }

        } while (opcion != 1 && opcion != 2 && opcion != 3);

        return producto;
    }

    public Mueble pedirMueble() throws ParseException {
        Mueble m = new Mueble();
        Scanner sc = new Scanner(System.in);

        m.setTipoMadera(pedirMadera());

        System.out.println("Introduzca el estilo:");
        m.setEstilo(sc.nextLine());

        System.out.println("Introduzca la fecha (dd-MMM-yy): ");

        try {
            m.setAnyoFab(this.validarFecha(sc.nextLine()));
        } catch (FormatoFechaErroneo e) {
            System.out.println(e.getMessage());
        }
        return m;

    }

    public Lavadora pedirLavadora() {
        Scanner sc = new Scanner(System.in);
        Lavadora l = new Lavadora();

        System.out.println("Introduzca las revoluciones(rpm): ");
        int rev = Integer.parseInt(sc.nextLine());
        l.setRevoluciones(rev);

        System.out.println("Introduzca la capacidad (kg): ");
        int c = Integer.parseInt(sc.nextLine());
        l.setCarga(c);

        return l;
    }

    public Televisor pedirTelevisor() {
        String opcionTV;
        Televisor tv = new Televisor();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca las pulgadas: ");
        double pulgadas = Double.parseDouble(sc.nextLine());
        tv.setPulgadas(pulgadas);
        tv.setTipo(pedirTipoTv());
        System.out.println("Fabricante tv ");
        tv.setFabricante(sc.nextLine());
        System.out.println("Marca ");
        tv.setMarca(sc.nextLine());
        System.out.println("Tamaño: ");
        tv.setTamanyo(Double.parseDouble(sc.nextLine()));

        return tv;
    }

    private Televisor.tipoTelevisor pedirTipoTv() {
        Televisor.tipoTelevisor tipoTv = null;
        String opcion;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Tipo de pantalla");
            System.out.println("1.Plasma");
            System.out.println("2.Led");
            System.out.println("3.LCD");
            System.out.println("4.OLED");

            opcion = sc.nextLine();

        } while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4"));

        if (opcion.equals("1")) {
            tipoTv = Televisor.tipoTelevisor.PLASMA;
        }
        if (opcion.equals("2")) {
            tipoTv = Televisor.tipoTelevisor.LED;
        }
        if (opcion.equals("3")) {
            tipoTv = Televisor.tipoTelevisor.LCD;
        }
        if (opcion.equals("4")) {
            tipoTv = Televisor.tipoTelevisor.OLED;
        }
        return tipoTv;
    }

    private Mueble.Madera pedirMadera() {
        Mueble.Madera m = null;
        String opcion;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduzca el tipo de Madera");
            System.out.println("1.Pino");
            System.out.println("2.Roble");
            System.out.println("3.Haya");

            opcion = sc.nextLine();

        } while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3"));

        if (opcion.equals("1")) {
            m = Mueble.Madera.PINO;
        }
        if (opcion.equals("2")) {
            m = Mueble.Madera.ROBLE;
        }
        if (opcion.equals("3")) {
            m = Mueble.Madera.HAYA;
        }
        return m;
    }

    private void menuClientes() {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        int numCliente;

        try {
            int opcionClientes = -1;
            do {
                System.out.println("1.Introducir Cliente");
                System.out.println("2.Dar de baja un cliente");
                System.out.println("3.Imprimir los datos de un cliente");
                System.out.println("4.Imprimir todos los clientes");
                System.out.println("0. Salir del menu");

                opcionClientes = sc.nextInt();
                if (opcionClientes == 1) {
                    Cliente c = datosClientes();
                    servicio.introducirCliente(c);
                }
                if (opcionClientes == 2) {
                    System.out.println("Introduzca el número del cliente: ");
                    numCliente = sc.nextInt();
                    servicio.eliminarCliente(numCliente);
                }
                if (opcionClientes == 3) {
                    System.out.println("Introduzca el número del cliente: ");
                    numCliente = sc.nextInt();
                    System.out.println(servicio.buscarCliente(numCliente).imprimir());

                }
                if (opcionClientes == 4) {
                    System.out.println(servicio.imprimirTodosClientes());
                }

            } while (opcionClientes != 0);
        } catch (Exception e) {
            System.out.println("Opcion no valida");
            this.menuClientes();
        }

    }

    public Cliente datosClientes() throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        Cliente clienteIntro = null;
        String nombre, razonSocial;
        String opcionClientesString;
        opcionClientesString = "-1";
        int opcionClientes = -1;

        do {
            System.out.println("Introduce los datos");
            System.out.println("Nombre: ");
            nombre = sc.nextLine();

            System.out.println("Razon social: ");
            razonSocial = sc.nextLine();

            System.out.println("Seleccione ");

            System.out.println("1. Mayorista");
            System.out.println("2. Particular");

            opcionClientes = teclado.nextInt();
            System.out.println(opcionClientes);
            opcionClientesString = String.valueOf(opcionClientes);

            if ("1".equals(opcionClientesString)) {

                clienteIntro = introMayorista();
            }
            if ("2".equals(opcionClientesString)) {
                clienteIntro = introParticular();
            }
            if (clienteIntro != null) {
                clienteIntro.setNombre(nombre);
                clienteIntro.setRazonSocial(razonSocial);

            }

        } while (!"1".equals(opcionClientesString) && !"2".equals(opcionClientesString));
        return clienteIntro;
    }

    public Cliente introMayorista() {
        Mayorista m = new Mayorista();
        Scanner sc = new Scanner(System.in);
        String cif, tipo, descuS;
        double descu;

        System.out.println("Introduce tu cif ");
        cif = sc.nextLine();
        m.setCif(cif);
        System.out.println("Tipo Mayorista ");
        TipoMayorista[] tipos = TipoMayorista.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println(tipos[i]);
        }
        tipo = sc.nextLine().toUpperCase();
        m.setTipoMayorista(TipoMayorista.valueOf(tipo));
        System.out.println("Descuento ");
        descuS = sc.nextLine();
        descu = Double.parseDouble(descuS);
        m.setDescuento(descu);

        return m;
    }

    public Cliente introParticular() {
        Scanner sc = new Scanner(System.in);
        boolean iguales = true;
        Particular p = new Particular();
        String dniIntro = "";

        do {
            try {

                System.out.println("Introduce un DNI");
                dniIntro = sc.nextLine();

                if (9 != dniIntro.length()) {

                    throw new NullPointerException("demo");
                } else if (!dniIntro.equalsIgnoreCase(comprobarDNI(dniIntro))) {

                    throw new Exception();
                } else {
                    iguales = false;
                }
            } catch (NullPointerException e) {

                System.out.println("Tamaño insuficiente o grande");

            } catch (Exception error) {
                System.out.println("No son iguales");

            }

        } while (iguales == true);

        p.setDni(dniIntro);

        return p;

    }

    public String comprobarDNI(String dniIntro) {
        String letraDni, dniNumero, juegoCaracteres;
        int dniNumeroInt, modulo;
        char letra;
        boolean iguales = true;
        String dniTotal = "";

        //Sacamos la letra dni
        letraDni = dniIntro.substring(8, 9);

        //Sacamos el numero del dni        
        dniNumero = dniIntro.substring(0, 8);
        //letras dni
        juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";

        //pasamos el numero deni a int
        dniNumeroInt = Integer.parseInt(dniNumero);
        //calculo dni
        modulo = dniNumeroInt % 23;

        //sacamos la letra del string juegoCaracteres 
        //y los pasamos a string
        letra = juegoCaracteres.charAt(modulo);
        String letraString = String.valueOf(letra);

        dniTotal = String.valueOf(dniNumeroInt + "" + letra);
        System.out.println(dniTotal);

        return dniTotal;

    }

    private void menuVentas() {
        Scanner sc = new Scanner(System.in);
        boolean existen = false;
        int nv = 0, np = 0;
        try {
            String opcionVentas = "-1";
            do {
                System.out.println("1.Introducir Venta");
                System.out.println("2.Dar de baja una venta");
                System.out.println("3.Imprimir los datos de una venta");
                System.out.println("4.Imprimir todas las ventas");
                System.out.println("0. Salir del menu");
                opcionVentas = sc.nextLine();

                if (opcionVentas.equals("1")) {
                    do {

                        System.out.println("Introduce el número de cliente.");
                        nv = Integer.parseInt(sc.nextLine());
                        if (servicio.buscarCliente(nv) == null) {
                            existen = true;
                        }

                        System.out.println("Introduce el número de producto.");
                        np = Integer.parseInt(sc.nextLine());

                        if (servicio.buscarProducto(np) == null) {
                            existen = true;
                        }
                    } while (existen = false);

                    System.out.println("Introduce el nombre del vendedor: ");
                    String v = sc.nextLine();
                    servicio.introducirVenta(nv, np, v);
                }
                if (opcionVentas.equals("2")) {
                    System.out.println("Introduzca número de venta: ");
                    nv = Integer.parseInt(sc.nextLine());
                    servicio.eliminarVenta(nv);
                }
                if (opcionVentas.equals("3")) {
                    System.out.println("Introduzca número de venta: ");
                    nv = Integer.parseInt(sc.nextLine());
                    System.out.println(servicio.buscarVenta(nv).imprimirVenta());
                    
                }
                if (opcionVentas.equals("4")) {
                    System.out.println(servicio.imprimirtodasVentas());
                }

            } while (!opcionVentas.equals("0"));

        } catch (Exception e) {
            System.out.println("Opcion no valida");
            this.menuVentas();
        }

    }

    private LocalDate validarFecha(String fecha) {

        LocalDate fec = null;

        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MMMM-yy", new Locale("es", "ES"));

        LocalDate sdf;
        try {

            fec = LocalDate.parse(fecha, formatear);

        } catch (DateTimeParseException e) {
            throw new FormatoFechaErroneo();
        }

        return fec;
    }

}

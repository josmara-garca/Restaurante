import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Restaurante {

    Scanner sc = new Scanner(System.in);
    int opcion;

    public void iniciar (){
        mostrarMenu();
    }


        private void mostrarMenu () {
            System.out.println("1- Crear producto");
            System.out.println("2- Crear pedido");
            System.out.println("3- Crear mesa");
            System.out.println("4- Añadir producto a pedido");
            System.out.println("5- Añadir pedido a mesa");
            System.out.println("6- Salir");
            ejecutarOpcion();

        }

        private void ejecutarOpcion (){

            do {
                System.out.print("elije opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        crearProducto();
                        break;
                    case 2:
                        crearPedido();
                        break;
                    case 3:
                        crearMesa ();
                        break;
                    case 4:
                        añadirProductoPedido();
                        break;
                    case 5:
                        añadirPedidoMesa ();
                        break;
                    case 6:
                        salir();
                        break;
                    default:
                        System.out.println("opcion incorrecta, entre 1 y 5");
                        System.out.println("elija otra");

                }

            } while (opcion != 6);
        }

        private void crearProducto () {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root","");
                System.out.print("id del producto: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("precio: ");
                double precio = sc.nextDouble();
                sc.nextLine();
                System.out.print("nombre: ");
                String nombre = sc.nextLine();
                PreparedStatement ps = conn.prepareStatement ("insert into producto (id,precio,nombre) values (?,?,?)");
                ps.setInt(1, id);
                ps.setDouble(2,precio);
                ps.setString(3,nombre);
                ps.executeUpdate();


            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        private void crearPedido () {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.print("id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("total: ");
            double total = sc.nextDouble();
            sc.nextLine();
            PreparedStatement ps = conn.prepareStatement("insert into pedido (id, total) values (?,?)");
            ps.setInt(1,id);
            ps.setDouble(2,total);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        }

        private void añadirProductoPedido () {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.print("id_producto: ");
            int id_producto = sc.nextInt();
            sc.nextLine();
            System.out.print("id_pedido: ");
            int id_pedido = sc.nextInt();
            sc.nextLine();
            System.out.print("unidades: ");
            int unidades = sc.nextInt();
            sc.nextLine();
            PreparedStatement ps = conn.prepareStatement("insert into producto_pedido (id_producto,id_pedido,unidades) values (?,?,?)");
            ps.setInt(1,id_producto);
            ps.setInt(2,id_pedido);
            ps.setInt(3,unidades);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        }

        private void añadirPedidoMesa (){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.print("id_pedido: ");
            int id_pedido = sc.nextInt();
            sc.nextLine();
            System.out.print("mesa: ");
            int mesa = sc.nextInt();
            sc.nextLine();
            PreparedStatement ps = conn.prepareStatement("insert into pedido_mesa (id_pedido, mesa) values (?.?)");
            ps.setInt(1,id_pedido);
            ps.setInt(2,mesa);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        }

        private void salir () {

        }

        private void crearMesa (){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
            System.out.print("Crea numero de mesa: ");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.print("¿Ocupada?: ");
            int ocupada = sc.nextInt();
            sc.nextLine();
            PreparedStatement ps = conn.prepareStatement("insert into mesa (numero, ocupada) values (?,?)");
            ps.setInt(1,numero);
            ps.setInt(2,ocupada);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        }
    }


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
            System.out.println("3- Añadir producto a pedido");
            System.out.println("4- Salir");
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
                        añadirProductoPedido();
                    case 4:
                        salir();
                        break;
                    default:
                        System.out.println("opcion incorrecta, entre 1 y 4");
                        System.out.println("elija otra");

                }

            } while (opcion != 4);
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


        }

        private void añadirProductoPedido () {

        }

        private void salir () {

        }
    }


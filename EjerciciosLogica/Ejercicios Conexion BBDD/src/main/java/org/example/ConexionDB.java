package org.example;


import java.sql.*;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa2";
    private static final String USER = "root";
    private static final String PASSWD = "1234";


    public static void main(String[] args) {

       listarEmpleadosConDepartamento();

        System.out.println("Consulta 1");
       listarEmpleadosConTodosSusDatos();

        System.out.println("Consulta 2");
        listarEmpleadosConSalarioMayor1400();

        System.out.println("Consulta 3");
        listarEmpleadosOrdenadosPorNombre();

        System.out.println("Consulta 4");
        listarEmpleadosOrdenadosPorSalarioDeMayorAMenor();

        System.out.println("Nivel 2");
        System.out.println("Consulta1");
        listarEmpleadosSalarioEntre1300Y1700();

        System.out.println("Consulta 2");
        listarEmpleadosCuyoNombreEmpiecePorA();

        System.out.println("Consulta 3");
        listarEmpleadosCuyoNombreContengaLaA();

        System.out.println("Consulta 4");
        listarEmpleadosCuyoIdDepartamentoIgual2();

        System.out.println("Consulta 5");
        listarEmpleadosconSalarioMayor1500YDepartamento2();

    }

    private static void listarEmpleadosconSalarioMayor1500YDepartamento2() {

        String sql = """
                SELECT nombre, salario, id_departamento from empleado WHERE salario>1500 AND id_departamento=2
                """;
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ) {

            System.out.println("Empleados con salario mayor a 1500 y departamento2");
            System.out.println("Nombre|Salario|id_departamento");
            while (rs.next()){
                String nombre= rs.getString("nombre");
                double salario = rs.getDouble("salario");
                Long id_departamento=rs.getLong("id_departamento");

                System.out.println(nombre+" "+salario+" "+id_departamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        private static void listarEmpleadosCuyoIdDepartamentoIgual2() {
        String sql = """
                SELECT nombre, id_departamento from empleado WHERE id_departamento=2
                """;

        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){

            System.out.println("Empleados con id_departamento=2");
            System.out.println("Nombre|id_departamento");
            while (rs.next()){
                String nombre = rs.getString("nombre");
                Long id_departamento= rs.getLong("id_departamento");

                System.out.println(nombre+" "+id_departamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listarEmpleadosCuyoNombreContengaLaA() {
        String sql= """
                SELECT nombre from empleado WHERE nombre LIKE '%a%'
                """;
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            System.out.println("Solo empleados que contengan la letra a");
            System.out.println("Nombre:");
            while (rs.next()){
                String nombre = rs.getString("nombre");

                System.out.println(nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listarEmpleadosCuyoNombreEmpiecePorA() {
        String sql= """
                SELECT nombre from empleado WHERE nombre LIKE 'A%'
                """;
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            System.out.println("Solo empleados que empiecen por letra A");
            System.out.println("Nombre:");
            while (rs.next()){
                String nombre = rs.getString("nombre");

                System.out.println(nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listarEmpleadosSalarioEntre1300Y1700() {

        String sql= """
                SELECT nombre ,salario FROM empleado WHERE salario BETWEEN 1300 AND 1700
                """;

        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            System.out.println("Empleados con salario entre 1300 y 1700");
            System.out.println("Nombre|Salario");
            while (rs.next()){
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");

                System.out.println(nombre+" "+salario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listarEmpleadosOrdenadosPorSalarioDeMayorAMenor() {
        String sql= """
                SELECT nombre, salario from empleado ORDER BY salario desc
                """;

        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
            System.out.println("Sacar empleados ordenados por salario de mayor a menor");
            System.out.println("Nombre|Salario");
            while (rs.next()){
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");

                System.out.println(nombre+" "+salario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void listarEmpleadosOrdenadosPorNombre(){
        String sql = """
                SELECT * FROM empleado ORDER BY nombre
                """;

        try (Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){

            System.out.println("Sacamos los empleador ordenados por orden alfabetico");
            System.out.println("Id||Nombre||Salario||id_departamento");
            while (rs.next()){
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                Long id_departamento = rs.getLong("id_departamento");

                System.out.println(id+" "+nombre+" "+salario+" "+id_departamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void listarEmpleadosConSalarioMayor1400(){
        String sql= """
                SELECT nombre, salario from empleado WHERE salario>1400
                """;

        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
            System.out.println("Sacamos empleados con salario mayor de 1400");
            System.out.println("Nombre | | Salario");
            while (rs.next()){
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");

                System.out.println(nombre+" "+salario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void listarEmpleadosConTodosSusDatos(){
        String sql= """
                SELECT nombre , salario FROM empleado
                """;
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery()){

            System.out.println("Vamos a sacar a todos los empleados , su nombre y salario");
            System.out.println("Nombre | | Salario");
            while (rs.next()){
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");

                System.out.println(nombre+" "+salario);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void listarEmpleadosConDepartamento(){
        String sql = """
            SELECT e.nombre AS nombreEmpleado,
                   e.salario,
                   d.nombre AS nombreDepartamento
            FROM empleado e
            JOIN departamento d ON e.id_departamento = d.id
        """;


        try(Connection con = DriverManager.getConnection(URL,USER,PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            System.out.println("Conexión a la base de datos con éxito");
            System.out.println("Vamos a sacar a los empleados , con su nombre salario y a que departamento pertenecen.");


            while (rs.next()){
                String nombre = rs.getString("nombreEmpleado");
                double salario = rs.getDouble("salario");
                String idDep = rs.getString("nombreDepartamento");

                System.out.println(nombre+" "+salario+" "+idDep);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

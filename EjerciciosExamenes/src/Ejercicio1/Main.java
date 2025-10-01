package Ejercicio1;

import Ejercicio1.modelo.Producto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class Main {
    public static void main(String[] args) {

        Producto producto1 = new Producto(1,"Tablet",210.0,true,'A');
        Producto producto2 = new Producto(2,"Movil",300.0,false,'A');
        Producto producto3 = new Producto(3,"Ratón",21.0,true,'B');
        Producto producto4 = new Producto(4,"Teclado",30.0,false,'D');
        Producto producto5 = new Producto(5,"Mesa",70.0,true,'C');

        List<Producto> productos= new ArrayList<>(List.of(producto1,producto2,producto3,producto4,producto5));

        RandomAccessFile raf;{
            try {
                raf = new RandomAccessFile("archivo.dat", "rw");
                for (Producto producto: productos){
                    raf.writeInt(producto.getId());

                    String nombreAjustado= ajustarNombre(producto.getNombre());
                    raf.writeChars(nombreAjustado);
                    raf.writeDouble(producto.getPrecio());
                    raf.writeBoolean(producto.getDescuento());
                    raf.writeChar(producto.getTipo());
                }
                raf.seek(0);
                while (raf.getFilePointer()< raf.length()){
                    int id= raf.readInt();
                    char[] nombreChars= new char[10];
                    for (int i = 0; i < 10; i++) {
                        nombreChars[i]= raf.readChar();
                    }
                    String nombre = new String(nombreChars).trim();
                    double precio = raf.readDouble();
                    boolean descuento= raf.readBoolean();
                    char tipo = raf.readChar();

                    System.out.println(id+ " - "+nombre+" - "+precio+" - "+descuento+" - "+tipo);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    private static String ajustarNombre(String nombre) {
        if (nombre.length() > 10) {
            return nombre.substring(0, 10); // corta si es demasiado largo
        } else {
            return String.format("%-10s", nombre); // rellena con espacios si es corto
        }
    }






}

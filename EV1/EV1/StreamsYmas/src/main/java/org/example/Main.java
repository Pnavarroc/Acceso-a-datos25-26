package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}

/*
    Cliente:
    id
    nif
    nombre
    ciudad

    Vehiculo:
    id
    matricula
    marca
    modelo
    precioDia

    Many2one
    JoinColumn(name = "sucursal_id")
    sucursal

    Alquiler:
    id
    fechaInicio
    fechaFin
    precioTotal

    Many2one
    JoinColumn(name = " cliente_id ")
    cliente

    Many2one
    JoinColumn(name = " vehiculo_id ")
    vehiculo


    Sucursal:
    id
    nombre
    ciudad

*/
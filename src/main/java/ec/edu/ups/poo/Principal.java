package ec.edu.ups.poo;

import ec.edu.ups.poo.Models.Compra;
import ec.edu.ups.poo.Models.Producto;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Compra carrito = new Compra();

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese código: ");
            String codigo = leer.nextLine();

            System.out.print("Ingrese nombre del producto: ");
            String nombre = leer.nextLine();

            System.out.print("Ingrese precio: ");
            double precio = Double.parseDouble(leer.nextLine());

            System.out.print("Ingrese cantidad: ");
            int cantidad = Integer.parseInt(leer.nextLine());


            }
        }
    }

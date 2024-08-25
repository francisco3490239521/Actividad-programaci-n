package com.empleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEmpleados {
    private List<Empleado> empleados = new ArrayList<>();
    private int nextId = 1;

    public void registrarEmpleado(String nombre, String puesto, double salarioBase, LocalDate fechaIngreso, String departamento) {
        Empleado empleado = new Empleado(nextId++, nombre, puesto, salarioBase, fechaIngreso, departamento);
        empleados.add(empleado);
        System.out.println("Empleado registrado con éxito: " + empleado);
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    public void darDeBajaEmpleado(int id) {
        Empleado empleado = buscarEmpleadoPorId(id);
        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado dado de baja con éxito.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public Empleado buscarEmpleadoPorId(int id) {
        return empleados.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestión de Empleados");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Dar de baja empleado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Puesto: ");
                    String puesto = scanner.next();
                    System.out.print("Salario Base: ");
                    double salarioBase = scanner.nextDouble();
                    System.out.print("Fecha de Ingreso (AAAA-MM-DD): ");
                    LocalDate fechaIngreso = LocalDate.parse(scanner.next());
                    System.out.print("Departamento: ");
                    String departamento = scanner.next();
                    gestor.registrarEmpleado(nombre, puesto, salarioBase, fechaIngreso, departamento);
                    break;
                case 2:
                    gestor.listarEmpleados();
                    break;
                case 3:
                    System.out.print("ID del empleado a dar de baja: ");
                    int id = scanner.nextInt();
                    gestor.darDeBajaEmpleado(id);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}

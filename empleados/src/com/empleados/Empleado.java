package com.empleados;

import java.time.LocalDate;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private double salarioBase;
    private LocalDate fechaIngreso;
    private String departamento;
    private double igss;
    private double irtra;
    private double deducciones;

    public Empleado(int id, String nombre, String puesto, double salarioBase, LocalDate fechaIngreso, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salarioBase = salarioBase;
        this.fechaIngreso = fechaIngreso;
        this.departamento = departamento;
        calcularDeducciones();
    }

    private void calcularDeducciones() {
        this.igss = this.salarioBase * 0.0483; // Ejemplo: 4.83% del salario base
        this.irtra = this.salarioBase * 0.01;  // Ejemplo: 1% del salario base
        this.deducciones = this.igss + this.irtra;
    }

    public double calcularBonificacion(double porcentaje) {
        return this.salarioBase * (porcentaje / 100);
    }

    // Getters y Setters

    @Override
    public String toString() {
        return "Empleado{" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Puesto='" + puesto + '\'' +
                ", Salario Base=" + salarioBase +
                ", Fecha de Ingreso=" + fechaIngreso +
                ", Departamento='" + departamento + '\'' +
                ", IGSS=" + igss +
                ", IRTRA=" + irtra +
                ", Deducciones=" + deducciones +
                '}';
    }

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}

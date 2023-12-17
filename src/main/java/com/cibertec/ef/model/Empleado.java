package com.cibertec.ef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Table(name = "empleado")
@Entity
@Getter
@Setter
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "salario")
    private Double salario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_ingreso")
    private Date fecha_ingreso;

    @Column(name = "departamento")
    private String departamento;

}

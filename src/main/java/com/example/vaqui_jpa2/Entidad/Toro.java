package com.example.vaqui_jpa2.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_toro")
public class Toro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_toros;

    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_extraccion;

    @Column(nullable = false)
    private int vacas_montadas;

    @Column(name = "fecha_revision",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_revision;
    @Column(nullable = false, length = 20)
    private String categoria;

    public Toro(Integer codigo, General id_toros, Double peso_kilos, LocalDate fecha_extraccion, int vacas_montadas, LocalDate fecha_revision, String categoria) {
        this.codigo = codigo;
        this.id_toros = id_toros;
        this.peso_kilos = peso_kilos;
        this.fecha_extraccion = fecha_extraccion;
        this.vacas_montadas = vacas_montadas;
        this.fecha_revision = fecha_revision;
        this.categoria = categoria;
    }

    public Toro(General id_toros, Double peso_kilos, LocalDate fecha_extraccion, int vacas_montadas, LocalDate fecha_revision, String categoria) {
        this.id_toros = id_toros;
        this.peso_kilos = peso_kilos;
        this.fecha_extraccion = fecha_extraccion;
        this.vacas_montadas = vacas_montadas;
        this.fecha_revision = fecha_revision;
        this.categoria = categoria;
    }

    public Toro() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public General getId_toros() {
        return id_toros;
    }

    public void setId_toros(General id_toros) {
        this.id_toros = id_toros;
    }

    public Double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(Double peso_kilos) {
        this.peso_kilos = peso_kilos;
    }

    public LocalDate getFecha_extraccion() {
        return fecha_extraccion;
    }

    public void setFecha_extraccion(LocalDate fecha_extraccion) {
        this.fecha_extraccion = fecha_extraccion;
    }

    public int getVacas_montadas() {
        return vacas_montadas;
    }

    public void setVacas_montadas(int vacas_montadas) {
        this.vacas_montadas = vacas_montadas;
    }

    public LocalDate getFecha_revision() {
        return fecha_revision;
    }

    public void setFecha_revision(LocalDate fecha_revision) {
        this.fecha_revision = fecha_revision;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Toro{" +
                "codigo=" + codigo +
                ", id_toros=" + id_toros +
                ", peso_kilos=" + peso_kilos +
                ", fecha_extraccion=" + fecha_extraccion +
                ", vacas_montadas=" + vacas_montadas +
                ", fecha_revision=" + fecha_revision +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

package com.example.vaqui_jpa2.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_ternero")
public class Ternero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_terneros;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_madre", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_madre;

    @Column(nullable = false)
    private Double peso_kilos;

    @Column(name = "fecha_revision",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_revision;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Ternero(Integer codigo, General id_terneros, General id_madre, Double peso_kilos, LocalDate fecha_revision, String categoria) {
        this.codigo = codigo;
        this.id_terneros = id_terneros;
        this.id_madre = id_madre;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.categoria = categoria;
    }

    public Ternero(General id_terneros, General id_madre, Double peso_kilos, LocalDate fecha_revision, String categoria) {
        this.id_terneros = id_terneros;
        this.id_madre = id_madre;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.categoria = categoria;
    }

    public Ternero() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public General getId_terneros() {
        return id_terneros;
    }

    public void setId_terneros(General id_terneros) {
        this.id_terneros = id_terneros;
    }

    public General getId_madre() {
        return id_madre;
    }

    public void setId_madre(General id_madre) {
        this.id_madre = id_madre;
    }

    public Double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(Double peso_kilos) {
        this.peso_kilos = peso_kilos;
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
        return "Ternero{" +
                "codigo=" + codigo +
                ", id_terneros=" + id_terneros +
                ", id_madre=" + id_madre +
                ", peso_kilos=" + peso_kilos +
                ", fecha_revision=" + fecha_revision +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

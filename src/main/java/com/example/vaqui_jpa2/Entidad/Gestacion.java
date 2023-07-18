package com.example.vaqui_jpa2.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_gestacion")
public class Gestacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_gestacion;
    @Column(nullable = false)
    private Double peso_kilos;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_inseminacion;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_aprox_parto;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_ultimo_parto;
    @Column(name = "fecha_revision",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_revision;
    @Column(nullable = false, length = 20)
    private String categoria;

    public Gestacion(Integer codigo, General id_gestacion, Double peso_kilos, LocalDate fecha_inseminacion, LocalDate fecha_aprox_parto, LocalDate fecha_ultimo_parto, LocalDate fecha_revision, String categoria) {
        this.codigo = codigo;
        this.id_gestacion = id_gestacion;
        this.peso_kilos = peso_kilos;
        this.fecha_inseminacion = fecha_inseminacion;
        this.fecha_aprox_parto = fecha_aprox_parto;
        this.fecha_ultimo_parto = fecha_ultimo_parto;
        this.fecha_revision = fecha_revision;
        this.categoria = categoria;
    }

    public Gestacion(General id_gestacion, Double peso_kilos, LocalDate fecha_inseminacion, LocalDate fecha_aprox_parto, LocalDate fecha_ultimo_parto, LocalDate fecha_revision, String categoria) {
        this.id_gestacion = id_gestacion;
        this.peso_kilos = peso_kilos;
        this.fecha_inseminacion = fecha_inseminacion;
        this.fecha_aprox_parto = fecha_aprox_parto;
        this.fecha_ultimo_parto = fecha_ultimo_parto;
        this.fecha_revision = fecha_revision;
        this.categoria = categoria;
    }

    public Gestacion() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public General getId_gestacion() {
        return id_gestacion;
    }

    public void setId_gestacion(General id_gestacion) {
        this.id_gestacion = id_gestacion;
    }

    public Double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(Double peso_kilos) {
        this.peso_kilos = peso_kilos;
    }

    public LocalDate getFecha_inseminacion() {
        return fecha_inseminacion;
    }

    public void setFecha_inseminacion(LocalDate fecha_inseminacion) {
        this.fecha_inseminacion = fecha_inseminacion;
    }

    public LocalDate getFecha_aprox_parto() {
        return fecha_aprox_parto;
    }

    public void setFecha_aprox_parto(LocalDate fecha_aprox_parto) {
        this.fecha_aprox_parto = fecha_aprox_parto;
    }

    public LocalDate getFecha_ultimo_parto() {
        return fecha_ultimo_parto;
    }

    public void setFecha_ultimo_parto(LocalDate fecha_ultimo_parto) {
        this.fecha_ultimo_parto = fecha_ultimo_parto;
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
        return "Gestacion{" +
                "codigo=" + codigo +
                ", id_gestacion=" + id_gestacion +
                ", peso_kilos=" + peso_kilos +
                ", fecha_inseminacion=" + fecha_inseminacion +
                ", fecha_aprox_parto=" + fecha_aprox_parto +
                ", fecha_ultimo_parto=" + fecha_ultimo_parto +
                ", fecha_revision=" + fecha_revision +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

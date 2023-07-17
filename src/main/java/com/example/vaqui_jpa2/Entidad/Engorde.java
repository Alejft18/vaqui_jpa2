package com.example.vaqui_jpa2.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_engorde")
public class Engorde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_engorde;

    @Column(nullable = false)
    private Double peso_kilos;
    @Column(name ="fecha_revision" ,nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_revision;
    @Column(nullable = false, length = 50)
    private String alimento;
    @Column(nullable = false, length = 20)
    private String categoria;

    public Engorde(General id_engorde, Double peso_kilos, LocalDate fecha_revision, String alimento, String categoria) {
        this.id_engorde = id_engorde;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.alimento = alimento;
        this.categoria = categoria;
    }

    public Engorde(Integer codigo, General id_engorde, Double peso_kilos, LocalDate fecha_revision, String alimento, String categoria) {
        this.codigo = codigo;
        this.id_engorde = id_engorde;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.alimento = alimento;
        this.categoria = categoria;
    }

    public Engorde() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public General getId_engorde() {
        return id_engorde;
    }

    public void setId_engorde(General id_engorde) {
        this.id_engorde = id_engorde;
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

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Engorde{" +
                "codigo=" + codigo +
                ", id_engorde=" + id_engorde +
                ", peso_kilos=" + peso_kilos +
                ", fecha_revision=" + fecha_revision +
                ", alimento='" + alimento + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }


}

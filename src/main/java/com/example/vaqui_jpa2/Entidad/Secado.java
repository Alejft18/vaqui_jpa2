package com.example.vaqui_jpa2.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_secado")
public class Secado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_secado;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_ultimo_parto;

    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_revision;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_ordeno;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Secado(General id_secado, LocalDate fecha_ultimo_parto, Double peso_kilos, LocalDate fecha_revision, LocalDate fecha_ordeno, String categoria) {
        this.id_secado = id_secado;
        this.fecha_ultimo_parto = fecha_ultimo_parto;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.fecha_ordeno = fecha_ordeno;
        this.categoria = categoria;
    }

    public Secado(Integer codigo, General id_secado, LocalDate fecha_ultimo_parto, Double peso_kilos, LocalDate fecha_revision, LocalDate fecha_ordeno, String categoria) {
        this.codigo = codigo;
        this.id_secado = id_secado;
        this.fecha_ultimo_parto = fecha_ultimo_parto;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.fecha_ordeno = fecha_ordeno;
        this.categoria = categoria;
    }

    public Secado() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public General getId_secado() {
        return id_secado;
    }

    public void setId_secado(General id_secado) {
        this.id_secado = id_secado;
    }

    public LocalDate getFecha_ultimo_parto() {
        return fecha_ultimo_parto;
    }

    public void setFecha_ultimo_parto(LocalDate fecha_ultimo_parto) {
        this.fecha_ultimo_parto = fecha_ultimo_parto;
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

    public LocalDate getFecha_ordeno() {
        return fecha_ordeno;
    }

    public void setFecha_ordeno(LocalDate fecha_ordeno) {
        this.fecha_ordeno = fecha_ordeno;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Secado{" +
                "codigo=" + codigo +
                ", id_secado=" + id_secado +
                ", fecha_ultimo_parto=" + fecha_ultimo_parto +
                ", peso_kilos=" + peso_kilos +
                ", fecha_revision=" + fecha_revision +
                ", fecha_ordeno=" + fecha_ordeno +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

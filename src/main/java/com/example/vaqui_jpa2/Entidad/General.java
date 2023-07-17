package com.example.vaqui_jpa2.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tbl_general")
public class General {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 40)
    private String raza;
    @Column(nullable = false, length = 40)
    private String genero;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_nacimiento;
    @Column(nullable = false, length = 40)
    private String procedencia;

    @Column(length = 1000)
    private String imagen;

    @OneToOne(mappedBy = "id_lecheras", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Lechera lecheras;

    @OneToOne(mappedBy = "id_secado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Secado secado;

    @OneToOne(mappedBy = "id_gestacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Gestacion gestacion;

    @OneToOne(mappedBy = "id_terneros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Ternero ternero;

    @OneToMany(mappedBy = "id_madre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Ternero> id_madre;

    @OneToOne(mappedBy = "id_toros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Toro toro;

    @OneToOne(mappedBy = "id_engorde", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Engorde engorde;

    public General(int id, String raza, String genero, LocalDate fecha_nacimiento, String procedencia, String imagen) {
        this.id = id;
        this.raza = raza;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.procedencia = procedencia;
        this.imagen=imagen;
    }

    public General(String raza, String genero, LocalDate fecha_nacimiento, String procedencia, String imagen) {
        this.raza = raza;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.procedencia = procedencia;
        this.imagen = imagen;
    }

    public General() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Lechera getLecheras() {
        return lecheras;
    }

    public void setLecheras(Lechera lecheras) {
        this.lecheras = lecheras;
    }

    public Secado getSecado() {
        return secado;
    }

    public void setSecado(Secado secado) {
        this.secado = secado;
    }

    public Gestacion getGestacion() {
        return gestacion;
    }

    public void setGestacion(Gestacion gestacion) {
        this.gestacion = gestacion;
    }

    public Ternero getTernero() {
        return ternero;
    }

    public void setTernero(Ternero ternero) {
        this.ternero = ternero;
    }

    public Set<Ternero> getId_madre() {
        return id_madre;
    }

    public void setId_madre(Set<Ternero> id_madre) {
        this.id_madre = id_madre;
    }

    public Toro getToro() {
        return toro;
    }

    public void setToro(Toro toro) {
        this.toro = toro;
    }

    public Engorde getEngorde() {
        return engorde;
    }

    public void setEngorde(Engorde engorde) {
        this.engorde = engorde;
    }

    @Override
    public String toString() {
        return "General{" +
                "id=" + id +
                ", raza='" + raza + '\'' +
                ", genero='" + genero + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", procedencia='" + procedencia + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

}

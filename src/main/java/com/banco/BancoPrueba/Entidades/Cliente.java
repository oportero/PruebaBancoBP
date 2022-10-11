/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.BancoPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Cliente", 
       catalog = "PruebaBanco", 
       schema = "banco")
@PrimaryKeyJoinColumn(referencedColumnName = "personaId")
public class Cliente extends Persona implements Serializable {

    @Column(length = 30)
    private String clave;
    @Column(length = 30)
    private String estado;
    //Relacion de uno a muchos con entidad Cuenta
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId", fetch = FetchType.LAZY)
    private Set<Cuenta> cuentaSet;

    public Cliente() {
    }

    public Cliente(String clave, String estado, Long personaId, String direccion, int edad, Character genero, String identificacion, String nombre, String telefono) {
        super(personaId, direccion, edad, genero, identificacion, nombre, telefono);
        this.clave = clave;
        this.estado = estado;
    }

    public String getContrasenia() {
        return clave;
    }

    public void setContrasenia(String contrasenia) {
        this.clave = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Cuenta> getCuentaSet() {
        return cuentaSet;
    }

    public void setCuentaSet(Set<Cuenta> cuentaSet) {
        this.cuentaSet = cuentaSet;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clave=" + clave + ", estado=" + estado + ", cuentaSet=" + cuentaSet + '}';
    }
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.BancoPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(catalog = "PruebaBanco", schema = "banco", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numeroCuenta"})})

public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cuentaId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;
    @Basic(optional = false)
    @Column(name = "numeroCuenta", nullable = false, length = 100)
    private String numeroCuenta;
    @Basic(optional = false)
    @Column(name = "tipoCuenta", nullable = false, length = 50)
    private String tipoCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "saldoInicial", nullable = false, precision = 18, scale = 2)
    private BigDecimal saldoInicial;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String estado;

    @JoinColumn(name = "clienteId", referencedColumnName = "personaId", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("clienteId")
    private Cliente clienteId;
    
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaId", fetch = FetchType.LAZY)
    private Set<Movimientos> movimientosSet;

    public Cuenta() {
    }

    public Cuenta(Long cuentaId, String numeroCuenta, String tipoCuenta, BigDecimal saldoInicial, String estado, Cliente clienteId) {
        this.cuentaId = cuentaId;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.clienteId = clienteId;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

  


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getclienteId() {
        return clienteId;
    }

    public void setclienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Set<Movimientos> getMovimientosSet() {
        return movimientosSet;
    }

    public void setMovimientosSet(Set<Movimientos> movimientosSet) {
        this.movimientosSet = movimientosSet;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "cuentaId=" + cuentaId + ", numeroCuenta=" + numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", saldoInicial=" + saldoInicial + ", estado=" + estado + ", clienteId=" + clienteId + ", movimientosSet=" + movimientosSet + '}';
    }

}

package com.banco.BancoPrueba.Entidades;

import com.banco.BancoPrueba.Entidades.Cliente;
import com.banco.BancoPrueba.Entidades.Movimientos;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-10-11T08:35:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> estado;
    public static volatile SingularAttribute<Cuenta, Cliente> clienteId;
    public static volatile SingularAttribute<Cuenta, Long> cuentaId;
    public static volatile SetAttribute<Cuenta, Movimientos> movimientosSet;
    public static volatile SingularAttribute<Cuenta, String> tipoCuenta;
    public static volatile SingularAttribute<Cuenta, String> numeroCuenta;
    public static volatile SingularAttribute<Cuenta, BigDecimal> saldoInicial;

}
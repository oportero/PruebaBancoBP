package com.banco.BancoPrueba.Entidades;

import com.banco.BancoPrueba.Entidades.Cuenta;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-10-11T08:35:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Movimientos.class)
public class Movimientos_ { 

    public static volatile SingularAttribute<Movimientos, Long> movimientoId;
    public static volatile SingularAttribute<Movimientos, BigDecimal> valor;
    public static volatile SingularAttribute<Movimientos, Cuenta> cuentaId;
    public static volatile SingularAttribute<Movimientos, String> tipoMovimiento;
    public static volatile SingularAttribute<Movimientos, BigDecimal> saldo;
    public static volatile SingularAttribute<Movimientos, Date> fechaMovimiento;

}
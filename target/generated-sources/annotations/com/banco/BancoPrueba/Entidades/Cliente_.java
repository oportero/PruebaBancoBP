package com.banco.BancoPrueba.Entidades;

import com.banco.BancoPrueba.Entidades.Cuenta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-10-11T08:35:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Persona_ {

    public static volatile SetAttribute<Cliente, Cuenta> cuentaSet;
    public static volatile SingularAttribute<Cliente, String> clave;
    public static volatile SingularAttribute<Cliente, String> estado;

}
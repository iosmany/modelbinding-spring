package org.sample.demo.servicios;

import org.sample.demo.entidades.Cliente;
import org.sample.demo.peticiones.PeticionLogin;

public interface ClienteServicio {

    Cliente login(PeticionLogin peticion);
}
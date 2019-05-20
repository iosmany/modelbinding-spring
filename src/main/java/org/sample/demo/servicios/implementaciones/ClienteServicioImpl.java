package org.sample.demo.servicios.implementaciones;

import org.sample.demo.entidades.Cliente;
import org.sample.demo.peticiones.PeticionLogin;
import org.sample.demo.servicios.ClienteServicio;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Override
    public Cliente login(PeticionLogin peticion) {
        Cliente cliente = new Cliente();
        cliente.setEmail(peticion.getEmail());
        cliente.setNombre("Un nombre");
        return cliente;
    }

}
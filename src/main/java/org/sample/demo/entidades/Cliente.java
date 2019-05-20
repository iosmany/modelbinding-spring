package org.sample.demo.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

    private String email;
    private String nombre;
    private String password;

}
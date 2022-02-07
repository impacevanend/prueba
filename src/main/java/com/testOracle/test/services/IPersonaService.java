package com.testOracle.test.services;

import com.testOracle.test.entity.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> listarClientes();

    public Persona guardarCliente(Persona persona);

    public Persona personaId(Long id);

    public Persona actualizarCliente(Persona persona);

    public void eliminarCliente(Long id);

}

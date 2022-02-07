package com.testOracle.test.services;

import com.testOracle.test.entity.Persona;
import com.testOracle.test.repository.IPersonaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImplement implements IPersonaService {

    @Autowired
    IPersonaRespository iPersonaRespository;


    @Override
    public List<Persona> listarClientes() {
        return iPersonaRespository.findAll();
    }

    @Override
    public Persona guardarCliente(Persona persona) {
        return iPersonaRespository.save(persona);
    }

    @Override
    public Persona personaId(Long id) {
        return iPersonaRespository.findById(id).get();
    }

    @Override
    public Persona actualizarCliente(Persona persona) {
        return iPersonaRespository.save(persona);
    }

    @Override
    public void eliminarCliente(Long id) {
         iPersonaRespository.deleteById(id);
    }
}

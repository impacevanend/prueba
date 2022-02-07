package com.testOracle.test.controller;


import com.testOracle.test.entity.Persona;
import com.testOracle.test.services.PersonaServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    PersonaServiceImplement imp;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-tables")
    public List<String> showTables() throws Exception {
        List<String> list = new ArrayList<String>();


        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});

        while(tables.next()){
            list.add(tables.getString("TABLE_NAME"));
        }


        return list;

    }

    @GetMapping("/list/clients")
    public List<Persona> listarClientes(){
        return imp.listarClientes();
    }


    @PostMapping("/save/client")
    public Persona guardarCliente(@RequestBody Persona persona) {
        return imp.guardarCliente(persona);
    }
/*
    @GetMapping("/client/{id}")
    public Persona clienteId(@PathVariable(name = "id") Long id) {
        Persona personaId = new Persona();
        personaId= imp.personaId(id);
        System.out.println("Cliente seleccionado fue: " + personaId);
        return personaId;
    }

    @PutMapping("/update/client/{id}")
    public Persona actualizarCliente(@PathVariable(name = "id") Long id, @RequestBody Persona persona) {
        Persona personaSelect = new Persona();
        Persona personaUpdate = new Persona();

        personaSelect = imp.personaId(id);
        personaSelect.setNombre(persona.getNombre());
        personaSelect.setApellido(persona.getApellido());
        personaSelect.setCorreo(persona.getCorreo());

        personaUpdate = imp.actualizarCliente(personaSelect);

        System.out.println("El cliente actualizado es: " +  personaUpdate);

        return  personaUpdate;
    }

    @DeleteMapping("/delete/client/{id}")
    public void personaDelete(@PathVariable(name = "id") Long id) {
        imp.eliminarCliente(id);
    }
*/
}

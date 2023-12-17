package com.cibertec.ef.service;

import com.cibertec.ef.model.Empleado;
import com.cibertec.ef.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll(){
        return (List<Empleado>) empleadoRepository.findAll();
    }

    public Empleado save(Empleado empleado){
        return empleadoRepository.save(empleado);
    }
}

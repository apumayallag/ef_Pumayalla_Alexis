package com.cibertec.ef.controller;

import com.cibertec.ef.model.Empleado;
import com.cibertec.ef.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empleado")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @PostMapping("/guardar")
    public ResponseEntity<Empleado> guardar(@RequestBody Empleado empleado){
        Empleado bean = empleadoService.save(empleado);
        return new ResponseEntity<>(bean, HttpStatus.CREATED);
    }

    @GetMapping("/reporte")
    public ResponseEntity<byte[]> reporte() throws JRException {

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(empleadoService.findAll());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("titulo", "Reporte de Empleados");
        JasperPrint jasperPrint = JasperFillManager.fillReport("src/main/resources/reportes/reporte.jasper", parameters, dataSource);

        byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("empleado.pdf").build());

        return ResponseEntity.ok()
                .headers(headers)
                .body(reporte);


    }
}

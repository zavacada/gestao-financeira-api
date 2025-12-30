package com.julio.gestao_financeira.domain.cambio;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cambio")
public class CambioController {

    private final CambioService service;

    public CambioController(CambioService service) {
        this.service = service;
    }

    @GetMapping("/converter")
    public BigDecimal converter(
            @RequestParam BigDecimal valor,
            @RequestParam String moeda
    ) {
        return service.converter(valor, moeda);
    }
}

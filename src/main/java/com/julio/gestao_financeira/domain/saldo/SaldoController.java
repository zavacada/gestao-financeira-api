package com.julio.gestao_financeira.domain.saldo;

import com.julio.gestao_financeira.domain.saldo.dto.SaldoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saldo")
public class SaldoController {

    private final SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @GetMapping("/usuarios/{usuarioId}")
    public SaldoDTO buscarSaldo(@PathVariable Long usuarioId) {
        return saldoService.buscarSaldo(usuarioId);
    }
}

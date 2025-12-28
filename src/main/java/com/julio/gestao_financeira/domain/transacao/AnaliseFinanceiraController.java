package com.julio.gestao_financeira.domain.transacao;

import com.julio.gestao_financeira.domain.transacao.dto.ResumoFinanceiroDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analises")
public class AnaliseFinanceiraController {

    private final AnaliseFinanceiraService service;

    public AnaliseFinanceiraController(AnaliseFinanceiraService service) {
        this.service = service;
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResumoFinanceiroDTO resumo(@PathVariable Long usuarioId) {
        return service.resumo(usuarioId);
    }
}

package com.julio.gestao_financeira.domain.transacao;

import com.julio.gestao_financeira.domain.transacao.dto.TransacaoRequestDTO;
import com.julio.gestao_financeira.domain.transacao.dto.TransacaoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping("/usuario/{usuarioId}")
    public TransacaoResponseDTO criar(
            @PathVariable Long usuarioId,
            @RequestBody @Valid TransacaoRequestDTO dto
    ) {
        return new TransacaoResponseDTO(service.criar(usuarioId, dto));
    }
}

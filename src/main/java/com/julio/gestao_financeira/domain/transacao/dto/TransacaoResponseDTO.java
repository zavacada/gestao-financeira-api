package com.julio.gestao_financeira.domain.transacao.dto;

import com.julio.gestao_financeira.domain.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoResponseDTO(
        Long id,
        String tipo,
        BigDecimal valor,
        String categoria,
        LocalDateTime data
) {
    public TransacaoResponseDTO(Transacao t) {
        this(
                t.getId(),
                t.getTipo().name(),
                t.getValor(),
                t.getCategoria(),
                t.getData()
        );
    }
}

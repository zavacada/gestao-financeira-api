package com.julio.gestao_financeira.domain.transacao.dto;

import java.math.BigDecimal;

public class ResumoFinanceiroDTO {

    private BigDecimal totalReceitas;
    private BigDecimal totalDespesas;

    public ResumoFinanceiroDTO(BigDecimal totalReceitas, BigDecimal totalDespesas) {
        this.totalReceitas = totalReceitas;
        this.totalDespesas = totalDespesas;
    }

    public BigDecimal getTotalReceitas() {
        return totalReceitas;
    }

    public BigDecimal getTotalDespesas() {
        return totalDespesas;
    }
}

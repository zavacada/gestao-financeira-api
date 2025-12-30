package com.julio.gestao_financeira.domain.cambio.dto;

import java.math.BigDecimal;

public class CotacaoDTO {

    private BigDecimal cotacao_compra;
    private BigDecimal cotacao_venda;

    public BigDecimal getCotacao_compra() {
        return cotacao_compra;
    }

    public void setCotacao_compra(BigDecimal cotacao_compra) {
        this.cotacao_compra = cotacao_compra;
    }

    public BigDecimal getCotacao_venda() {
        return cotacao_venda;
    }

    public void setCotacao_venda(BigDecimal cotacao_venda) {
        this.cotacao_venda = cotacao_venda;
    }
}

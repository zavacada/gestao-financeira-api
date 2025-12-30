package com.julio.gestao_financeira.domain.cambio.dto;

import java.math.BigDecimal;
import java.util.List;

public class CambioDTO {

    private String moeda;
    private List<CotacaoDTO> cotacoes;

    public String getMoeda() {
        return moeda;
    }
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
    public List<CotacaoDTO> getCotacoes() {
        return cotacoes;
    }
    public void setCotacoes(List<CotacaoDTO> cotacoes) {
        this.cotacoes = cotacoes;
    }
}

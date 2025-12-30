package com.julio.gestao_financeira.domain.saldo.dto;

import java.math.BigDecimal;

public class SaldoDTO {

    private Long usuarioId;
    private BigDecimal saldo;
    private String moeda;

    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    public String getMoeda() {
        return moeda;
    }
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
}

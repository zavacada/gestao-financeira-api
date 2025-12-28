package com.julio.gestao_financeira.domain.transacao;

import com.julio.gestao_financeira.domain.transacao.dto.ResumoFinanceiroDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AnaliseFinanceiraService {

    private final TransacaoRepository transacaoRepository;

    public AnaliseFinanceiraService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public ResumoFinanceiroDTO resumo(Long usuarioId) {
        BigDecimal receitas = transacaoRepository.totalReceitas(usuarioId);
        BigDecimal despesas = transacaoRepository.totalDespesas(usuarioId);

        return new ResumoFinanceiroDTO(receitas, despesas);
    }
}

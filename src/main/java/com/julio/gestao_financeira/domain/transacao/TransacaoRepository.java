package com.julio.gestao_financeira.domain.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query("""
        select coalesce(sum(t.valor), 0)
        from Transacao t
        where t.usuario.id = :usuarioId
        and t.tipo = 'DEPOSITO'
    """)
    BigDecimal totalReceitas(Long usuarioId);

    @Query("""
        select coalesce(sum(t.valor), 0)
        from Transacao t
        where t.usuario.id = :usuarioId
        and t.tipo <> 'DEPOSITO'
    """)
    BigDecimal totalDespesas(Long usuarioId);
}

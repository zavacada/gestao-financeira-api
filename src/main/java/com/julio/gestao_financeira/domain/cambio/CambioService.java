package com.julio.gestao_financeira.domain.cambio;

import com.julio.gestao_financeira.domain.cambio.dto.CambioDTO;
import com.julio.gestao_financeira.domain.cambio.dto.CotacaoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CambioService {

    private final RestTemplate restTemplate;

    private static final String URL =
            "https://brasilapi.com.br/api/cambio/v1/cotacao/";

    public CambioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BigDecimal converter(BigDecimal valor, String moeda) {

        String data = LocalDate.now().minusDays(1).toString(); // D-1

        CambioDTO dto = restTemplate.getForObject(
                URL + moeda + "/" + data,
                CambioDTO.class
        );

        if (dto == null || dto.getCotacoes() == null || dto.getCotacoes().isEmpty()) {
            throw new RuntimeException(
                    "Não foi possível obter cotação para a moeda " + moeda + " na data " + data
            );
        }

        CotacaoDTO cotacao = dto.getCotacoes().get(0);

        return valor.multiply(cotacao.getCotacao_venda());

    }


}

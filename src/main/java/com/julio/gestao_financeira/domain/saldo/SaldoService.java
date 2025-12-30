package com.julio.gestao_financeira.domain.saldo;

import com.julio.gestao_financeira.domain.saldo.dto.SaldoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaldoService {

    private final RestTemplate restTemplate;

    private static final String BASE_URL =
            "https://69534328a319a928023af5c7.mockapi.io/saldo/";

    public SaldoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SaldoDTO buscarSaldo(Long usuarioId) {
        return restTemplate.getForObject(
                BASE_URL + usuarioId,
                SaldoDTO.class
        );
    }
}

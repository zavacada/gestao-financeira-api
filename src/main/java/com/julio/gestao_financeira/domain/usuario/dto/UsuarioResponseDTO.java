package com.julio.gestao_financeira.domain.usuario.dto;

import com.julio.gestao_financeira.domain.usuario.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        Boolean ativo
) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAtivo()
        );
    }
}

package com.julio.gestao_financeira.domain.transacao;

import com.julio.gestao_financeira.domain.transacao.dto.TransacaoRequestDTO;
import com.julio.gestao_financeira.domain.usuario.Usuario;
import com.julio.gestao_financeira.domain.usuario.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;
    private final UsuarioService usuarioService;

    public TransacaoService(TransacaoRepository repository, UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    public Transacao criar(Long usuarioId, TransacaoRequestDTO dto) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);

        Transacao t = new Transacao();
        t.setTipo(dto.tipo());
        t.setValor(dto.valor());
        t.setCategoria(dto.categoria());
        t.setUsuario(usuario);
        t.setData(java.time.LocalDateTime.now());

        return repository.save(t);
    }
}

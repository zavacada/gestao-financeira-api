package com.julio.gestao_financeira.domain.usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários")
public class UsuarioController {

    private final UsuarioImportacaoService importacaoService;

    public UsuarioController(UsuarioImportacaoService importacaoService) {
        this.importacaoService = importacaoService;
    }

    @PostMapping(
            value = "/importar",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @Operation(summary = "Importar usuários via arquivo Excel")
    @RequestBody(
            content = @Content(
                    mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
                    schema = @Schema(type = "object", requiredProperties = {"file"})
            )
    )
    public String importarUsuarios(
            @RequestPart("file") MultipartFile file
    ) {
        int total = importacaoService.importar(file);
        return "Usuários importados com sucesso: " + total;
    }
}

package com.julio.gestao_financeira.domain.usuario;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class UsuarioImportacaoService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioImportacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public int importar(MultipartFile file) {
        int total = 0;

        try (InputStream is = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue; // pula cabeçalho
                }

                Cell cellNome = row.getCell(0);
                Cell cellEmail = row.getCell(1);
                Cell cellSenha = row.getCell(2);

                cellNome.setCellType(CellType.STRING);
                cellEmail.setCellType(CellType.STRING);
                cellSenha.setCellType(CellType.STRING);

                Usuario usuario = new Usuario();
                usuario.setNome(cellNome.getStringCellValue());
                usuario.setEmail(cellEmail.getStringCellValue());
                usuario.setSenha(cellSenha.getStringCellValue());
                usuario.setAtivo(true);

                usuarioRepository.save(usuario);
                total++;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao importar usuários");
        }

        return total;
    }
}

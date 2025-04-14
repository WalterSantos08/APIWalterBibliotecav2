package com.example.walterbiblioteca.service;

import com.example.walterbiblioteca.dtos.StatusDeLeituraDto;
import com.example.walterbiblioteca.mappers.StatusDeLeituraMapper;
import com.example.walterbiblioteca.models.StatusDeLeitura;
import com.example.walterbiblioteca.repositories.StatusDeLeituraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusDeLeituraService {

    private final StatusDeLeituraRepository statusRepository;

    public List<StatusDeLeituraDto> listarTodos() {
        return statusRepository.findAll()
                .stream()
                .map(StatusDeLeituraMapper::toDto)
                .toList();
    }

    public StatusDeLeituraDto buscarPorId(Integer id) {
        StatusDeLeitura status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));
        return StatusDeLeituraMapper.toDto(status);
    }

    public StatusDeLeituraDto salvar(StatusDeLeituraDto dto) {
        StatusDeLeitura entity = StatusDeLeituraMapper.toEntity(dto);
        StatusDeLeitura salvo = statusRepository.save(entity);
        return StatusDeLeituraMapper.toDto(salvo);
    }

    public StatusDeLeituraDto atualizar(Integer id, StatusDeLeituraDto dto) {
        StatusDeLeitura status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));
        status.setNome(dto.nome());
        return StatusDeLeituraMapper.toDto(statusRepository.save(status));
    }

    public void deletar(Integer id) {
        statusRepository.deleteById(id);
    }
}

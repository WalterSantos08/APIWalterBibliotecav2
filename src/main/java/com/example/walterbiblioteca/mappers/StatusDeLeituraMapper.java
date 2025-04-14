package com.example.walterbiblioteca.mappers;

import com.example.walterbiblioteca.dtos.StatusDeLeituraDto;
import com.example.walterbiblioteca.models.StatusDeLeitura;

public class StatusDeLeituraMapper {

    public static StatusDeLeituraDto toDto(StatusDeLeitura status) {
        return new StatusDeLeituraDto(status.getId(), status.getNome());
    }

    public static StatusDeLeitura toEntity(StatusDeLeituraDto dto) {
        StatusDeLeitura status = new StatusDeLeitura();
        status.setId(dto.id());
        status.setNome(dto.nome());
        return status;
    }
}

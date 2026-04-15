package com.notas.notas.domains.subjects.mapper;

import com.notas.notas.domains.subjects.dtos.request.CreateSubjectReqDTO;
import com.notas.notas.domains.subjects.dtos.response.SubjectResDTO;
import com.notas.notas.domains.subjects.persistence.entities.SubjectEntity;

public class SubjectMapper {
    public static SubjectEntity toEntityFrom(CreateSubjectReqDTO request) {
        return SubjectEntity.builder()
                .code(request.code())
                .name(request.name())
                .credits(request.credits())
                .build();
    }

    public static SubjectResDTO toResponseFrom(SubjectEntity entity) {
        return new SubjectResDTO(
                entity.getId(),
                entity.getName(),
                entity.getCode(),
                entity.getCredits(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

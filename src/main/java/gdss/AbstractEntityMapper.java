package gdss;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface AbstractEntityMapper<E extends AbstractEntity, D extends AbstractEntityDto> {

    D toDto(E entity);

    E toEntity(D dto);

    void updateDtoFromEntity(E entity, @MappingTarget D dto);

    void updateEntityFromDto(D dto, @MappingTarget E entity);

    List<D> toDtoList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);

    void updateDtoListFromEntityList(List<E> entityList, @MappingTarget List<D> dtoList);

    void updateEntityListFromDtoList(List<D> dtoList, @MappingTarget List<E> entityList);

}

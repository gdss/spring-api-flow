package gdss.example;

import gdss.AbstractEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ExampleUtilsMapper.class})
public interface ExampleMapper extends AbstractEntityMapper<Example, ExampleDto> {

}
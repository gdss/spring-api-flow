package gdss.example;

import gdss.AbstractEntityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "examples")
public class ExampleController extends AbstractEntityController<Example, ExampleDto, ExampleMapper, ExampleService> {

}

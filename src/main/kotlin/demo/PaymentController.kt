package demo

import com.github.victools.jsonschema.generator.*
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.ModelAndView

@Controller
class PaymentController {

    @GetMapping("/form/{country}")
    fun paymentForm(@PathVariable country: String): ModelAndView {
        println(country)

        val module = JavaxValidationModule(
            JavaxValidationOption.INCLUDE_PATTERN_EXPRESSIONS,
            JavaxValidationOption.NOT_NULLABLE_FIELD_IS_REQUIRED
        )
        val config: SchemaGeneratorConfig =
            SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module)
                .build()
        val generator = SchemaGenerator(config)
        val schema = generator.generateSchema(PaymentRequestDto::class.java).toString()
        return ModelAndView("test", mapOf("schema" to schema))
    }
}

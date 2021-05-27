package demo

import com.github.victools.jsonschema.generator.*
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
class PaymentController {

    @GetMapping("/form/{type}")
    fun paymentForm(@PathVariable type: String): ModelAndView {
        val module = JavaxValidationModule(
            JavaxValidationOption.INCLUDE_PATTERN_EXPRESSIONS,
            JavaxValidationOption.NOT_NULLABLE_FIELD_IS_REQUIRED
        )
        val config: SchemaGeneratorConfig =
            SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module)
                .build()
        val generator = SchemaGenerator(config)
        val schema = generator.generateSchema(
            if (type == "swift") SwiftBankAccount::class.java else LocalBankAccount::class.java
        ).toString()
        return ModelAndView("test", mapOf("schema" to schema))
    }

    @GetMapping("/bankaccount/{type}", produces = ["application/json"])
    @ResponseBody
    fun bankAccount(@PathVariable type: String): BankAccount {
        return when (type.toLowerCase()) {
            "swift" -> SwiftBankAccount()
            "local" -> LocalBankAccount()
            else -> TODO()
        }
    }
}

@Schema(
    type = "object",
    title = "BankAccount",
    subTypes = [SwiftBankAccount::class, LocalBankAccount::class]
)
abstract class BankAccount {
    val accountNumber: String = ""
}

class SwiftBankAccount : BankAccount() {
    val swiftCode: String = ""
}


class LocalBankAccount : BankAccount() {
    val bankCode: String = ""
}

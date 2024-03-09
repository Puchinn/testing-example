package testexample.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import testexample.app.services.PaymentService;

@RestController
@AllArgsConstructor
public class PaymentController {

    private static final String INTERNAL_SERVER_ERROR_MSG = "Internal Server Error";

    private final PaymentService paymentService;

    /**
     * Endpoint para procesamiento de pagos, donde intenta realizar el pago.
     * En caso de no poder realizarlo, responderemos una excepcion de tipo internal server error.
     * @param quantity cantidad a pagar.
     */
    @PostMapping("/payment")
    public void processPayment(@RequestBody String quantity) {
        try {
            paymentService.payment(Integer.valueOf(quantity));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    INTERNAL_SERVER_ERROR_MSG, e);
        }
    }

}
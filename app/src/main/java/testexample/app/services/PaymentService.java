package testexample.app.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Integer EXCESSIVE_QUANTITY = 100;

    /**
     * Metodo para procesamiento de pago, donde se valida si la cantidad es excesiva.
     * En caso de superar el monto, lanzara una excepcion de tipo IlegalArgumentException.
     * En caso de poder procesar el monto, se respondera un mensaje de que el pago fue realizado.
     * Con su respectivo monto.
     * @param quantity cantidad a pagar.
     */
    public void payment(Integer quantity) {
        if (quantity > EXCESSIVE_QUANTITY) {
            throw new IllegalArgumentException("Amount exceeds 100");
        }

        System.out.println("Processing payment of: " + quantity);
    }
}
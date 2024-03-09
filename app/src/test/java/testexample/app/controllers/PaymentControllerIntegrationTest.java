package testexample.app.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PaymentControllerIntegrationTest {

    private static final String PAYMENT_ENDPOINT = "/payment";
    private static final Integer VALID_QUANTITY = 500;
    private static final String INVALID_QUANTITY = "invalid quantity";

    @Autowired
    private MockMvc mockMvc;

    /**
     * Escenario donde un pago es exitoso, por lo que se espera un status 200.
     * @throws Exception excepcion que se lanzara en caso de no ser una cantidad valida.
     */
    @Test
    public void processPayment_Success() throws Exception {
        String validQuantity = String.valueOf(VALID_QUANTITY);

        mockMvc.perform(MockMvcRequestBuilders.post(PAYMENT_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validQuantity))
                .andExpect(status().isOk());
    }

    /**
     * Escenario donde el pago no es exitoso, al producirse un error interno del servidor.
     * @throws Exception excepcion lanzada al tener un error interno en el servidor.
     */
    @Test
    public void processPayment_InternalServerError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(PAYMENT_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(INVALID_QUANTITY))
                .andExpect(status().isInternalServerError());
    }
}
package testexample.app.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class PaymentServiceTest {

    private static final Integer VALID_QUANTITY = 15;

    private static final Integer EXCESSIVE_QUANTITY = 150;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;

    /**
     * Configuracion para capturar lo impreso por pantalla.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Configuracion para capturar la salida por pantalla.
     */
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    // SUT = System Under Test.
    @InjectMocks
    private PaymentService sut;

    /**
     * Escenario donde el pago es exitoso, dado que la cantidad de pago es valida.
     * Y no excede el limite establecido, por lo que se espera la validacion correcta de:
     * Siendo el mensaje "Processing..." igual al que capturamos a la hora de ejecutar el metodo.
     */
    @Test
    public void payment_Success() {
        sut.payment(VALID_QUANTITY);

        assertEquals("Processing payment of: "
                + VALID_QUANTITY + System.lineSeparator(),
                outputStreamCaptor.toString());
    }

    /**
     * Escenario donde el pago excede el limite establecido, por lo que se espera:
     * Se lance una excepcion de tipo IllegalARgumentException al ejecutar dicho metodo.
     */
    @Test
    public void payment_ExceedsLimit_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            sut.payment(EXCESSIVE_QUANTITY);
        });
    }

}
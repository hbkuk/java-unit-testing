package stub;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentProcessingTest {

    @Test
    void paymentProcessingTest() {
        PaymentGatewayStub paymentGateway = new PaymentGatewayStub();
        paymentGateway.process(100.0);

        assertThat(paymentGateway.getSuccessCnt()).isEqualTo(1);
    }
}

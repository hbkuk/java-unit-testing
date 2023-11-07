package stub;

public class PaymentGatewayStub implements PaymentGateway {

    private int successCnt = 0;

    @Override
    public void process(double amount) {
        successCnt ++;
    }

    public int getSuccessCnt() {
        return successCnt;
    }
}

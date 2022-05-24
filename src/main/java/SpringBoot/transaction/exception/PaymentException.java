package SpringBoot.transaction.exception;

public class PaymentException extends RuntimeException{
    //need to create condtructor

    public PaymentException(String message) {
        super(message);
    }
}

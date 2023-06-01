package kg.aleksandrov.shop.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UnifiedException extends RuntimeException{

    private String message;
    private Object param;

}

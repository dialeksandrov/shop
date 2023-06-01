package kg.aleksandrov.shop.util;

import kg.aleksandrov.shop.exception.UnifiedException;
import lombok.experimental.UtilityClass;

import static kg.aleksandrov.shop.constnats.ErrorMessages.PRODUCT_NOT_FOUND;

@UtilityClass
public class ExceptionUtils {

    public static UnifiedException productNotFoundException(Long id) {
        return UnifiedException.builder()
                .message(PRODUCT_NOT_FOUND)
                .param(id)
                .build();
    }
}

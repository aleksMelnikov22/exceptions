package exceptions;

import java.io.IOException;

public class DataCountException extends IOException {
    public DataCountException() {
        super("Количество данных не соответствует требуемому");
    }
}
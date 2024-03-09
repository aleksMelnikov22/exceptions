package exceptions;

import java.io.IOException;

public class DataFormatException extends IOException {
    public DataFormatException() {
        super("Формат данных не соответствует требуемому");
    }
    public DataFormatException(String message) {
        super(message);
    }

}
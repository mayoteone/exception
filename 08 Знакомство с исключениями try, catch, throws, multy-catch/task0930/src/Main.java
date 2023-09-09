import java.io.IOException;
import java.util.logging.Logger;

/**
 *  Логирование состояний и ошибок в работе программы.
 *  Напишите метод, который выбрасывает проверяемое исключение и поймайте его в методе main
 *  Отловите и залогируйте начало вызова метода с ошибкой и саму ошибку уровнем INFO и WARNING соответственно
 */

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            throwExcepon();
        } catch (IOException e) {
            LOGGER.info("starting a method call with an error");
            LOGGER.warning("error");
        }
    }

    public static void throwExcepon() throws IOException {
        throw new IOException();
    }

}
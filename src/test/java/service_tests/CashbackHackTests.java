package service_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.CashbackHackService;

/**
 * Тесты для проверки CashbackHackService.
 */
class CashbackHackTests {

    private static CashbackHackService cashbackHackService;

    /**
     * Предварительная инициализация сервиса.
     */
    @BeforeAll
    static void createService() {
        cashbackHackService = new CashbackHackService();
    }

    /**
     * Проверяет работу метода remain класса CashbackHackService.
     *
     * @param currentSum         - текущая сумма
     * @param expectedRemaintSum - недостающая сумма для максимального кэшбека
     */
    @ParameterizedTest(name = "{index} => currentSum={0}, expectedRemaintSum={1}")
    @CsvSource({
            "0, 1000",
            "999, 1",
            "1000, 0",
            "1364, 636",
            "2000, 0"
    })
    void getRemainSum(int currentSum, int expectedRemaintSum) {
        int remainSum = cashbackHackService.remain(currentSum);
        Assertions.assertEquals(expectedRemaintSum, remainSum, "Оставшаяся сумма расчитана неверно!");
    }
}

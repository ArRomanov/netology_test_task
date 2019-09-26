package service_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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
    @ParameterizedTest(name = "currentSum={0}, expectedRemaintSum={1}")
    @CsvFileSource(resources = "/cashback_tests_data.csv", numLinesToSkip = 1)
    void getRemainSum(int currentSum, int expectedRemaintSum) {
        int remainSum = cashbackHackService.remain(currentSum);
        Assertions.assertEquals(expectedRemaintSum, remainSum, "Оставшаяся сумма расчитана неверно!");
    }
}

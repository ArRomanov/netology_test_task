package service_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.CashbackHackService;

class CashbackHackTests {

    private static CashbackHackService cashbackHackService;

    @BeforeAll
    static void createService(){
        cashbackHackService = new CashbackHackService();
    }

    @ParameterizedTest(name = "{index} => currentSumm={0}, expectedRestSumm={1}")
    @CsvSource({
            "0, 1000",
            "999, 1",
            "1000, 0",
            "1364, 636",
            "2000, 0"
    })
    void getRestSumm(int currentSumm, int expectedRestSumm){
        int restSumm = cashbackHackService.remain(currentSumm);
        Assertions.assertEquals(expectedRestSumm, restSumm, "Оставшаяся сумма расчитана неверно!");
    }

}

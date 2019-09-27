package service;

/**
 * Сервис для расчета необходимой суммы для получения максимального кэшбэка.
 */
public class CashbackHackService {

    /**
     * Необходимая сумма для максимального кэшбека.
     */
    private final int boundary = 1000;

    /**
     * Вычисляет оставшуюся сумму, необходимую набрать для получения максимального кэшбека.
     *
     * @param amount - текущая сумма.
     * @return - возвращает недостающую сумму.
     */
    public int remain(int amount) {
        boolean isNeedMore = amount % boundary != 0;

        if (amount == 0) { // Добавил проверку на 0, потому что изначально прописал такой сценарий, но тесты не проходили
            return boundary;
        } else if (!isNeedMore) {
            return 0;
        }

        return boundary - amount % boundary;
    }
}

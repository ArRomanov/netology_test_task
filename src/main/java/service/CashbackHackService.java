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
     * @param amount - текущая сумма.
     * @return - возвращает недостающую сумму.
     */
    public int remain(int amount) {
        return boundary - amount % boundary;
    }
}

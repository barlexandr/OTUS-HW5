/***
 * Сущность счета клиента
 */
public class Account {
    private final int id;
    private long sumOfAccount;

    public Account(int accountID) {
        this.id = accountID;
    }

    public int getId() {
        return id;
    }

    public boolean putMoneyToAccount(long amountToPut) {
        this.sumOfAccount += amountToPut;
        return true;
    }

    public boolean withdrawMoneyFromAccount(long amountToWithdraw) {
        if (this.sumOfAccount < amountToWithdraw) {
            System.out.println("Недостаточно средств для снятия");
            return false;
        } else {
            this.sumOfAccount -= amountToWithdraw;
            System.out.println("Вы успешно сняли со счета " + amountToWithdraw);
            return true;
        }
    }

    public long getSumOfAccount() {
        return sumOfAccount;
    }

    @Override
    public String toString() {
        return "\nНомер счета: " + id +
                "\nСумма счета: " + sumOfAccount;
    }
}

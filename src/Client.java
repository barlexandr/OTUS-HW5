import java.util.ArrayList;
import java.util.List;

/***
 * Сущность клиента
 */
public class Client {
    private final int id;
    private final String name;
    private int age;
    private List<Account> accounts;

    public Client(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public boolean linkAccountToClient(Account account) {
        if (this.accounts ==  null) {
            this.accounts = new ArrayList<>();
        }
        return this.accounts.add(account);
    }

    public boolean unbindTheAccountFromClient(int accountId) {
        var findingAccount = this.accounts.stream()
                .filter(thisAccount -> thisAccount.getId() == accountId)
                .findFirst()
                .orElse(null);
        return findingAccount != null && this.accounts.remove(findingAccount);
    }

    public void incrementedAge() {
        this.age++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return
                "\nИмя клиента: " + name +
                        "\nВозраст клиента: " + age;
    }
}

import java.util.ArrayList;
import java.util.List;

/***
 * Сущность банка
 */
public class Bank {
    private List<Client> clients;

    public void addClientToTheBank(Client client) {
        if (clients == null) {
            clients = new ArrayList<>();
        }
        clients.add(client);
    }

    public List<Account> getAccountsByClientID(int clientID) {
        var findingClient = this.clients.stream()
                .filter(client -> client.getId() == clientID)
                .findAny()
                .orElse(null);
        return findingClient == null ? null : findingClient.getAccounts();
    }

    public Client getClientByAccountID(int accountID) {
        return this.clients.stream()
                .filter(client -> client.getAccounts().stream()
                        .anyMatch(account -> account.getId() == accountID))
                .findFirst()
                .orElse(null);
    }
}

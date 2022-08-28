import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int accountID = random.nextInt((65536) - 32768);
        int accountID2 = random.nextInt((65536) - 32768);
        int clientID = random.nextInt((65536) - 32768);

        Bank bank = new Bank();
        Client client = new Client(clientID, "Alexandr", 18);
        Account accountForClient1 = new Account(accountID);
        Account accountForClient2 = new Account(accountID2);

        client.linkAccountToClient(accountForClient1);
        client.linkAccountToClient(accountForClient2);

        tryToDepositMoneyAndOutputResultToConsole(accountForClient1, 1000L);
        tryToWithdrawMoneyAndOutputResultToConsole(accountForClient1, 1001L);
        tryToDepositMoneyAndOutputResultToConsole(accountForClient2, 999_999L);

        bank.addClientToTheBank(client);

        getAndOutputToConsoleAccountByClientId(bank, clientID);
        getAndOutputToConsoleAccountByClientId(bank, 1);

        getAndOutputToConsoleClientByAccountId(bank, accountID);
        getAndOutputToConsoleClientByAccountId(bank, 1);
    }

    public static void getAndOutputToConsoleClientByAccountId(Bank bank, int accountId) {
        var client = bank.getClientByAccountID(accountId);
        if (client == null) {
            System.out.println("Не найдено клиента с данным id счета.\n");
        } else {
            System.out.println("По указанному номеру счета найден следующий клиент:" + client.toString().replaceAll("(^\\[|]$)", "") + "\n");
        }
    }

    public static void getAndOutputToConsoleAccountByClientId(Bank bank, int clientId) {
        var accounts = bank.getAccountsByClientID(clientId);
        if (accounts == null) {
            System.out.println("У клиента с данным id счетов не найдено.\n");
        } else {
            System.out.println("У клиента с данным id найдены следующие счета:" + accounts.toString().replaceAll("(^\\[|]$)", "") + "\n");
        }
    }

    public static void tryToDepositMoneyAndOutputResultToConsole(Account account, long amountToPut) {
        boolean result = account.putMoneyToAccount(amountToPut);
        if (result) {
            System.out.println("Вы успешно положили " + amountToPut + " на счет " + account.getId() + "\n");
        } else {
            System.out.println("Операция завершилась с ошибкой\n");
        }
    }

    public static void tryToWithdrawMoneyAndOutputResultToConsole(Account account, long amountToPut) {
        boolean result = account.withdrawMoneyFromAccount(amountToPut);
        if (result) {
            System.out.println("Вы успешно положили " + amountToPut + " на счет " + account.getId() + "\n");
        } else {
            System.out.println("Операция завершилась с ошибкой\n");
        }
    }
}

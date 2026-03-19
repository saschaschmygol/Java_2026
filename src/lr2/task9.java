package lr2;

public class task9 {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("Анна", 1000);

        account.deposit(500);
        account.withdraw(300);

        System.out.println("Владелец: " + account.getOwner());
        System.out.println("Текущий баланс: " + account.getBalance());
    }

    public interface BankAccountInterface {
        void deposit(double amount);      // пополнение
        void withdraw(double amount);     // снятие
        double getBalance();              // баланс
    }

    public static class BankAccount implements BankAccountInterface {
        private String owner;
        private double balance;

        public BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Пополнение: " + amount);
            } else {
                System.out.println("Сумма должна быть положительной!");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Снятие: " + amount);
            } else {
                System.out.println("Недостаточно средств или неверная сумма!");
            }
        }

        public double getBalance() {
            return balance;
        }

        public String getOwner() {
            return owner;
        }
    }
}

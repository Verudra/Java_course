class BankAccount {
    private int balance = 0;

    // 存钱方法，线程安全
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " 存入：" + amount + "，当前余额：" + balance);
    }

    // 取钱方法，线程安全
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " 取出：" + amount + "，当前余额：" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " 取款失败，余额不足！");
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // 存钱线程
        Thread depositor = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(100); // 模拟操作延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "存钱人");

        // 取钱线程
        Thread withdrawer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
                try {
                    Thread.sleep(150); // 模拟操作延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "取钱人");

        // 启动线程
        depositor.start();
        withdrawer.start();
    }
}

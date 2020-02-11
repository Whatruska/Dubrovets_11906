package FirstSem.Lesson_14;

import java.util.Scanner;

public class Main {
    private static ShopSystem system = new ShopSystem();
    private static Scanner scanner = new Scanner(System.in);

    private static final String EXIT = "exit";
    private static final String NEW_SHOP = "newShop";
    private static final String BEST_SHOP = "bestShop";
    private static final String WORST_SHOP = "worstShop";
    private static final String BEST_CASHIER = "bestCashier";
    private static final String WORST_CASHIER = "worstCashier";
    private static final String MOVE_CASHIER = "moveCashier";
    private static final String LIST = "list";

    public static void main(String[] args) {
        String command = "";
        while (!command.equalsIgnoreCase(EXIT)){
            System.out.println("Введите команду");
            command = scanner.next();
            if (command.equalsIgnoreCase(NEW_SHOP)){
                makeNewShop();
            } else if (command.equalsIgnoreCase(BEST_SHOP)){
                System.out.println(system.getBestShop());
            } else if (command.equalsIgnoreCase(WORST_SHOP)){
                System.out.println(system.getWorstShop());
            } else if (command.equalsIgnoreCase(BEST_CASHIER)){
                System.out.println(system.getBestCashier());
            } else if (command.equalsIgnoreCase(WORST_CASHIER)){
                System.out.println(system.getWorstCashier());
            } else if (command.equalsIgnoreCase(MOVE_CASHIER)){
                moveCashier();
            } else if (command.equalsIgnoreCase(LIST)){
                System.out.println(system.toString());
            } else {
                System.out.println("Неправильная команда");
            }
        }
    }

    private static void makeNewShop(){
        System.out.println("Опишите новый магазин");
        System.out.println("Введите количетво отделов");
        int departs = scanner.nextInt();
        Shop shop = new Shop(0);
        for (int i = 0; i < departs; i++){
            makeNewDepart(shop);
        }
        system.addShop(shop);
    }

    private static void makeNewDepart(Shop shop){
        int departId = shop.size();
        System.out.println("Опишите отдел номер " + departId);
        System.out.println("Введите количество кассиров");
        int n = scanner.nextInt();
        ShopDepartment department = new ShopDepartment(n);
        System.out.println("Опишите кассиров");
        for (int i = 0; i < n; i++){
            int money = scanner.nextInt();
            department.addCashier(new Cashier(money));
        }
        shop.addDepartment(department);
    }

    private static void moveCashier(){
        System.out.println("Введите индексы кассира (магазин, отдел, номер)");
        int shopNum = scanner.nextInt();
        int depInd = scanner.nextInt();
        int cashierNum = scanner.nextInt();
        Cashier cashier = system.pushCashierFromShop(shopNum, depInd, cashierNum);
        System.out.println("Куда отправить кассира ? (магазин, отдел)");
        int destShop = scanner.nextInt();
        int destDep = scanner.nextInt();
        system.addCashierToShop(destShop, destDep, cashier);
    }
}

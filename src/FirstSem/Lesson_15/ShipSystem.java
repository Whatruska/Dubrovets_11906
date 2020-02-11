package FirstSem.Lesson_15;

import java.util.Scanner;

public class ShipSystem {
    private final static Scanner scanner = new Scanner(System.in);
    private static Ship[] ships;
    private static int freeIndex = 0;

    private static final int MOVE_CMD = 0;
    private static final int SHOOT_CMD = 1;

    public static void start() {
        System.out.println("Введите кол-во кораблей");
        int n = scanner.nextInt();
        ships = new Ship[n];
        for (int i = 0; i < n; i++){
            defineShip();
        }
        System.out.println("Введите кол-во команд");
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++){
            executeCommand();
        }
        getList();
    }

    private static void defineShip(){
        System.out.println("Выберите тип корабля : ");
        for (ShipType type : ShipType.values()){
            System.out.println(type);
        }
        Ship ship = ShipType.getShipByType(ShipType.valueOf(scanner.next()));
        ships[freeIndex] = ship;
        freeIndex++;
    }

    private static void getList(){
        for (int i = 0; i < ships.length; i++){
            System.out.println(i + " " + ships[i].toString());
        }
    }

    private static void executeCommand(){
        System.out.println("Введите команду");
        System.out.println(MOVE_CMD + " - Передвижение");
        System.out.println(SHOOT_CMD + " - Выстрел");
        int cmd = scanner.nextInt();
        if (cmd == MOVE_CMD){
            executeMove();
        } else if (cmd == SHOOT_CMD){
            executeShoot();
        }
    }

    private static void executeMove(){
        System.out.println("Введите данные (ID, x, y)");
        int shipID = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Ship ship = ships[shipID];
        ship.move(x,y);
    }

    private static void executeShoot(){
        System.out.println("Введите данные (ID 1, ID 2)");
        int firstShipID = scanner.nextInt();
        int secondShipID = scanner.nextInt();
        Ship firstShip = ships[firstShipID];
        Ship secondShip = ships[secondShipID];
        firstShip.shoot(secondShip);
    }
}

package FirstSem.Lesson_15;

public enum ShipType {
    TRIANGLE_SHIP, CIRCLE_SHIP, SQUARE_SHIP;

    public static Ship getShipByType(ShipType type){
        if (type.equals(TRIANGLE_SHIP)){
            return new TriangleShip();
        } else if (type.equals(CIRCLE_SHIP)){
            return new CircleShip();
        } else if (type.equals(SQUARE_SHIP)){
            return new SquareShip();
        }
        return null;
    }
}

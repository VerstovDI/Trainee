package Content;

import java.util.ArrayList;

public class Ship {
    private int x, y;  // "Начальная клетка" в расположении корабля
    private int dx, dy;  // Смещения относительно начальной клетки
    private ShipState shipState = ShipState.FULL;  // Состояние корабля

    public Ship() { }

    public Ship(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public ShipState getShipState() {
        return shipState;
    }

    public void setShipState(ShipState shipState) {
        this.shipState = shipState;
    }

    // TODO: допилить
    public ArrayList<Integer> fieldsAroundShip() {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = x; i <= x + dx; i++) {
            for (int j = y; j <= x + dy; j++) {
                //
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "x=" + x +
                ", y=" + y +
                ", dx=" + dx +
                ", dy=" + dy +
                ", shipState=" + shipState +
                '}';
    }
}

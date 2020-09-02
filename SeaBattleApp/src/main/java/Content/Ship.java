package Content;

import DataInput.InputChecker;
import Game.GameOptions;

import java.util.ArrayList;

public class Ship {
    private int x, y;  // "Начальная клетка" в расположении корабля
    private int dx, dy;  // Смещения относительно начальной клетки
    private ShipState shipState = ShipState.FULL;  // Состояние корабля
    private int health;  // Здоровье корабля
    private ArrayList<Board.Field> shipFields;  // Поля, занятые данным кораблем. Для упрощения
    // TODO: допилить shipFields

    public Ship() { }

    public Ship(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 1;
    }
    public Ship(int x, int y, int dx, int dy, int health) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.health = health;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<Board.Field> getShipFields() {
        return shipFields;
    }

    public void setShipFields(ArrayList<Board.Field> shipFields) {
        this.shipFields = shipFields;
    }

    public int getShipMinX() {
        return Math.max(0, this.getX() - 1);
    }

    public int getShipMinY() {
        return Math.max(0, this.getY() - 1);
    }

    public int getShipMaxX() {
        return Math.min(GameOptions.fieldSize - 1,
                this.getX()
                        + 1
                        + (this.getDx() > this.getDy() ? this.getDx() - this.getDy() : 0));
    }

    public int getShipMaxY() {
        return Math.min(GameOptions.fieldSize - 1,
                this.getY()
                        + 1
                        + (this.getDx() > this.getDy() ? 0 : this.getDy() - this.getDx()));
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

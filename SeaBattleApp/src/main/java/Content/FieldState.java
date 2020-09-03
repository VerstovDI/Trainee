package Content;

/**
 * @author Danila
 * @version 1.0
 * Enum representing state of fields on board.
 * WATER = just a water
 * MISSED = WATER + already fired by player
 * SHIP = ship or part of ship
 * SHIP_BORDER = WATER, which in the 1st near field from ship
 * HIT = SHIP field + already fired by player
 */
public enum FieldState { WATER, MISSED, HIT, SHIP, SHIP_BORDER }

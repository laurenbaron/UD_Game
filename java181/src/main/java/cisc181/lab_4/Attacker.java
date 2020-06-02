package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * Attacker Interface
 */
public interface Attacker {
    /**
     * when a piece attacks another piece
     * @param rowAttacker -- the row index of the attacker
     * @param colAttacker -- the column index of the attacker
     * @param rowAttackee -- the row index of the piece the attacker is attacking
     * @param colAttackee -- the column index of the piece the attacker is attacking
     */
    public abstract void attack(int rowAttacker, int colAttacker, int rowAttackee, int colAttackee);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave1_2_abstract_factory;

/**
 *
 * @author andrasacs
 */
public abstract class InfantryUnit {

    private String name;
    private int range;
    private int armor;
    private int hits;
    private int damage;
    private String race;

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    // Range is not imlemented yet
    public InfantryUnit(int range, int armor, int hits, int damage) {
        this.range = range;
        this.armor = armor;
        this.hits = hits;
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        int reduction = (int) (Math.random() * armor);
        if (damage > reduction) {
            hits = hits - (damage - reduction);
        }
    }

    public void attack(InfantryUnit unit) {
        int attackDamage = (int) (Math.random() * damage) + 1;
        unit.takeDamage(attackDamage);
        System.out.println(name + " attacked " + unit.getName());
        System.out.println(unit.name.toString() + " -" + attackDamage + " lifeponts. Remaining: " + unit.hits);
    }

    @Override
    public String toString() {
        String strAlive = "(ALIVE)";
        if (!this.alive()) {
            strAlive = "(DEAD)";
        }
        return "Hero " + name + " " + strAlive + " armor: " + armor + " damage: " + damage + " hits: " + hits;
    }

    public boolean alive() {
        boolean alive = true;
        if (hits < 0) {
            alive = false;
        }
        return alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

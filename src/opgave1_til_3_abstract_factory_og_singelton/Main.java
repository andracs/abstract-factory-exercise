/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave1_til_3_abstract_factory_og_singelton;

/**
 *
 * @author andrasacs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // The world can only be instantiated once, because Singleton!
        System.out.println("***************************************");
        World middleEarth = World.getWorldInstance();
        System.out.println("The name of our world is " + middleEarth.getName() + "!");
        System.out.println("***************************************");
         
        // Creating facories
        // Not neededed:
        // FactoryFactory master = new FactoryFactory();
        InfantryFactory humanFactory = FactoryFactory.createInfantryFactory(1);
        InfantryFactory orcFactory = FactoryFactory.createInfantryFactory(2);

        // The factories are producing units        
        InfantryUnit soldierA = humanFactory.createUnit(1); // unit 1 -- rockhauler
        soldierA.setName("Durotan");
        InfantryUnit soldierB = orcFactory.createUnit(2); // unit 2 -- spearthrower
        soldierB.setName("Orgrim");
        

        // The units are fighting for death
        while (soldierA.alive() && soldierB.alive()) {
            soldierA.attack(soldierB);
            soldierB.attack(soldierA);
        }
        
        // The battle reults are announced
        System.out.println("***************************************");
        if (!soldierA.alive()) {
            if (!soldierB.alive()) {
                System.out.println("It's a draw");
            } else {
                System.out.println(soldierB.getRace() + " " + soldierB.getName() + " " + soldierB.getClass().getSimpleName() + " wins!");
            }
        } else {
            System.out.println(soldierA.getRace() + " " + soldierA.getName() + " " + soldierA.getClass().getSimpleName() + " wins!");
        }
        System.out.println("***************************************");
    }

}

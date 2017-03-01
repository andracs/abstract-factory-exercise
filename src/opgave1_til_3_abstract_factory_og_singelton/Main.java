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
        
        System.out.println("***************************************");
        World middleEarth = World.getWorldInstance();
        System.out.println("The name of our world is " + middleEarth.getName() + "!");
        System.out.println("***************************************");
        
        // Creating facories
        InfantryFactory humanFactory = FactoryFactory.createInfantryFactory(1);
        InfantryFactory orcFactory = FactoryFactory.createInfantryFactory(2);

        // The factories are producing units        
        InfantryUnit rh = humanFactory.createUnit(1); // unit 1 -- rockthrower
        rh.setName("Durotan");
        InfantryUnit st = orcFactory.createUnit(2); // unit 2 -- spearthrower
        st.setName("Orgrim");
        ;

        // The units are fighting for death
        while (rh.alive() && st.alive()) {
            rh.attack(st);
            st.attack(rh);
        }
        
        // The battle reults are announced
        System.out.println("***************************************");
        if (!rh.alive()) {
            if (!st.alive()) {
                System.out.println("It's a draw");
            } else {
                System.out.println(st.getRace() + " " + st.getName() + " " + st.getClass().getSimpleName() + " wins!");
            }
        } else {
            System.out.println(rh.getRace() + " " + rh.getName() + " " + rh.getClass().getSimpleName() + " wins!");
        }
        System.out.println("***************************************");
    }

}

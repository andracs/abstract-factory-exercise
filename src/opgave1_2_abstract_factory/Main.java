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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InfantryFactory humanFactory = FactoryFactory.createInfantryFactory(1);
        InfantryFactory orcFactory = FactoryFactory.createInfantryFactory(2);
        
        // Range, armor, hits, damage
        InfantryUnit rh = humanFactory.createUnit(1);
        rh.setName("Durotan");
        InfantryUnit st = orcFactory.createUnit(2);
        st.setName("Orgrim");
;
        
        // Fighting for death
        while (rh.alive() && st.alive()) {
            rh.attack(st);
            st.attack(rh);
        }
        
        System.out.println("***************************************");
        if (!rh.alive()) {
            if (!st.alive()) {  System.out.println("It's a draw"); }
            else { System.out.println(st.getRace() + " " + st.getName() + " " + st.getClass().getSimpleName() + " wins!");}
        }
        else {System.out.println(rh.getRace() + " " + rh.getName() +  " " + rh.getClass().getSimpleName() +" wins!");}
        System.out.println("***************************************");        
    }
    
}

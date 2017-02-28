/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave1_2_factory_and_abstract_factory;

/**
 *
 * @author andrasacs
 */
public class DesignPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Range, armor, hits, damage
        InfantryUnit rh = HumanInfantryFactory.createUnit(1);
        rh.setName("Durotan");
        InfantryUnit st = HumanInfantryFactory.createUnit(2);
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
            else { System.out.println(st.getName() + " " + st.getClass().getSimpleName() + " wins!");}
        }
        else {System.out.println(rh.getName() +  " " + rh.getClass().getSimpleName() +" wins!");}
        System.out.println("***************************************");        
    }
    
}

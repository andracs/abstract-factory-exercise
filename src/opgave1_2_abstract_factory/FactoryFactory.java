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
public class FactoryFactory {

    public static InfantryFactory createInfantryFactory(int race) {
       InfantryFactory factory;
        switch (race) {
            case 1: 
                factory = new HumanInfantryFactory();
                break;
            case 2: 
                factory = new OrcInfantryFactory();
                break;
            // case 3,4 and 5 should be imlemented here
            default: 
                factory = null;
                break;
        }
        return factory;
    }

}

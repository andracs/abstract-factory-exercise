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
public class HumanInfantryFactory extends InfantryFactory {

    public static InfantryUnit createUnit(int techLevel) {
        InfantryUnit character;
        switch (techLevel) {
            case 1: 
                character = new RockHauler(3, 5, 20, 7);
                break;
            case 2: 
                character = new SpearThrower(3, 5, 20, 8);
                break;
            // case 3,4 and 5 should be imlemented here
            default: 
                character = null;
                break;
        }
        return character;
    }

}

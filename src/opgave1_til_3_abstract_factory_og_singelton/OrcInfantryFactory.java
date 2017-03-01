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
public class OrcInfantryFactory extends InfantryFactory {

    public InfantryUnit createUnit(int techLevel) {
        InfantryUnit character;
        switch (techLevel) {
            case 1:
                character = new RockHauler(3, 5, 24, 7);
                character.setRace("Orc");
                break;
            case 2:
                character = new SpearThrower(3, 5, 24, 8);
                character.setRace("Orc");
                break;
            // case 3,4 and 5 should be imlemented here
            default:
                character = null;
                break;
        }
        return character;
    }

}

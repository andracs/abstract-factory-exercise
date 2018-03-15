/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave1_til_3_abstract_factory_og_singelton;

public class RockHauler extends InfantryUnit {


    public RockHauler() {super(3,3,3,3);}

    public RockHauler(int range, int armor, int hits, int damage) {
        super(range, armor, hits, damage);
    }


}

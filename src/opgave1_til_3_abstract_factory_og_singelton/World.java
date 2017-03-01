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

// Implementing the singleton pattern
// Only onw world can be created, and that is middleEarth
public class World {
    private static World middleEarth;    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
            
    private World() {}
   
    public static World getWorldInstance() {
        if (middleEarth instanceof World) {
            // Do nothing
        } else {
            middleEarth = new World();
        }
        middleEarth.name = "Middle Earth"; 
        return middleEarth;
    }
}

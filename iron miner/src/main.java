import org.osbot.E;
import org.osbot.rs07.api.Objects;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import sun.reflect.generics.tree.Tree;


/**
 * Created by Sean Frazier on 2/4/2016.
 */

@ScriptManifest(author = "Sean", logo = "", info ="mines iron" , version = 1.0 , name = "Sean's ironer")
public class main extends Script {

    private int i =1;


    @Override

    public void onStart(){

    }

    public void onExit(){

    }


    public int onLoop() throws InterruptedException {





        if(!getInventory().isFull()){

            //chop
            Area treeArea = new Area(3092, 3240, 3970, 3246);
            Entity Rocks = objects.closest(7455);
            if(Rocks != null) {
                if(Rocks.isVisible()) {
                    if(!myPlayer().isAnimating()) {
                        if(!myPlayer().isMoving()) {

                            Rocks.interact("Mine");
                            i++;
                            sleep(random(700, 3000));
                        }
                    }


                }else {


                    camera.toEntity(Rocks);
                }
            }
        }else{
            //bank
            Area bankArea = new Area(3092, 3240, 3970, 3246);
            if(bankArea.contains(myPlayer()) ) {

                sleep(random(700, 1500));
            }else{
                walking.walk(bankArea);
            }
        }

        if (i >= 5){
            camera.moveYaw(random(-180,180));
            i =0;
        }
        return 0;
    }




}

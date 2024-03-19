import java.util.*;
public class Mouse extends Creature {
    public int rounds;

    //Mouse constructor
    public Mouse(int x, int y, City cty){
        super(x,y,cty);
        lab = LAB_BLUE;
        dead = false;
        stepLen = 1;
    } 

    

    @Override
    public void step() {

        rounds++;
        //If rounds is past 22, Mouse dies and exist step
          if(rounds == 23) {
            dead = true;
            //System.out.println("dead");
            return;
        }

        int turn = city.getNextRandomTurn();
        if(turn == 0 || turn == 1) {
            randomTurn();
        }
        
        super.step();
      
    }

    public void takeAction() {
        //give birth to Mouse
        if(rounds % 20 == 0) 
          city.addMouse(super.getX(), super.getY());
        GridPoint myPoint = getGridPoint();
        //Scans to see if it has been eaten by a Cat
        //pronounced dead if true
        for(Creature c : city.creatures) {
            if(c instanceof Cat && c.getGridPoint().equals(myPoint)) {
                dead = true;
            }
        }
    }
}
import java.util.*;
public class Mouse extends Creature {
    public int rounds;

    public Mouse(int x, int y, City cty){
        super(x,y,cty);
        lab = LAB_BLUE;
        dead = false;
        stepLen = 1;
    } 

    

    @Override
    public void step() {

        rounds++;
        //System.out.println("Round: " + rounds);
          if(rounds == 23) {
            dead = true;
            //System.out.println("dead");
            return;
        }


        int turn = city.getNextRandomTurn();
        
        if(turn == 0 || turn == 1) {
            randomTurn();
        }
        //System.out.println(turn);
        
        super.step();
      
    }

    public void takeAction() {
        if(rounds % 20 == 0) 
          city.addMouse(super.getX(), super.getY());
        GridPoint myPoint = getGridPoint();
        for(Creature c : city.creatures) {
            if(c instanceof Cat && c.getGridPoint().equals(myPoint)) {
                dead = true;
            }
        }
    }
}
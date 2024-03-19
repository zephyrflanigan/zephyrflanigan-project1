public class Cat extends Creature {

   public int roundsEaten;
   public Mouse toChase;

   public Cat(int x, int y, City cty){
        super(x,y,cty);
        lab = LAB_YELLOW;
        dead = false;
        stepLen = 2;
    } 


    public void takeAction() {
        GridPoint myPoint = getGridPoint();
        for(Creature c : city.creatures) {
            if(c instanceof Mouse) {
                if(c.getGridPoint().equals(myPoint)) {
                    lab = LAB_YELLOW;
                    roundsEaten = 0;
                }
                int myDist = myPoint.dist(c.getGridPoint());
                if(c.isDead() == false && myDist < 20) {
                    lab = LAB_CYAN; 
                    int xDist =  Math.abs(super.getX()-c.getX());
                    int yDist = Math.abs(super.getY()-c.getY());

                    if(yDist > xDist) {
                        if(super.getY()-c.getY() >= 0) {
                            super.setDir(NORTH);
                        } else{
                            super.setDir(SOUTH);
                        }
                    return;
                    } else if (yDist <= xDist){
                        if(super.getX()-c.getX() >= 0) {
                            super.setDir(WEST);
                        } else{
                            super.setDir(EAST);
                        }
                    return;
                    }

                } else {
                    lab = LAB_YELLOW;
                }
            }
        }

    }

    @Override
    public void step(){
        roundsEaten++;
        if(roundsEaten == 51) {
            dead = true;
            return;
        }
        int turn = city.getNextRandomTurn();
        if(turn == 0)
            randomTurn();
        super.step();
        
    }



}
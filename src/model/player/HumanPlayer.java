package model.player;


public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(){
        setChanged();
        notifyObservers();
    }

    /**
     * playTurn method for the human player, which does the standard and mandatory things each player must do
     * if they are not in jail
     */
    @Override
    public void playTurn(){
        this.getOutOfJailChoice = BailOutChoice.WAIT;

        if(!isInJail()){
            rollDice();
            if( getConsecutiveDoubleCount() == 3){
                goToJail();
            } else {
                moveToken( playersDice.getDiceResultSum());
            }


        }
        updatePlayerWorth();
        setChanged();
        notifyObservers();
        System.out.println(toString());
    }

    @Override
    public boolean isAIControlled() {
        return false;
    }
}

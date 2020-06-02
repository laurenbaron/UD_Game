package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PieceSharkBait Class
 */
public class PieceSharkBait extends Piece implements Recruiter{

    /**
     * constructor with all parameters
     * @param symbol -- the sharkbait's symbol
     * @param color -- the sharkbait's color
     */
    public PieceSharkBait(String symbol, String color){
        super(symbol, color);
    }

    /**
     * constructor for when color information is not available yet
     * @param symbol -- the shark bait's symbol
     */
    public PieceSharkBait(String symbol){
        super(symbol);
    }

    /**
     * Shark bait's specific thing to say
     */
    public void speak(){
        System.out.println("Shark bait oooh ha haa!");
    }

    /**
     * check whether the move from 1st location to second location is valid based on Penguin's
     * specific way to move
     * @param rowBefore -- current row index of the sharkbait on the board that is being moved
     * @param colBefore -- current column index of the sharkbait on the board that is being moved
     * @param rowAfter -- row index of the location the sharkbait will be moved to
     * @param colAfter -- column index of the location the sharkbait will be moved to
     * @return boolean -- whether or not the second location is a valid move based on first location
     */
    public boolean validPath(int rowBefore, int colBefore, int rowAfter, int colAfter) {
        //can move two spaces diagonally in any direction
        return ( ((rowAfter==rowBefore+2) && (colAfter==colBefore+2)) ||
                ((rowAfter==rowBefore-2) && (colAfter==colBefore-2)) ||
                ((rowAfter==rowBefore-2) && (colAfter==colBefore+2)) ||
                ((rowAfter==rowBefore+2) && (colAfter==colBefore-2)) );
    }

    /**
     * when a sharkbait recruits another piece for their team
     * @param rowRecruiter -- the row index of the piece that is recruiting (the sharkbait)
     * @param colRecruiter -- the column index of the piece that is recruiting (the sharkbait)
     * @param rowRecruitee -- the row index of the piece the recruiter is recruiting
     * @param colRecruitee -- the column index of the piece the recruiter is recruiting
     */
    public void recruit(int rowRecruiter, int colRecruiter, int rowRecruitee, int colRecruitee){
        speak();
        System.out.println("You're on my team now! – other piece removed from other team and added to this team.");
    }
}


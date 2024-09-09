package mvc.model;

abstract public class Piece {
    private int availability,x,y,limit,rank,save;
    private String name,color,image;

    /**
     * The construction of the piece depends on the rules that the user chooses. If he chooses Μειωμένος Στρατός we create
     * only 15 pieces for each player.
     * PreCondition:
     *             1) Color should be blue or red.
     *             2) Availability and rank are positive numbers.
     * PostCondition:
     * A piece that meets the requirements above is created.
     * */
    Piece (int x,int y,String color,int availability,int rank,String name, int save) {
        setName(name);
        setColor(color);
        setRank(rank);
        setPosition(x,y);
        setAvailability(availability);
        setSave(save);
    }

    /**
     * Transformer
     * @param a the position x
     * @param b the position y
     * */
    public void setPosition(int a,int b){
        this.x=a;
        this.y=b;
    }
    /**
     * Accessor
     * @return the position x of the Piece
     */
    public int getPositionX(){
        return x;
    }
    /**
     * Accessor
     * @return the position y of the Piece
     */
    public int getPositionY(){
        return y;
    }
    /**
     * Transformer
     * @param s the saves
     * */
    public void setSave(int s){
        this.save=s;
    }
    /**
     * Accessor
     * @return the saves of each Piece
     */
    public int getSave(){

        return this.save;
    }
    /**
     * Transformer
     * @param a the availability
     * */
    public void setAvailability(int a){
        this.availability=a;
    }

    /**
     * Accessor
     * @return the availability of the Piece
     */
    public int getAvailability(){
        return this.availability;
    }

    /**
     * Transformer
     * @param l the number of saves that a piece has done. we check if the limit is above 1 then no more saves can be done by this piece
     * */
    public void setLimit(int l){
        this.limit=l;
    }
    /**
     * Accessor
     * @return the limit of each Piece
     */
    public int getLimit(){
        return this.limit;
    }
    /**
     * Transformer
     * @param col the color
     * */
    public void setColor(String col) { this.color=col;
    }

    /**
     * Accessor
     * @return the color of the Piece
     */
    public String getColor(){
        return this.color;
    }
    /**
     * Transformer
     * @param na the name
     * */
    public void setName(String na) {
        this.name = na;
    }
    /**
     * Accessor
     * @return the name of the Piece
     */
    public String getName() {
        return this.name;
    }

    /**
     * Transformer
     * @param r the rank
     * */
    public void setRank(int r) { this.rank=r;
    }
    /**
     * Accessor
     * @return the rank of the Piece
     */
    public int getRank(){
        return this.rank;
    }

}

class Coordinate {
    private Double x;
    private Double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {return x;}
    public double getY() {return y;}

    public double distTo(Coordinate other) {
        return Math.sqrt(
            Math.pow( (x - other.x), 2 ) + Math.pow( (y - other.y), 2)
        );
    }

    @Override 
    public boolean equals(Object other) {
        if (!(other instanceof Coordinate)) return false;
        
        Coordinate otherCoord = (Coordinate) other;
        if (x.equals(otherCoord.x) && y.equals(otherCoord.y)) return true;

        return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
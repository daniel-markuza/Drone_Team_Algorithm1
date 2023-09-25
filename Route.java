public class Route {
    private Coordinate start;
    private Coordinate end;
    private double value;
    private double distance;
    private int passNum;
    private boolean visited;

    public Route(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
        distance = 0;

        compRouteDistance();
    }

    //distance equation to find the distance between our two points (route length)
    private void compRouteDistance() {
        distance = Math.pow(end.getX() - start.getX(), 2);
        distance += Math.pow(end.getY() - start.getY(), 2);
        distance = Math.sqrt(distance);
    }

    //Find how far the current location is from the start of this route (how long the drone
    //would actually be travelling to even begin this route)
    public double compDistanceToStart(Coordinate curr) {
        double distance = 0;

        distance = Math.pow(start.getX() - curr.getX(), 2);
        distance += Math.pow(start.getY() - curr.getY(), 2);
        distance = Math.sqrt(distance);

        return distance;
    }

    //ratio we use to compare routes, higher number the better
    public double getRatio() {
        return value/distance;
    }

    //getters and setters
    
    public void setValue(double value) {
        this.value = value;
    }

    public void setPassNum(int num) {
        passNum = num;
    }

    public int getPassNum() {
        return passNum;
    }

    public void visited(){
        visited = true;
    }

    public boolean getVisited(){
        return visited;
    }

    public void updateDistance(double by) {
        distance += by;
    }

    public Coordinate getStart() {
        return start;
    }
}

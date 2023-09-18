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
    
    private void compRouteDistance() {
        distance = Math.pow(end.getX() - start.getX(), 2);
        distance += Math.pow(end.getY() - start.getY(), 2);
        distance = Math.sqrt(distance);
    }

    public double compDistanceToStart(Coordinate curr) {
        double distance = 0;

        distance = Math.pow(start.getX() - curr.getX(), 2);
        distance += Math.pow(start.getY() - curr.getY(), 2);
        distance = Math.sqrt(distance);

        return distance;
    }

    public double getRatio() {
        return value/distance;
    }

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

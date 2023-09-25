public class FlightPlanGenerator {
    private Route[] routes;
    private Route[] finalRoutes;
    private Coordinate currPos;

    //constructor, initilize an array to store the solved path and make start location current pos
    public FlightPlanGenerator(Route[] routes, Coordinate droneStart) {
        this.routes = routes;
        finalRoutes = new Route[routes.length];
        for(int i = 0; i < finalRoutes.length; i++) {
            finalRoutes[i] = null;
        }
        currPos = droneStart;
    }

    //recursive, we repeat the problem each time with a different start point and less routes
    private void genFlightPlan(Coordinate start, int currIndex) {
        //keep repeating until everything was used up
        if(currIndex < finalRoutes.length) {
            Map currMapState = new Map(start);
            //update distances to account for how far it is from us right now
            //ordered insert all the routes left
            for(int i = 0; i < routes.length; i++) {
                if(routes[i] != null) {
                    routes[i].updateDistance(routes[i].compDistanceToStart(currPos));
                    currMapState.insert(routes[i]);
                }
            }

            //store the route at top (we sorted it by ratio in object Map) in the array
            finalRoutes[currIndex] = currMapState.nextVisit();

            //clear out the route array from visited routes
            for(int i = 0; i < routes.length; i++) {
                if(routes[i] != null && routes[i].getVisited()) {
                    routes[i] = null;
                }
            }
            //repeat the problem
            genFlightPlan(finalRoutes[currIndex++].getStart(), currIndex);
        }
    }

    public Route[] flightPlan() {
        genFlightPlan(currPos, 0);
        return finalRoutes;
    }
}

public class Map {
    /* Map holds a linked list of routes sorted by closest to furthest from the start point */
    private class RouteNode{
        private Route route;
        private RouteNode next;

        private RouteNode(Route route, RouteNode next){
            this.route = route;
            this.next = next;
        }
    }

    private RouteNode top;
    private Coordinate currLocation;

    public Map(Coordinate currLocation){
        this.top = null;
        this.currLocation = currLocation;

    }

    // ordered insert of routes by ratio of value/distance, largest to smallest
    public void insert(Route route){
        if (top == null){
            top = new RouteNode(route, null);
        } else {
            RouteNode curr = top;
            RouteNode prev = null;

            if (route.getRatio() > top.route.getRatio()){
                top = new RouteNode(route, top);
            } else {
                boolean placed = false;
                while (placed == false){
                    if (curr != null && route.getRatio() < curr.route.getRatio()){
                        prev = curr;
                        curr = curr.next;
                    } else {
                        prev.next = new RouteNode(route, curr);
                        placed = true;
                    }
                }  
            }
        }
    }

    // return the route with the shortest distance from the current position
    public Route nextVisit(){
        top.route.visited();
        return top.route;
    }
}

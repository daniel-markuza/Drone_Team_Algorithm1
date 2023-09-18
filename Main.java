import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static final String FILENAME = "test.txt";
    private static Coordinate droneStart = new Coordinate(0, 0); //some arb value
    private static Route[] routes;
    private static Route[] finalRoutes;

    public static void main(String[] args) throws IOException {
        // // read in file
        // System.out.println("enter the name of a correctly formatted coordinate file");
        // Scanner inFile = new Scanner(System.in);
        // String filename = (inFile.next());
        // inFile.close();

        String filename = FILENAME;

        final Scanner input;
        input = new Scanner(Files.newInputStream(Path.of(filename)));
        System.out.println("Going to read [" + filename + "]\n");

        //where the coords are held
        Coordinate[] coords = new Coordinate[input.nextInt()];
        input.nextLine();

        //size variable for array
        int size = 0;

        String[] tokens;
        String curLine;
        Double[] value = new Double[coords.length];


        //loop through file until empty
        while (input.hasNextLine()) {
            curLine = input.nextLine();

            tokens = curLine.split("\\s+");

            coords[size] = new Coordinate(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
            value[size] = Double.parseDouble(tokens[1]);
            size++;
        }

        routes = new Route[coords.length / 2];
        int currRouteInd = 0;

        for (int i = 0; i < coords.length; i += 2) {
            //assuming start and end are one after another in array
            routes[currRouteInd] = new Route(coords[i], coords[i + 1]);
            currRouteInd++;
        }

        for(int i = 0; i < routes.length; i++) {
            routes[i].setValue(value[i]);
        }

        FlightPlanGenerator fp = new FlightPlanGenerator(routes, droneStart);
        finalRoutes = fp.flightPlan();

        for(int i = 0; i < finalRoutes.length; i++) {
            System.out.println(finalRoutes[i].getRatio());
        }

        //--------------------------------
        //TEMPORARY FOR TESTING PURPOSES
        //PRINTS OUT CONTENTS OF FILE
        //--------------------------------
//        Graph droneMap=new Graph(coords);
//        droneMap.print();
//
//        System.out.println();
//        droneMap.removeAll(droneMap.adjacencyList[0].getTop());
//        droneMap.print();
    }
}
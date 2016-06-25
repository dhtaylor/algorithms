
package taylor.dandy.cs2420.Assignment08;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author dandy.taylor
 */
public class GraphApp
{
    private static ArrayList<String> cities = new ArrayList<>();
    private static ArrayList<DirectedEdge> edges = new ArrayList<>();
    private static EdgeWeightedDigraph graph;
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // Read Data In
        LoadData();
        
        Boolean quit = false;

        // Start App
        System.out.println("Welcome to RouteFinder!");
        
        while (!quit)
        {
            RunShortestRoute();
            quit = PromptForQuit();
            
        }
        
        System.out.println("");
        System.out.println("Thank you for using our software.");
    }
    
    private static void LoadData()
    {
        try
        {
            java.io.File file = new File("GraphData.txt");
            
            Scanner input = new Scanner(file);

            while(input.hasNext())
            {
                String line = input.next();
                String[] values = line.split(",");
                
                int from = GetCityID(values[0]);
                int to = GetCityID(values[1]);
                double weight = Double.parseDouble(values[2]);
                
                edges.add(new DirectedEdge(from, to, weight));
                edges.add(new DirectedEdge(to, from, weight));
                
            }
                    // Create EdgeWeightedDigraph from data
            graph = new EdgeWeightedDigraph(edges.size());

            for (DirectedEdge edge : edges)
            {
                graph.addEdge(edge);

            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Can't find GraphData file. Check that file is in project root directory.");
            e.printStackTrace();
          
        }
        
    }

    private static int GetCityID(String value)
    {
        if (!cities.contains(value))
            cities.add(value);

        return cities.indexOf(value);
        
    }

    private static Boolean PromptForQuit()
    {
        Boolean valid = false;
        String quit = "N";
        
        System.out.println("");
        
        while (!valid)
        {
            System.out.print("Would you like to continue (Y/N)? ");
            quit = input.next();

            if (!quit.equalsIgnoreCase("Y") && !quit.equalsIgnoreCase("N"))
            {
                System.out.println("Invalid entry. Please try again");
                continue;
            }
            
            valid = true;
            
        }

        return (quit.equalsIgnoreCase("Y")) ? false : true;

    }
    
    private static void RunShortestRoute()
    {
        PrintMenu();
        System.out.print("In which city would you like to start (e.g., 0, 1, 2, ...)? ");
        int startCityId = input.nextInt();
        System.out.print("To which city would you like to travel (e.g., 0, 1, 2, ...)? ");
        int destinationCityId = input.nextInt();
        
        DijkstraSP sp = new DijkstraSP(graph, startCityId);

        System.out.println("");
        
        if (!sp.hasPathTo(destinationCityId))
        {
            System.out.println("You cannot get to " + cities.get(destinationCityId) + " from " + cities.get(startCityId));
            return;
        }
        
        System.out.println("Shortest Path from " + cities.get(startCityId) + " to " + cities.get(destinationCityId));
        
        double totalDistance = 0;
        
        for (DirectedEdge edge : sp.pathTo(destinationCityId))
        {
            totalDistance += edge.weight();
            System.out.println("\t" + cities.get(edge.from()) + " -> " + cities.get(edge.to()));
        }
        
        System.out.println("Total distance: " + totalDistance);
        
    }
    
    private static void PrintMenu()
    {
        System.out.println("");
        System.out.println("Select two cities by number to find shortest route");
        System.out.println("Available Cities:");
        for (String city : cities)
        {
            String out = cities.indexOf(city) + " -\t" + city;
            String adjacentCities = "";
            
            for (DirectedEdge edge : graph.adj(cities.indexOf(city)))
            {
                if (adjacentCities.isEmpty())
                {
                    adjacentCities += "(Adjacent Cities: " + cities.get(edge.to()) + " - " + edge.weight();
                }
                else
                {
                    adjacentCities += ", " + cities.get(edge.to()) + " - " + edge.weight();
                }
                
            }
            
            System.out.println(out + "\t" + adjacentCities + ")");
        }

        System.out.println("");
        
    }
    
}

package luoamy_solarsystemtracker;

import java.util.Scanner;

/**
 * Displays the main menu of the solar system tracker. Allows the user to
 * interact with all the features of the database.
 *
 * @author amyluo
 */
public class SolarSystemRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName;
        String input;

        Scanner scan = new Scanner(System.in);
        SolarSystem s = new SolarSystem();

        System.out.println("Welcome to the Solar System database.");
        System.out.println("Input the name of the file storing the information of the solar system: ");
        System.out.println("Should be in the format textFileName.txt");
        fileName = scan.nextLine();

        s.loadSolarSystem(fileName);

        do {
            //main menu
            System.out.println("_______________________________");
            System.out.println("What would you like to do? ");
            System.out.println("  (1) Exit program.");
            System.out.println("  (2) See a list of all planets and their characteristics.");
            System.out.println("  (3) Sorting - See a list of the planets sorted by mass (from smallest to largest).");
            System.out.println("  (4) Sorting - See a list of the planets sorted by volume (from smallest to largest).");
            System.out.println("  (5) Searching - Search for habitable planet.");
            System.out.println("  (6) Searching - Search for specified core.");
            System.out.println("  (7) Log the discovery of a new planet.");
            System.out.println("  (8) Remove a planet from the system.");
            System.out.println("  (9) Reading - Load planetary system information from a different file.");
            System.out.println("  (10) Writing - Save planetary system information to a file.");
            System.out.println("  (11) Modifying - Change the name of a planet.");
            System.out.println("  (12) Modifying - Change the distance of the planet to the star.");
            System.out.println("Press a number to take the corresponding action.");

            input = scan.nextLine();
            switch (input) {
                case "1": //exit program?
                    System.out.println("Exit program? To confirm type Y. To return to the current menu press ENTER.");
                    String input2 = scan.nextLine().toLowerCase();
                    if (input2.equals("y")) {
                        System.exit(0);
                    } else {
                        break;
                    }
                case "2": //displays all info
                    System.out.println("");
                    System.out.println("All planetary system information: ");
                    s.displayAllInformation();
                    break;
                case "3": //sorted by mass
                    try {
                        s.sortByMass();
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "4": //sorted by volume
                    try {
                        s.sortByVolume();
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "5": //search for habitable planet
                    try {
                        System.out.println("");
                        System.out.println("The following planets fit the criteria for being habitable.");
                        s.searchHabitable();
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "6": //search for specified core
                    try {
                        System.out.println("Input the keyword(s) of the core you are looking for: ");
                        input = scan.nextLine();
                        System.out.println("");
                        System.out.println("The following planets have the specified core.");
                        s.searchForCore(input);
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "7": //log discovery of new planet
                    try {
                        s.newPlanet(scan);
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "8": //delete a planet
                    try {
                        System.out.println("Type the name of the planet you would like to delete: ");
                        String planetName = scan.nextLine();
                        s.deletePlanet(planetName, scan);
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "9": //reading- load info from file
                    try {
                        System.out.println("Input the name of the file storing the information of the planetary system: ");
                        System.out.println("Should be in the format textFileName.txt");
                        fileName = scan.nextLine();
                        s.loadSolarSystem(fileName);
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "10": // writing - write info to a file
                    try {
                        System.out.println("Input the name of the file you would like to write to (does not have to exist currently): ");
                        System.out.println("Should be in the format textFileName.txt");
                        fileName = scan.nextLine();
                        s.saveSolarSystem(fileName);
                    } catch (Exception e) {
                        System.out.println("An error occured. Please try again.");
                    }
                    break;
                case "11": // change the name of a planet
                    try {
                        System.out.println("Input the name of the planet whos name you want to change: ");
                        String oldName = scan.nextLine();
                        System.out.println("Input the new name for the planet: ");
                        String newName = scan.nextLine();
                        s.changePlanetName(oldName, newName, scan);
                    } catch (Exception e) {
                        System.out.println("An error has occured. Please try again.");
                    }
                    break;
                case "12": //change the distance between a planet and the sun
                    try {
                        System.out.println("Input the name of the planet who's distance to the star you want to change: ");
                        String planetName = scan.nextLine();
                        System.out.println("Input the new distance to the star (in AU): ");
                        double distanceToSun = Double.parseDouble(scan.nextLine());
                        s.changePlanetDistance(planetName, distanceToSun, scan);
                    } catch (NumberFormatException e) {
                        System.out.println("An error has occurred. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again:");
            }
        } while (true);
    }

}

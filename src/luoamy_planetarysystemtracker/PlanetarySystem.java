package luoamy_planetarysystemtracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains all methods with which the user can interact with the database.
 * @author amyluo
 */
public class PlanetarySystem {

    final double earthMass = 5.972e24; //in kg
    final double earthVolume = 1.08321e12; //in cubic km
    ArrayList<Planet> solarSystem = new ArrayList<>(); //storage arrayList of planets
    
    /**
     * Sorts planets in system by mass.
     */
    public void sortByMass() { //uses insertion sort
        try {
            ArrayList<Planet> sortedByMass = solarSystem;
            for (int i = 1; i < solarSystem.size(); i++) {
                Planet temp = solarSystem.get(i);
                double temp2 = temp.mass;
                int j = i - 1;
                while ((j >= 0) && (solarSystem.get(j).mass > temp2)) {
                    sortedByMass.set((j + 1), solarSystem.get(j));
                    j = j - 1;
                }
                sortedByMass.set((j + 1), temp);
            }
            System.out.println("");
            System.out.println("Now displaying the planets sorted by mass:");
            System.out.println("");
            for (int i = 0; i < sortedByMass.size(); i++) {
                System.out.println(sortedByMass.get(i).printMass());
            }
        } catch (Exception e) {
            System.out.println("Unable to sort by mass. Please try again.");
        }

    }
    
    /**
     * Sorts planets in system by volume.
     */
    public void sortByVolume() { //uses insertion sort
        try {
            ArrayList<Planet> sortedByVolume = solarSystem;
            for (int i = 1; i < solarSystem.size(); i++) {
                Planet temp = solarSystem.get(i);
                double temp2 = temp.volume;
                int j = i - 1;
                while ((j >= 0) && (solarSystem.get(j).volume > temp2)) {
                    sortedByVolume.set((j + 1), solarSystem.get(j));
                    j = j - 1;
                }
                sortedByVolume.set((j + 1), temp);
            }
            System.out.println("");
            System.out.println("Now displaying the planets sorted by volume:");
            System.out.println("");
            for (int i = 0; i < sortedByVolume.size(); i++) {
                System.out.println(sortedByVolume.get(i).printVolume());
            }
        } catch (Exception e) {
            System.out.println("Unable to sort by volume. Please try again.");
        }

    }
    
    /**
     * Displays all information relating to current solar system.
     */
    public void displayAllInformation() {
        try {
            System.out.println("");
            System.out.println("Currently displaying all solar system information.");
            for (int i = 0; i < solarSystem.size(); i++) {
                System.out.println(solarSystem.get(i));
            }
        } catch (Exception e) {
            System.out.println("Unable to display information. Please try again.");
        }
    }

    /**
     * Finds and lists all planets that fit the definition of a habitable zone.
     * A habitable zone is defined as a place in which water can exist in liquid
     * form. This requires a temperature range from 273 K to 373 K. This method
     * therefore finds and lists all planets with surface temperatures in this
     * range.
     */
    public void searchHabitable() {
        try {
            for (int i = 0; i < solarSystem.size(); i++) {
                if (isHab(solarSystem.get(i))) {
                    System.out.println(solarSystem.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to search for habitable planet. Please try again.");
        }
    }
    
    /**
     * Searches for specified core material.
     * @param coreContent Description of the core
     */
    public void searchForCore(String coreContent) {
        int counter = 0;
        try {
            for (int i = 0; i < solarSystem.size(); i++) {
                if (solarSystem.get(i).coreInfo().contains(coreContent)) {
                    System.out.println(solarSystem.get(i).printCore());
                    counter++;

                }
            }
            if (counter == 0) {
                System.out.println("No such planets found.");
            }
        } catch (Exception e) {
        }
    }
    
    /**
     * Loads solar system data from specified file.
     * @param filename Name of target file.
     */
    public void loadSolarSystem(String filename) { //loads file input
        System.out.println("");
        File solarSystemFile = new File("src/LuoAmy_solarsystemtracker/" + filename);
        try (BufferedReader br = new BufferedReader(new FileReader(solarSystemFile))) {
            String line = br.readLine();
            while (line != null) {
                if (line.contains("Terrestrial")) {
                    //creating terrestrial planet object and adding to solar system

                    String name = br.readLine();
                    double mass = Double.parseDouble(br.readLine()) * earthMass;
                    double orbitLength = Double.parseDouble(br.readLine());
                    double distanceFromSun = Double.parseDouble(br.readLine());
                    double surfaceTemp = Double.parseDouble(br.readLine());
                    double volume = Double.parseDouble(br.readLine()) * earthVolume;
                    String core = br.readLine();
                    TerrestrialPlanet t = new TerrestrialPlanet(name, mass, orbitLength, distanceFromSun, surfaceTemp, volume, core);
                    solarSystem.add(t);
                    line = br.readLine();
                    line = br.readLine();
                } else {
                    //creating giant planet object and adding to solar system
                    String name = br.readLine();
                    double mass = Double.parseDouble(br.readLine()) * earthMass;
                    double orbitLength = Double.parseDouble(br.readLine());
                    double distanceFromSun = Double.parseDouble(br.readLine());
                    double surfaceTemp = Double.parseDouble(br.readLine());
                    double volume = Double.parseDouble(br.readLine()) * earthVolume;
                    String classification = br.readLine();
                    boolean hasRings = Boolean.parseBoolean(br.readLine());
                    GiantPlanet g = new GiantPlanet(name, mass, orbitLength, distanceFromSun, surfaceTemp, volume, classification, hasRings);
                    solarSystem.add(g);
                    line = br.readLine();
                    line = br.readLine();
                }
            }
            System.out.println("Now loading solar system information.");
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
    
    /**
     * Saves solar system data to target file (file will be created if it does not exist yet).
     * @param fileName Name of the target file.
     */
    public void saveSolarSystem(String fileName) {
        File solarSystemFile = new File("src/LuoAmy_solarsystemtracker/" + fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(solarSystemFile, false))) {
            for (int i = 0; i < solarSystem.size(); i++) {
                bw.write(solarSystem.get(i).fileFormat());
            }
            System.out.println("File saved.");
        } catch (IOException ex) {
            Logger.getLogger(PlanetarySystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates new planet.
     * @param scan Scanner for user input.
     */
    public void newPlanet(Scanner scan) {
        try {
        System.out.println("What kind of planet is it (Terrestrial or Giant)?: ");
        String input = scan.nextLine();

            switch (input) {
                case "Terrestrial":
                    System.out.println("Input the name of the planet: ");
                    String name = scan.nextLine();
                    System.out.println("Input the mass of the planet in Earths: ");
                    double mass = Double.parseDouble(scan.nextLine()) * earthMass;
                    System.out.println("Input the orbital period of the planet in Earth days: ");
                    double orbitLength = Double.parseDouble(scan.nextLine());
                    System.out.println("Input the distance from the Sun in AU: ");
                    double distanceFromSun = Double.parseDouble(scan.nextLine());
                    System.out.println("Input the surface temperature of the planet in Kelvin. ");
                    double surfaceTemp = Double.parseDouble(scan.nextLine());
                    System.out.println("Input the volume of the planet in Earths: ");
                    double volume = Double.parseDouble(scan.nextLine()) * earthVolume;
                    System.out.println("Input the material of which the core is made of.");
                    String core = scan.nextLine();
                    TerrestrialPlanet t = new TerrestrialPlanet(name, mass, orbitLength, distanceFromSun, surfaceTemp, volume, core);
                    solarSystem.add(t);
                    System.out.println("");
                    System.out.println("Planet added.");
                    break;
                case "Giant":
                    System.out.println("Input the name of the planet: ");
                    name = scan.nextLine();
                    System.out.println("Input the mass of the planet in Earths: ");
                    mass = Double.parseDouble(scan.nextLine()) * earthMass;
                    System.out.println("Input the orbital period of the planet in Earth days: ");
                    orbitLength = Double.parseDouble(scan.nextLine());
                    System.out.println("Input the distance from the Sun in AU: ");
                    distanceFromSun = Double.parseDouble(scan.nextLine());
                    System.out.println("Input the surface temperature of the planet in Kelvin. ");
                    surfaceTemp = Double.parseDouble(scan.nextLine());
                    System.out.println("Input the volume of the planet in Earths: ");
                    volume = Double.parseDouble(scan.nextLine()) * earthVolume;
                    System.out.println("Input the classification of the planet: ");
                    String classification = scan.nextLine();
                    System.out.println("Does the planet have rings? (type \"true\" or \"false\"");
                    boolean hasRings = Boolean.parseBoolean(scan.nextLine());
                    GiantPlanet g = new GiantPlanet(name, mass, orbitLength, distanceFromSun, surfaceTemp, volume, classification, hasRings);
                    solarSystem.add(g);
                    System.out.println("");
                    System.out.println("Planet added.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Unable to create new planet. Please try again.");
        }
    }
    
    /**
     * Deletes specified planet.
     * @param planetName The name of the target planet.
     * @param scan Scanner for user input
     */
    public void deletePlanet (String planetName, Scanner scan) {
        int counter = 0;
        for (int i = 0; i < solarSystem.size(); i++) {
            if (solarSystem.get(i).name.equals(planetName)) {
                System.out.println("Are you sure you would like to delete " + planetName + "?");
                System.out.println("To confirm press \"y\".");
                String input = scan.nextLine();
                counter++;
                if (input.equals("y")) {
                    solarSystem.remove(solarSystem.get(i));
                    System.out.println("");
                    System.out.println(planetName + " deleted.");
                    break;
                } else {
                    break;
                }
            }
        }
        if (counter == 0) {
            System.out.println("No planet of that name was found. Please try again.");
        }
    }
    
    /**
     * Changes the name of a planet.
     * @param oldName The current name of the planet
     * @param newName The new name of the planet
     * @param scan Scanner for user inputs
     */
    public void changePlanetName(String oldName, String newName, Scanner scan) {
        int counter = 0;
        for (int i = 0; i < solarSystem.size(); i++) {
            if (solarSystem.get(i).name.equals(oldName)) {
                System.out.println("Are you sure you would like to change " + oldName + "'s name to " + newName + "?");
                System.out.println("To confirm press \"y\".");
                String input = scan.nextLine();
                counter++;
                if (input.equals("y")) {
                    solarSystem.get(i).changeName(newName);
                    System.out.println("");
                    System.out.println("Name changed.");
                    break;
                } else {
                    break;
                }
            }
        }
        if (counter == 0) {
            System.out.println("No planet of that name was found. Please try again.");
        }
    }
    
    /**
     * Changes the distance of a planet to the sun.
     * @param planetName The name of the planet
     * @param distanceToSun The distance from the planet to the Sun
     * @param scan Scanner necessary for user input
     */
    public void changePlanetDistance(String planetName, double distanceToSun, Scanner scan) {
        int counter = 0;
        for (int i = 0; i < solarSystem.size(); i++) {
            if (solarSystem.get(i).name.equals(planetName)) {
                System.out.println("Are you sure you would like to change " + planetName + "'s distance to the sun?");
                System.out.println("To confirm press \"y\".");
                String input = scan.nextLine();
                counter++;
                if (input.equals("y")) {
                    solarSystem.get(i).changeDistance(distanceToSun);
                    System.out.println("");
                    System.out.println("Distance changed.");
                    break;
                } else {
                    break;
                }
            }
        }
        if (counter == 0) {
            System.out.println("No planet of that name was found. Please try again.");
        }
    }
    
    /**
     * Returns true if a planet's surface temperature is considered habitable.
     * @param p Planet that is being checked for habitability.
     * @return if a planet's surface temperature is habitable
     */
    boolean isHab(Planet p) {
        return p.surfaceTemp < 373.15 && p.surfaceTemp > 273.15;
    }

}

package luoamy_planetarysystemtracker;

/**
 * Contains all relevant information relating to Giant planets.
 * @author amyluo
 */
public class GiantPlanet extends Planet {
    String classification; //see Sudarsky's giant classification
    boolean hasRings;
    
    /**
     * Constructor for giant planet.
     * @param name Name of planet
     * @param mass Mass in kg of planet
     * @param orbitLength Orbital period in earth days
     * @param distanceFromSun Distance from the planet to sun
     * @param surfaceTemp Temperature at the surface in K
     * @param volume Volume in cubic km
     * @param classification Classification according to Sudarsky's system
     * @param hasRings Whether or not the planet has rings
     */
    public GiantPlanet(String name, double mass, double orbitLength, double distanceFromSun, double surfaceTemp, double volume, String classification, boolean hasRings) {
        super(name, mass, orbitLength, distanceFromSun, surfaceTemp, volume);
        this.classification = classification;
        this.hasRings = hasRings;
    }
    
    /**
     * Returns a formatted string of all planet info.
     * @return String of giant planet information.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n   Mass (kg): " + mass + "\n   Orbital period (in Earth days): " + orbitLength + "\n   Distance from Sun (AU): " + distanceFromSun + "\n   Surface temperature (K): " + surfaceTemp + "\n   Volume (cubic km): " + volume + "\n   Classification: " + classification + "\n   Has rings? (boolean): " + hasRings;
    }
    
    /**
     * Returns a formatted string containing the name and mass of planets.
     * @return name and mass
     */
    @Override
    String printMass() {
        return name + ": " + mass + " kg";
    }
    
    /**
     * Returns a formatted string containing the name and volume of a planet.
     * @return name and volume
     */
    @Override
    String printVolume() {
        return name + ": " + volume + " cubic km";
    }
    
    /**
     * Returns a string of file-format ready information.
     * @return all pertinent information in file-format
     */
    @Override
    String fileFormat() {
        return "Giant\n" + name + "\n" + mass + "\n" + orbitLength + "\n" + distanceFromSun + "\n" + surfaceTemp + "\n" +  volume + "\n" + classification + "\n" + hasRings + "\n\n";
    }
    
    /**
     * Changes name of planet
     * @param newName New name of planet
     */
    @Override
    void changeName(String newName) {
        this.name = newName;
    }
    /**
     * Information relating to contents of core.
     * @return core description.
     */
    @Override
    String coreInfo() {
        return "";
    }

    /**
     * Returns string of formatted core information.
     * @return name and core description.
     */
    @Override
    String printCore() {
        return "";
    }
    /**
     * Changes the distance of the planet to the sun
     * @param newDistance New input distance for the value
     */
    @Override
    void changeDistance(double newDistance) {
        this.distanceFromSun = newDistance;
    }

}

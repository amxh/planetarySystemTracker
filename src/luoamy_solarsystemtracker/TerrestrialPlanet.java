package luoamy_solarsystemtracker;

/**
 * Contains all relevant information pertaining to terrestrial planets.
 * @author amyluo
 */
public class TerrestrialPlanet extends Planet {
    String core; //material of core
    
    /**
     * Constructor for terrestrial planet.
     * @param name Name of planet
     * @param mass Mass in kg
     * @param orbitLength Orbital period in earth days
     * @param distanceFromSun Distance to sun in AU
     * @param surfaceTemp Surface temperature of planet in K
     * @param volume Volume of planet in cubic km
     * @param core Contents of planet's core
     */
    public TerrestrialPlanet(String name, double mass, double orbitLength, double distanceFromSun, double surfaceTemp, double volume, String core) {
        super(name, mass, orbitLength, distanceFromSun, surfaceTemp, volume);
        this.core = core;
    }
    
    /**
     * Returns a formatted string of all planet info.
     * @return String of terrestrial planet info.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n   Mass (kg): " + mass + "\n   Orbital period (in Earth days): " + orbitLength + "\n   Distance from Sun (AU): " + distanceFromSun + "\n   Surface temperature (K): " + surfaceTemp + "\n   Volume (cubic km): " + volume + "\n   Material of core: " + core;
    }
    
    /**
     * Returns name and mass of planet.
     * @return name and mass
     */
    @Override
    String printMass() {
        return name + ": " + mass + " kg";
    }
    
    /**
     * Returns name and volume of planet.
     * @return name and volume.
     */
    @Override
    String printVolume() {
        return name + ": " + volume + " cubic km";
    }
    
    /**
     * Returns string of file-format ready planet information.
     * @return string of planet information in file format.
     */
    @Override
    String fileFormat() {
        return "Terrestrial\n" + name + "\n" + mass + "\n" + orbitLength + "\n" + distanceFromSun + "\n" + surfaceTemp + "\n" +  volume + "\n" + core + "\n\n";
    }
    
    /**
     * Information relating to contents of core.
     * @return core description.
     */
    @Override
    String coreInfo() {
        return core;
    }

    /**
     * Returns string of formatted core information.
     * @return name and core description.
     */
    @Override
    String printCore() {
        return name + ": " + core;
    }
    
    /**
     * Changes name of planet
     * @param newName New name
     */
    @Override
    void changeName(String newName) {
        this.name = newName;
    }
    
    /**
     * Changes the distance of the planet to the sun.
     * @param newDistance New distance.
     */
    @Override
    void changeDistance(double newDistance) {
        this.distanceFromSun = newDistance;
    }

}

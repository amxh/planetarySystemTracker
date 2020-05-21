package luoamy_planetarysystemtracker;

/**
 * Contains all abstract methods that relate to planets.
 * @author amyluo
 */
abstract class Planet {
    String name;
    double mass; //in earths
    double orbitLength; //orbital period
    double distanceFromSun; //in AU
    double surfaceTemp; //mean in Kelvin
    double volume; //in cubic km
    
    /**
     * Constructor of planet.
     * @param name Name of planet
     * @param mass Mass in kg
     * @param orbitLength Orbital period in earth days
     * @param distanceFromSun Distance from sun in AU
     * @param surfaceTemp Surface temperature in K
     * @param volume Volume in cubic km
     */
    public Planet (String name, double mass, double orbitLength, double distanceFromSun, double surfaceTemp, double volume) {
        this.name = name;
        this.mass = mass;
        this.orbitLength = orbitLength;
        this.distanceFromSun = distanceFromSun;
        this.surfaceTemp = surfaceTemp;
        this.volume = volume;
    }
    
    abstract String printMass();
    
    abstract String printVolume();
    
    abstract String fileFormat();
    
    abstract String coreInfo();
    
    abstract String printCore();
    
    abstract void changeName(String newName);
    
    abstract void changeDistance(double newDistance);
}

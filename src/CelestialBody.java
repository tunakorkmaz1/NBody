

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 *
 * If you add code here, add yourself as @author below
 *
 *
 */

public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		this.myXPos = xp;
		this.myYPos = yp;
		this.myXVel = xv;
		this.myYVel = yv;
		this.myMass = mass;
		this.myFileName = filename;


	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		return myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		return myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		return myXVel;
	}
	/**
	 * Accessor for the y-velocity.
	 * @return value of this object's y-velocity
	 */
	public double getYVel() {
		return myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		return myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
        double dx = b.myXPos - this.myXPos;  
        double dy = b.myYPos - this.myYPos;  
        
        double dxSquared = dx * dx; 
        double dySquared = dy * dy;  
        
        double distance = Math.sqrt(dxSquared + dySquared); 
        
        return distance;
  
	}

	public double calcForceExertedBy(CelestialBody b) {
		double G = 6.67*1e-11;
		double m1 = b.myMass;
		double m2 = this.myMass;
		double distance = calcDistance(b);
        double force;
        

        force = (G * m1 * m2) / (distance * distance); 
        return force;

	}

	public double calcForceExertedByX(CelestialBody b) {
		double dx = b.myXPos - myXPos;
		double force = calcForceExertedBy(b);
		double distance = calcDistance(b);
		double forceX = force * (dx / distance);

		return forceX;

	}
	public double calcForceExertedByY(CelestialBody b) {
		double dy= b.myYPos - myYPos;
		double force = calcForceExertedBy(b);
		double distance = calcDistance(b);
		double forceY = force * (dy / distance);
		return forceY;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
	    double netForceX = 0.0;

    for (CelestialBody b : bodies) {
        if (!this.equals(b)) { 
            netForceX += calcForceExertedByX(b);
        }
    }

    return netForceX;
}
	

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
	    double netForceY = 0.0;

    for (CelestialBody b : bodies) {
        if (!this.equals(b)) { 
            netForceY += calcForceExertedByY(b);}
        
    }

    return netForceY;
}
	

	/**
	 * This is a mutator method, modifies state of a celestial body
	 * (position and velocity)
	 * @param deltaT the time-step used in updating
	 * @param xforce the force in the x-direction
	 * @param yforce the force in the y-direction
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
	   double ax = xforce / myMass;
	   double ay = yforce / myMass;

	   double nvX = myXVel + ax * deltaT;
	   double nvY = myYVel + ay * deltaT;
	   
	   double nx = myXPos + nvX * deltaT;
	   double ny = myYPos + nvY * deltaT;
	   
	   myXPos = nx;
	   myYPos = ny;
	   myXVel = nvX;
	   myYVel = nvY;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}

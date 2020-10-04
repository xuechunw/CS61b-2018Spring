import java.lang.*;
import java.math.*; 

public class Planet {


	// public static void main(String[] args){


	// }

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.674*Math.pow(10,-11);

	//constructor one
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;

	}


	//constructor two
	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}


	//java TestCalcDistance
	public double calcDistance(Planet planet) {
		double x1 = planet.xxPos - this.xxPos;
		double y1 = planet.yyPos - this.yyPos;
		double distance = Math.sqrt(x1*x1+y1*y1);


		return distance;
	}

	public double calcForceExertedBy(Planet planet) {
		double distance = calcDistance(planet);
		double force = (G*(this.mass)*(planet.mass))/(distance*distance);
		// double forceX1 = ((this.xxPos-planet.yyPos)*force)/distance;
		// System.out.println("distance" + distance);
		return force;
	}

	public double calcForceExertedByX(Planet planet) {
		double distance = calcDistance(planet);
		double force = calcForceExertedBy(planet);
		double forceX = ((planet.xxPos-this.xxPos)*force)/distance;
		// System.out.println("distance" + distance);
		return forceX;
	}

	public double calcForceExertedByY(Planet planet) {
		double distance = calcDistance(planet);
		double force = calcForceExertedBy(planet);
		double forceY = ((planet.yyPos-this.yyPos)*force)/distance;
		// System.out.println("distance" + distance);
		return forceY;
	}

	public double calcNetForceExertedByX(Planet[] planet) {
		double sum = 0;
		int i;
		for(i=0; i<planet.length; i++){
			if(planet[i] == this)
			{
				continue;
			}
			double distance = calcDistance(planet[i]);
			System.out.println("distance" + distance);
			double force = calcForceExertedBy(planet[i]);
			double forceX = ((planet[i].xxPos-this.xxPos)*force)/distance;
			sum = sum + forceX;
			sum = new BigDecimal(sum).setScale(1, RoundingMode.DOWN).doubleValue();
		}
		
		// System.out.println("distance" + distance);
		return sum;
	}

	public double calcNetForceExertedByY(Planet[] planet) {
		double sum = 0;
		int i;

		for(i=0; i<planet.length; i++){
			if(planet[i] == this)
			{
				continue;
			}
			double distance = calcDistance(planet[i]);
			System.out.println("distance" + distance);
			double force = calcForceExertedBy(planet[i]);
			double forceY = ((planet[i].yyPos-this.yyPos)*force)/distance;
			sum = sum + forceY;
			sum = new BigDecimal(sum).setScale(1, RoundingMode.DOWN).doubleValue();
		}
		
		// System.out.println("distance" + distance);
		return sum;
	}

	public void update(double dt, double forceX, double forceY){

		double accelerationX = forceX/this.mass;
		double accelerationY = forceY/this.mass;
		xxVel = this.xxVel + dt*accelerationX;
		yyVel = this.yyVel + dt*accelerationY;
		xxPos = this.xxPos + dt*xxVel;
		yyPos = this.yyPos + dt*yyVel;

	}

	public static void draw(Planet[] planets) {
		int i;
		for(i=0;i<planets.length;i++) {
			StdDraw.picture(planets[i].xxPos, planets[i].yyPos, "images/"+planets[i].imgFileName);
			// System.out.println("images/"+planets[i].imgFileName);
		}

	}


}
import java.util.Scanner; 
import java.io.*; 


public class NBody {

	static public Integer readNumber(String fileName) {
		In in = new In(fileName);
		int numOfPlanets = in.readInt();

		return numOfPlanets;
	}

	static public double readRadius(String fileName) {
		In in = new In(fileName);
		int first = in.readInt();
		double second = in.readDouble();

		return second;
	}

	static public Planet[] readPlanets(String fileName) {
		In in = new In(fileName);

		int numOfPlanets = in.readInt();
		double second = in.readDouble();

		int i,j;
		int n = 1;
		double third, fourth, fifth, sixth, seventh;
		String eighth;
		Planet newPlanet;
		Planet[] planets = new Planet[numOfPlanets];

		for (j=0; j<numOfPlanets; j++) {
	
			third = in.readDouble();
			fourth = in.readDouble();
			fifth = in.readDouble();
			sixth = in.readDouble();
			seventh = in.readDouble();
			eighth = in.readString();

			newPlanet = new Planet(third, fourth, fifth, sixth, seventh, eighth);
			planets[j]=newPlanet;

		}

		return planets;

	}






		public static void main(String[] args){


			NBody nbody = new NBody();

			//Scanner scanner = new Scanner(System.in);
			// System.out.println("T:" + args[0]);
			//System.out.println("Enter T:");
			double T = Double.parseDouble(args[0]);  // Read user input
			//System.out.println("Enter dt:");
			// System.out.println("dt:" + args[1]);
			double dt = Double.parseDouble(args[1]); 
			//System.out.println("Enter Filename:");
			// System.out.println("Filename:" + args[2]);
			String filename = args[2]; 

			int numOfPlanets = nbody.readNumber(filename);
			double radius = nbody.readRadius(filename);
			Planet[] planets = nbody.readPlanets(filename);
			// scanner.close();

			/* first, set the scale so that it matches the radius of the universe. Then draw the image starfield.jpg as the background
			./data/planets.txt
			./data/bowling.txt
			*/

			// StdDraw.setXscale(0, radius); //bottom left to bottom right
			// StdDraw.setYscale(0, radius); //bottom left to upper left
			StdDraw.setScale(-radius,radius);
			StdDraw.picture(0, 0, "images/starfield.jpg",2*radius,2*radius); //centered
			Planet.draw(planets);

			 StdDraw.enableDoubleBuffering();

			Double[] xForces = new Double[numOfPlanets];
			Double[] yForces = new Double[numOfPlanets];


			StdDraw.picture(0, 0, "images/starfield.jpg",2*radius,2*radius);

			double time;

			for(time=0; time<=T;time=time+dt){
		
				for(int i=0; i<numOfPlanets;i++){
					// xForces[i] = planets[i].calcForceExertedByX(planets[i]);
					// yForces[i] = planets[i].calcForceExertedByY(planets[i]);
					xForces[i] = planets[i].calcNetForceExertedByX(planets);
					yForces[i] = planets[i].calcNetForceExertedByY(planets);

					// System.out.println("xPos:" + planets[i].xxPos);
					// System.out.println("yPos:" + planets[i].yyPos);
				}

				for(int j=0; j<numOfPlanets;j++){
					planets[j].update(dt,xForces[j],yForces[j]);
					// System.out.println("xforce after:" + planets[j].xxPos);
					// System.out.println("xforce after:" + planets[j].yyPos);
				}

				StdDraw.picture(0, 0, "images/starfield.jpg",2*radius,2*radius); //centered
				Planet.draw(planets);
				StdDraw.show();
				StdDraw.pause(20);

			 }

			 if(time==T){
			 	StdOut.printf("%d\n", planets.length);
				StdOut.printf("%.2e\n", radius);
				for (int i = 0; i < planets.length; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                 planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                 planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
				}

			 }


	}


}
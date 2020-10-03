import java.io.*;

public class HelloWorld {
	public static void main(String[] args) {
		
		drawTriangle(10);
		
		
	}


	public static void drawTriangle(int n) {
		int i,j;

		for(i=1; i<=n; i++) {
			for (j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();


		}


	}


}
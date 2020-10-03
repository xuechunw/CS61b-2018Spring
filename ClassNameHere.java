import java.io.*;

public class ClassNameHere {
	public static void main(String[] args) {
		
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6, 31, 2};
		System.out.println(max(numbers));
		
		
	}

/* returns the max value from m */
	// public static int max(int[] m) {
	// 		int max = m[0];
	// 		int i;

	// 		for (i=1;i < m.length; i++ ) {
	// 			if(max < m[i]) {
	// 				max = m[i];
	// 			}

	// 		}

	// 		return max;

	// 	}

	public static int max(int[] m) {
			int max = m[0];
			int i = 0;

			while (i< m.length) {
				if(max < m[i]) {
					max = m[i];
				}
				i += 1;
			}

			return max;

		}



}
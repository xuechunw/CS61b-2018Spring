public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /** your code here */ 
    int i,k = 0;
    int j = 0;
    int sum = 0;
    int[] newArray = {};

    for(i=0; i < a.length; i++) {

      if(a[i] < 0) {
        continue;
      }

      sum = 0;
      k = i+n;


      //must be a.length  -1
      if (a.length - 1 < k){
        k = a.length - 1;
      }

      for(j=i; j<=k; j++) {
        sum = sum + a[j];
      } 
        a[i] = sum;

    }

  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}
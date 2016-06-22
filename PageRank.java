import java.util.Scanner;
public class PageRank {
	private static Scanner in;

	public static double[] product(double [][] A, double[] v){
		double[] result = new double[v.length]; 
		double a = 0;
		
		for(int i = 0; i <A[0].length;i++){
			for(int j = 0; j<A.length; j++){
				a += A[i][j]*v[j];
			}
			result[i] = a;
			
		}
		return result;
	}
	
	public static void main(String []args){
		  int m, n ;
	      in = new Scanner(System.in);
	 
	      System.out.println("Shkruaj numrin e rreshtave dhe kolonave te matrices");
	      m = in.nextInt();
	      n  = in.nextInt();
	 
	      double matrix[][] = new double[m][n];	 
	      System.out.println("Shkruaj elementet e matrices");
	      for ( int c = 0 ; c < m ; c++ )
	         for ( int d = 0 ; d < n ; d++ )
	            matrix[c][d] = in.nextDouble();
	      System.out.println("Shkruani nr. e faqeve qe deshironi te llogaritni 'PageRank'");
	      m = in.nextInt();
	      double l = 1/m;
	      double vector[] = new double[m];
	      for(int i=0; i<m;i++){
	    	  vector[m]=l;
	      }
	      
	    	  double[] v = product(matrix,vector);
	    	  
	      System.out.print("PageRank Vector:");
	      for(int i =0; i<v.length; i++)
	    	  System.out.println(v[i]+" ");
	      
	}
}


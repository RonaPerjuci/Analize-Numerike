
import javax.swing.*;
public class EnkriptimiDekriptimi {
public double[][] enkriptimi(char[][] m)
{
	double[][] m1=new double[3][3];
	for(int i=0;i<m1.length;i++)
	{for(int j=0;j<m1[0].length;j++)
	 {m1[i][j]=Math.pow(m[i][j],2)+2*m[i][j]-3;}}
	return m1;
}
public char[][] dekriptimi(double[][] m)
{
	char[][] m1=new char[3][3];
	for(int i=0;i<m1.length;i++)
	{for(int j=0;j<m1[0].length;j++)
	 {m1[i][j]=(char)(-1+Math.sqrt(m[i][j]+4));}}
	return m1;
}

    public static void main(String[] args)
    {EnkriptimiDekriptimi obj=new EnkriptimiDekriptimi();
     char[][] mc=new char[3][3];
     String s =JOptionPane.showInputDialog("Shkruaje nje fjale me 9 shkronja").trim().toLowerCase();
     if(s.length()!=9)
     {System.out.println("Error:bad input");
      System.exit(0);
     }
     
     int index=0;
     while(index<s.length())
     {
     for(int i=0;i<mc.length;i++)
  	  { for(int j=0;j<mc[0].length;j++)
        { 
           mc[i][j]=s.charAt(index);
  	       index++;
  	    }
      }
     }
     double[][] mn=obj.enkriptimi(mc);
     
     for(int i=0;i<mn.length;i++)
 	{ for(int j=0;j<mn[0].length;j++)
        {System.out.print(mn[i][j]+ "  ");}
 	     System.out.println();
 	}

     System.out.println("\nDekriptimi\n");
     
     
     mc=obj.dekriptimi(mn);
		for(int i=0;i<mc.length;i++)
	 	{for(int j=0;j<mc[0].length;j++)
	       {System.out.print(mc[i][j]+ "  ");}
	 	    System.out.println();
	 	}
}}


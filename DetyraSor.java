import javax.management.RuntimeErrorException;
import javax.swing.*;

public class DetyraSor

{
        public static double [] x;

         public static double[] zbritjaeVektoreve(double[] v1, double[] v2)
            {

                 double[] v = new double[v1.length];
                 for (int i = 0; i < v1.length; i++)
                {
                      v[i] = v1[i] - v2[i];
                }

              return v;
             }


    public static double distancaMaksimale(double[] x,double[] y)
    {
        double[] k = zbritjaeVektoreve(x,y);
        double max = Math.abs(k[0]);

        for (int i = 0; i < x.length; i++)
        {
            if (Math.abs(k[i]) > max)
            {
                max = Math.abs(k[i]);
            }
        }

        return max;
    }


    public static double[] Sor(int n, double[][] c, double[] x0, double w, double tol, int maxN)
    {
        x = new double[n];
        int k = 1;

         while (k <= maxN)
         {
            double s = 0;

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (j != i)
                    {

                        s += -(c[i][j]) * x0[j];

                    }
                }

                s = s + c[i][c[0].length-1];

                x[i] = (1 - w) * x0[i] + (w * s) / c[i][i];
                s = 0;

                if (distancaMaksimale(x, x0) < tol)
                {
                    return x;
                }

                x0[i] = x[i];

            }

            k++;

        }


        throw new RuntimeException("Solution not found!");

    }

    public static void main(String[] args) {

        int n = new Integer(JOptionPane.showInputDialog("Number of the equations and the unknowns:")).intValue();
        double[] x0 = new double[n];
        int i = 0;
        while (i < n) {
            x0[i] = new Double(JOptionPane.showInputDialog("XO " + (i+1))).doubleValue();
            i++;
        }
        double[][] c = new double[n][n + 1];

        for (i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length-1; j++) {
                c[i][j] = new Double(JOptionPane.showInputDialog("Type coefficient a" + (i+1) + "" + (j+1))).doubleValue();
            }
        }

        for(i=0;i<c.length;i++)

        {
            c[i][c.length] = new Double(JOptionPane.showInputDialog("Type b" + (i+1) )).doubleValue();
        }

        double tol = 1E-3;
        int maxN = 50;
        double w = 1.25;

        Sor(n, c, x0, w, tol, maxN);
        for (i = 0; i < n; i++) {
            System.out.print("x[" + (i+1) + "]" + " = " + x[i]);
            System.out.println();
        }
    }}





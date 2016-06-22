package numeric;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
public class Leslie {
    private static Scanner in;

    public static double[][] lesliematrix(int[] b,double [] p)
    { double [][] m=new double[b.length][b.length];
        for(int i=0;i<b.length;i++)
        { m[0][i]=b[i];}
        for(int i=0;i<p.length;i++)
        {m[i+1][i]=p[i];}
        return m;}

    public static double[] product(double[][] A, double[] B)
    {   double[] rez= new double[A.length];
        double shuma = 0;
        for(int i =0; i<A.length;i++)
        {
            for(int j=0; j<B.length;j++)
            {
                shuma =shuma + A[i][j]*B[j];
            }
            rez[i]= (int)shuma;
            shuma = 0;
        }
        return rez;
    }

    public static void main(String[] args)
    {
        in = new Scanner(System.in);
        System.out.println("Sa klasa te moshave jane?");
        int n=in.nextInt();
        int[] vektori=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Sa anetare i permban klasa  " + (i+1) + "?");
            vektori[i]=in.nextInt();
        }
        System.out.println("Vektori i moshes eshte: " + Arrays.toString(vektori));
        int[] b=new int[n];
        for(int i=0;i<b.length;i++)
        {
            System.out.println("Sa pasardhes mund te prodhojne mesatarisht anetaret e klases " +(i+1)+ "?");
            b[i]=in.nextInt();

        }
        System.out.println("Vektori: " + Arrays.toString(b));
        double[] p=new double[n-1];
        for(int i=0;i<p.length;i++)
        {
            System.out.println("Sa eshte probabiliteti qe anetari i klases " +(i+1)+ " te mbijetoje per tu bere anetar i klases "+(i+2) + "?");
            p[i]=in.nextDouble
                    ();
        }
        System.out.println("Vektori: " + Arrays.toString(p));
        double[][] A=lesliematrix(b,p);
        System.out.println();
        System.out.println("Matrica e moshes(Leslie Matrix):");
        for(int i=0;i<A.length;i++)
        {for(int j=0;j<A.length;j++)
        {System.out.print(A[i][j] + " ");}
            System.out.println();
        }
        System.out.println();
        System.out.println("Polinomi karakteristik:");
        for(int i=0;i<A.length;i++)

        {	System.out.print("|");
            for(int j=0;j<A.length;j++)
            {	String s = "      ";
                if(j==2)
                {s="|";}
                if(i==j )
                {	if(A[i][j]==0)
                {System.out.print("-L" + s);}
                else
                {System.out.print(A[i][j] + "-L   ");}
                }
                else{System.out.print(A[i][j] + s);}
            }

            System.out.println();



        }

        ZerotEPolinomeve obj = new ZerotEPolinomeve();
        System.out.println();
        double[] L = obj.zerot();
        double[][] B = new double[A.length][A.length];
        for(int i =0; i<A.length;i++)
        {
            for(int j = 0; j<A.length;j++)
            {
                if(i==j)
                {
                   B[i][j]= A[i][j]-L[1];
                }
                else
                    B[i][j]=A[i][j];
            }
        }
        double t =2;
        double[] x = {16*t,4*t,1*t};
        int y = new Integer(JOptionPane.showInputDialog("Pas sa vitesh deshironi te shihni gjendjen e popullates")).intValue();
        for(int a =1; a<y;a++)
        {
            double[] temp = product(A,x);
            x = temp;
        }
        System.out.println();
        System.out.println("Gjendja e popullates pas "+y+" vitesh");
        System.out.println(Arrays.toString(x));
    }
}

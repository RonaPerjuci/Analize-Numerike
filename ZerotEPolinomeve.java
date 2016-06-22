package numeric;
import javax.swing.*;
import numeric.AlgebraicPolynomial;
import java.text.*;

public class ZerotEPolinomeve

{


    public static double[] multiply (double[] A,double[] B)
    {

        double result []= new double [A.length+B.length-1];

        double d [][]= new double [A.length][B.length];

        int index=A.length-1;

        while(index >=0)

        {

            for(int i = B.length-1; i>=0; i--)
            {

                d[index][i]=A[index]*B[i];
                result[index+i]=result[index+i]+d[index][i];

            }
            index--;
        }


        return result;

    }

    public double[] zerot()
    {   int degreeA=new Integer(JOptionPane.showInputDialog("Shkalla e polinomit te pare")).intValue();
        double A [] = new double[degreeA+1];
        for(int i=degreeA;i>=0;i--)
        { double antaretA= new Double(JOptionPane.showInputDialog("Shenoji koeficientat e polinomit te pare")).doubleValue();
            A[i]=antaretA;


        }

        int degreeB=new Integer(JOptionPane.showInputDialog("Shkalla e polinomit te dyte")).intValue();
        double B [] = new double[degreeB+1];
        for(int i=degreeB;i>=0;i--)
        { double antaretB= new Double(JOptionPane.showInputDialog("Shenoji koeficientat e polinomit te dyte")).doubleValue();
            B[i]=antaretB;

        }

        double [] multiplication=multiply(A,B);
        int degreeC=new Integer(JOptionPane.showInputDialog("Shkalla e polinomit te trete")).intValue();
        double C [] = new double[degreeC+1];
        for(int i=degreeC;i>=0;i--)
        { double antaretC= new Double(JOptionPane.showInputDialog("Shenoji koeficientat e polinomit te trete")).doubleValue();
            C[i]=antaretC;
        }

        double [] coeff=multiply(multiplication,C);
        AlgebraicPolynomial p = new AlgebraicPolynomial(coeff);
        double[] w = {-2,2};
        double[] x1 = new double[w.length];
        double tol=1E-10;
        for(int i = 0; i<w.length;i++)
        {
            do {
                AlgebraicPolynomial q = p.horner(w[i]);
                x1[i] = w[i] - (p.value(w[i]) / p.derivative(w[i]));
                w[i] = x1[i];
            }

            while(p.value(w[i])<-tol||p.value(w[i])>tol);

            DecimalFormat f = new DecimalFormat("0.0");
            System.out.println(" Vlera karakteristike " + f.format(w[i]));
        }
        return w;
    }

}
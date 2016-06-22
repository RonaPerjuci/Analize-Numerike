
public class Newton
{

    public static double[][] function(double[][] XO)
    {
        double[][] x = new double[3][3];
        x[0][0] = 3.0 * XO[0][0] - Math.cos(XO[1][0] * XO[2][0]) - 1.0 / 2;
        x[1][0] = XO[0][0] * XO[0][0] - 81.0 * Math.pow(XO[1][0] + 0.1, 2) + Math.sin(XO[2][0]) + 1.06;
        x[2][0] = Math.exp(-XO[0][0] * XO[1][0]) + 20.0 * XO[2][0] + (10 * Math.PI - 3) / 3.0;

        return x;
    }


    public static double[][] FDerivative(double[][] XO)
    {
        double[][] d = new double[3][3];
        d[0][0] = 3;
        d[0][1] = XO[2][0] * Math.sin(XO[1][0] * XO[2][0]);
        d[0][2] = XO[1][0] * Math.sin(XO[1][0] * XO[2][0]);
        d[1][0] = 2 * XO[0][0];
        d[1][1] = -162 * (XO[1][0] + 0.1);
        d[1][2] = Math.cos(XO[2][0]);
        d[2][0] = -1 * XO[1][0] * Math.exp(-1 * XO[0][0] * XO[1][0]);
        d[2][1] = -1 * XO[0][0] * Math.exp(-1 * XO[0][0] * XO[1][0]);
        d[2][2] = 20;

        return d;
    }

    public static double[][] MatrixInverse(double[][] m) {
        double[][] I = new double[3][3];
        double det = m[0][0] * m[1][1] * m[2][2] + m[0][2] * m[1][0] * m[2][1] + m[2][0] * m[1][2] * m[0][1]
                - m[2][0] * m[1][1] * m[0][2] - m[2][2] * m[1][0] * m[0][1] - m[0][0] * m[2][1] * m[1][2];

        I[0][0] = 1 / det * (m[1][1] * m[2][2] - m[2][1] * m[1][2]);
        I[0][1] = 1 / det * (m[0][2] * m[2][1] - m[2][2] * m[0][1]);
        I[0][2] = 1 / det * (m[0][1] * m[1][2] - m[1][1] * m[0][2]);
        I[1][0] = 1 / det * (m[1][2] * m[2][0] - m[2][2] * m[1][0]);
        I[1][1] = 1 / det * (m[0][0] * m[2][2] - m[2][0] * m[0][2]);
        I[1][2] = 1 / det * (m[0][2] * m[1][0] - m[1][2] * m[0][0]);
        I[2][0] = 1 / det * (m[1][0] * m[2][1] - m[2][0] * m[1][1]);
        I[2][1] = 1 / det * (m[0][1] * m[2][0] - m[2][1] * m[0][0]);
        I[2][2] = 1 / det * (m[0][0] * m[1][1] - m[1][0] * m[0][1]);

        return I;
    }

    public static double[][] MatrixSub(double[][] a, double[][] b)
    {
        double[][] c = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    public static double[][] MatrixMultiplication(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] = c[i][j] +(a[i][k] * b[k][j]);
                }
            }
        }
        return c;
    }

    public static double EuclidianNorm(double[] v)
    {
        double n = 0;
        double result = 0;
        for (int i = 0; i < v.length; i++)
        {

            n = n + v[i] * v[i];

        }
        result = Math.sqrt(n);

        return result;

    }


    public static double[][] newtonMethod(int N, double[][] XO, double TOL) {
        double[][] Fx = new double[XO.length][XO.length];
        int k = 1;
        while (k <= N) {
            double[][] inversedJ = MatrixInverse(FDerivative(XO));
            Fx = MatrixMultiplication(inversedJ, function(XO));
            XO = MatrixSub(XO, Fx);
            double[] y = { Fx[0][0], Fx[1][0], Fx[2][0] };
            if (EuclidianNorm(y) < TOL) {
                return XO;
            }
            k++;
        }
        return XO;
    }
    public static void main(String[] args) {
        double[][] a = { { 0.1, 0, 0 }, { 0.1, 0, 0 }, { -0.1, 0, 0 } };
        double[][] x = newtonMethod(10, a, 0.000001);
        System.out.println("x1: " + x[0][0]);
        System.out.println("x2: " + x[1][0]);
        System.out.println("x3: " + x[2][0]);

    }
}


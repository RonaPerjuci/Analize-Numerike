import javax.swing.*;
public class Normat {
public double[] vektori(int n)
{double[] vektori=new double[n];
 return vektori;
}

public double[] inicializimiivektorit(double[] vector)
{ for(int i=0;i<vector.length;i++)
{ double value=new Double(JOptionPane.showInputDialog("Elementi  " + (i+1) + " eshte" )).doubleValue();
  vector[i]=value;
}
return vector;
}

public double[] shumaevektoreve(double[] v1,double[] v2)
{  double[] v=new double[v1.length];
 for(int i=0;i<v1.length;i++)
 {v[i]=v1[i]+v2[i];}
return v;
}

public double[] ndryshimiivektoreve(double[] v1,double[] v2)
{  double[] v=new double[v1.length];
 for(int i=0;i<v1.length;i++)
 {v[i]=v1[i]-v2[i];}
return v;
}

public double infinitnorm(double[] v)
{  double maksimumi=Math.abs(v[0]);
 for(int i=0;i<v.length-1;i++)
 {if(Math.abs(v[i+1])>maksimumi)
  { maksimumi=Math.abs(v[i+1]);}
 }
return maksimumi;
}

public double l2norm(double[] v)
{  double shuma=0;
 for(int i=0;i<v.length;i++)
 {
  shuma=shuma+Math.pow(v[i],2);
 }
return Math.sqrt(shuma);
}

public double distancaeuklidiane(double[] v1,double[] v2)
{  double shuma=0;
 for(int i=0;i<v1.length;i++)
 {
  shuma=shuma+Math.pow(ndryshimiivektoreve(v1,v2)[i],2);
 }
return Math.sqrt(shuma);
}

public double distancamaksimale(double[] v1,double[] v2)
{  double maksimumi=Math.abs(ndryshimiivektoreve(v1,v2)[0]);
 for(int i=0;i<v1.length-1;i++)
 {if(Math.abs(ndryshimiivektoreve(v1,v2)[i+1])>maksimumi)
  { maksimumi=ndryshimiivektoreve(v1,v2)[i+1];}
 }
return maksimumi;
}

public double[][] matrica(int n)
{double[][] matrica=new double[n][n];
 return matrica;
}

public double[][] inicializimiimatrices(double[][] matrica)
{ for(int i=0;i<matrica.length;i++)
{for(int j=0;j<matrica.length;j++)
{ double value=new Double(JOptionPane.showInputDialog("Elementi  " + (i+1) + "" + (j+1) + " eshte" )).doubleValue();
  matrica[i][j]=value;
}}
return matrica;
}


public double infinitMnorm(double[][] m)
{ double[] v=new double[m.length];
  double maksimumi=v[0];
  for(int i=0;i<m.length;i++)
  {for(int j=0;j<m.length;j++)
  { 
    v[i]=v[i]+Math.abs(m[i][j]);
  }}
  for(int i=0;i<v.length-1;i++)
  { if(v[i+1]>maksimumi)
    {maksimumi=v[i+1];}
  }
  return maksimumi;
}
public double frobeniusnorm(double[][] m)
{ double shuma=0;
 for(int i=0;i<m.length;i++)
 {for(int j=0;j<m.length;j++)
  shuma=shuma+Math.pow(Math.abs(m[i][j]),2);
 }
return Math.sqrt(shuma);
}

public static void main(String[] args)
{ Normat obj=new Normat();
 int n=new Integer(JOptionPane.showInputDialog("Gjatesia e vektorit" )).intValue();
 double[] v1=obj.inicializimiivektorit(obj.vektori(n));
 System.out.println("Vektori 1");
 for(int i=0;i<v1.length;i++)
 {System.out.println(v1[i]);}
 System.out.println();
 System.out.println("Vektori 2");
 JOptionPane.showMessageDialog(null,"Vektori i dyte");
 double[] v2=obj.inicializimiivektorit(obj.vektori(n));
 for(int i=0;i<v2.length;i++)
 {System.out.println(v2[i]);}
 System.out.println();
 System.out.println("Shuma e vektoreve");
 double[] shuma=obj.shumaevektoreve(v1,v2);
 for(int i=0;i<v1.length;i++)
 {System.out.println(shuma[i]);}
 System.out.println();
 System.out.println("Ndryshimi i vektoreve");
 double[] ndryshimi=obj.ndryshimiivektoreve(v1,v2);
 for(int i=0;i<v1.length;i++)
 {System.out.println(ndryshimi[i]);}
 System.out.println();
 System.out.println("Norma l2: " + obj.l2norm(v1));
 System.out.println("Norma infinit e vektorit: " + obj.infinitnorm(v1));
 System.out.println("Distanca euklidiane: " + obj.distancaeuklidiane(v1,v2));
 System.out.println("Distanca maksimale " + obj.distancamaksimale(v1,v2));
 System.out.println();
 
 int p=new Integer(JOptionPane.showInputDialog("Rendi i matrices:")).intValue();
 double[][] m=obj.inicializimiimatrices(obj.matrica(p));
 System.out.println("Matrica:");
 for(int i=0;i<m.length;i++)
 {for(int j=0;j<m.length;j++)
 { 
	 System.out.print(m[i][j] + " ");
 }
 System.out.println();}
 System.out.println("Norma infinit e matrices: " + obj.infinitMnorm(m));
 System.out.println("Norma Frobenius e matrices: " + obj.frobeniusnorm(m));
}}



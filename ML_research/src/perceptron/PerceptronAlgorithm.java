package perceptron;

import java.util.ArrayList;

public class PerceptronAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			double[] a={1.2,2,3};
			double[] b={4,5,6};
			
			double r=dot_product(a, b);
			System.out.println(r);
			
			
			double[][] w={{1,2.0,2.0,3.0,4.0},{1.2,2.0,2.0,3.0,4.0},{1.2,2.0,2.0,3.0,4.0},{1.2,2.0,2.0,3.0,4.0},{1.2,2.0,2.0,3.0,4.0}};
			double[] re=average_weight(w);
			for(double x:re){
			System.out.println(x);
			}
	
	}
	
	
	public double[] getWeightVector(double[][] data, double[][] weight, double[] y) {
		double[] y_estimate=new double[y.length];

		double lambda=0.5;
		for(int i=0;i<=data.length-1;i++){
			y_estimate[i]=dot_product(weight[i], data[i]);
			if(y_estimate[i]!=y[i]){
				for(int j=0;j<=weight[0].length-1;j++){
					weight[i][j]=weight[i][j]+lambda*(y[i]-y_estimate[i])*data[i][j];
				}
			}
		}
		double[] result=average_weight(weight);
		return result;	
}
	
	public static double dot_product(double[] a,double[] b){
		double sum=0;
		for(int i=0;i<=a.length-1;i++){
			sum+=a[i]*b[i];
		}
		return sum;
	}
	
	public static double[] average_weight(double[][] w){
		double[] r=new double[w[0].length];
		for(int j=0;j<=w[0].length-1;j++){
			double sum=0;
			for(int i=0;i<=w.length-1;i++){
				sum+=w[i][j];	
			}
			r[j]=sum/w.length;
		}
		return r;
	}
	
}

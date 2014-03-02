//============================================================================
// Name  Guifan Li      : Study.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Perceptron algorithm in C++, Ansi-style
//============================================================================
#ifndef STUDY
#define STUDY
#include <vector>
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include "Study.h"
#include <math.h>

#endif
using namespace std;
using std:: vector;
void vector_test();
Tuple extract_value(string);
vector<Tuple> read_into_tuples(string);
double h_theta(double theta[],vector<Tuple> X);
void update_theta_square_loss(double theta[],int size,double learning_rate,int y, vector<Tuple> path);
void update_theta_logistic_loss(double theta[],int size,double learning_rate,int y, vector<Tuple> path);



int main(){
	 const int SAMPLE_SIZE=40000;
	 const int MAX_ITER=50000;
	 const double learning_rate=0.1;
	 const int len=50000;
	 int counter=0;
	 int n=0;
	 double theta[len];
	 vector<int> y_set;
	 vector< vector<Tuple> > alldata;
	 srand(time(NULL));
	 int x = rand()%SAMPLE_SIZE+1;

	 ifstream reader("/Users/liguifan/Desktop/data/rcv1-train.vw");
	 clock_t t;
	 t=clock();
	 string tempstr="";
	 if(reader.is_open())
	 while (getline(reader, tempstr))
	 {
		 vector<Tuple> path=read_into_tuples(tempstr);
		 alldata.push_back(path);
		 int y_original=tempstr.at(0)-48;
		 int y_after=(y_original)>0?1:-1;
		 y_set.push_back(y_after);
		 counter++;
		 if(counter%SAMPLE_SIZE==0){
			 for(int i=0;i<=MAX_ITER;i++){
				 n=rand()%SAMPLE_SIZE;
				 //cout<<n<< endl;
				 update_theta_logistic_loss(theta,len,learning_rate,y_set.at(n),alldata.at(n));
			 }
			 alldata.clear();
			 y_set.clear();

		 }

	 }
	 reader.close();
	 t = clock() - t;
	 printf ("It took me %d clicks (%f seconds).\n",t,((float)t)/CLOCKS_PER_SEC);
	 return 0;
}
vector<Tuple> read_into_tuples(string line){

		 vector<Tuple> set;
		 string valid_line=line.substr(12,line.length()-10);
		 istringstream buf (valid_line);
		 istream_iterator<string> beg (buf), end;
		 vector<string> tokens(beg, end);

		 for(string s: tokens){
		 	        Tuple temp=extract_value(s);
//		 	        cout<< temp.index<<" is "<<temp.value<<endl;
		 	        set.push_back(temp);
		 }
		 return set;
	 }

Tuple extract_value(string single){
	string new_str=single.substr(1,single.length());
	string delimiter = ":";
	string token1 = new_str.substr(0, new_str.find(delimiter));
	string token2 = new_str.substr(new_str.find(delimiter)+1,new_str.length());
	int index=atoi(token1.c_str());
	double value=atof(token2.c_str());
	return Tuple(index,value);
}



double h_theta(double theta[],vector<Tuple> X){
	double sum=0;
	for(Tuple x:X){
		sum+=theta[x.index]*x.value;
	}
	return sum;
}

void vector_test(){
	vector<string> test;
			test.push_back("liguifan");
			test.push_back("liguifan2");
			for(int i=0;i<=test.size()-1;i++){
				cout<<test.at(i)<<"\n";
			}
			cout<<endl;
}

double sparse_dot_product(double weight[], vector<Tuple> tuple){
	double sum=0;
	for(Tuple x:tuple){
		sum+=weight[x.index]*x.value;
	}
	return sum;
}

void update_theta_square_loss(double theta[],int size,double learning_rate,int y, vector<Tuple> path){
	double diff=y-sparse_dot_product(theta, path);
	for(Tuple x:path){
		theta[x.index]+=learning_rate*diff*x.value;
		}
	}


void update_theta_logistic_loss(double theta[],int size,double learning_rate,int y, vector<Tuple> path){
		double term=y*sparse_dot_product(theta, path);
		for(Tuple x:path){
			theta[x.index]+=y*(exp(-term)/(1+exp(-term)))*x.value;
		}
	}

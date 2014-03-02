//============================================================================
// Name        : TestC.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <iterator>


using namespace std;
void update_theta_square_loss(double theta[],int size);
template <class liguifan>
liguifan addtwo(liguifan a , liguifan b){
	 return a+b	;
}


int main() {
//	string new_str="234";
//	string delimiter=":";
//	string token1 = new_str.substr(0, new_str.find(delimiter));
//	string token2 = new_str.substr(new_str.find(delimiter)+1,new_str.length());
//	cout<<token1<<"   "<<token2<<endl;
		double x[3]={1,2,3};
		update_theta_square_loss(x,3);
		cout<< x[1]<<endl;

		double a=4.3;
		double b=3.4;
		int a1=5;
		int a2=6;
		cout<< addtwo(a1,a2)<<endl;
}
void update_theta_square_loss(double theta[],int size){

		theta[1]=5;
		theta[2]=6;
	}

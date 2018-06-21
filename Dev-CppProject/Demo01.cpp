#include<stdio.h>
int d= 1;
void fun(int p){
	int d=5;
	p=d;
	printf("%d",p);
} 
int main(){
	int a=3;
	fun(a);
	d=a;
	printf("%d\n",d);
}

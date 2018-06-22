#include<stdio.h>
int main(){
	int a[4][3]={1,2,3,4,5,6,7,8,9,10,11,12};
  	int(*ptr)[3]=a,*p=a[0];
  	printf("%d,%d,%d,%d",(*ptr+1)+2,(*(ptr+1))[2],*(*(a+1)+2),a[1][2]);
  	return 0;
} 

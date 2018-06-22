#include<stdio.h>
int main(){
	int i,j, row=0,colum=0,min;
	//这里理解为a[3][4]的一个二维数组 
	int a[][4]={{1,2,3,4},{9,8,7,6},{-10,10,-5,2}};
	//定义一开始最小的一个数为a[0][0],即为数组中的第一个数 
	min=a[0][0];
	for(i=0;i<3;i++) //或者i<=2 
		for(j=0;j<4;j++)
			if(min>a[i][j]){//用当前的min值和a[i][j]依次比较 
				min=a[i][j];
				row=i;
				colum=j;
			}
	printf("min=%d\nrow=%d\ncolum=%d\n",min,row,colum);
	return 0;
} 

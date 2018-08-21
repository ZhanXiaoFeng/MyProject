package com.zrf.ex;

/*a->b b->e e->t t->a
f(n)=n+7 26
f-1(n)=n+19

f(n)=5*n+7
解密函数：g(n)=(f(n)-7)/5  -- 21*n+19


(n-1)(m-1)
*/
public class MyFilter {
	public static void main(String args[]) {
		MyFilter mf = new MyFilter();
		mf.isPrime(1);
		mf.isPrime(65536);
	}

	public void isPrime(int num) {
		if (num < 2) {
			System.out.println("数据不合法");
			return;
		}

		int[] arr = new int[num + 1];
		// 0,1,2,3,4,5,6,7,8,9,10
		for (int i = 0; i < arr.length; i++) {

			arr[i] = i;
		}

		for (int i = 2; i < arr.length; i++) {
			for (int j = i + i; j < arr.length; j += i) {
				arr[j] = 0;
			}

			if (arr[num] == 0) {
				break;
			}
		}

		if (arr[num] == 0) {
			System.out.println("合数");
		} else {
			System.out.println("素数");
		}
	}
}
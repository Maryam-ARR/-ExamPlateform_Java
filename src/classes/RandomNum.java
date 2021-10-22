package classes;

import java.security.SecureRandom;

public class RandomNum {
	
	static int[] RandomNum(int n) {
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=i+1;
		}
		int[]result=new int[n];
		int j=n;
		SecureRandom Sr=new SecureRandom();
		for(int i=0;i<n;i++) {
			int k=Sr.nextInt(j);
			result[i]=a[k];
			a[k]=a[j-1];
			j--;
		}
		return result;
		}

	public static void main(String[] args) {
		int[]result=RandomNum(10);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}

}

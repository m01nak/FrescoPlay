package com.moinak.javaMasterclass.Packages.code.numbers;

import java.util.ArrayList;
import java.util.Collections;

public class NumberFinder {
	public static boolean isKeith(String numberString) {

		int n = Integer.parseInt(numberString);
		int n1 = n;
		String s = Integer.toString(n);
		int d = s.length();
		int arr[] = new int[n];
		int i, sum;
		for (i = d - 1; i >= 0; i--) {
			arr[i] = n1 % 10;
			n1 = n1 / 10;

		}

		i = d;
		sum = 0;
		while (sum < n) {
			sum = 0;
			for (int j = 1; j <= d; j++) {
				sum = sum + arr[i - j];
			}
			arr[i] = sum;
			i++;
		}

		if (sum == n) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPrime(String numberString) {
		int num = Integer.parseInt(numberString);
		boolean flag = false;
		for (int i = 2; i <= num / 2; ++i) {
			if (num % i == 0) {
				flag = true;
				break;
			}
		}

		return flag;
	}
}

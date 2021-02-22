package com.hy.shortmessage.common.algorithms;


import com.hy.shortmessage.common.idcenter.Idproduce;

public class Base62And10 {

	private static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static String toBase62(long num) {
		final StringBuilder sb = new StringBuilder();
		final int targetBase = BASE.length();
		do {
			final int i = (int) (num % targetBase);
			sb.append(BASE.charAt(i));
			num /= targetBase;
		} while (num > 0);

		return sb.reverse().toString();
	}

	public static long toBase10(String input) {
		final int srcBase = BASE.length();
		long id = 0;
		final String r = new StringBuilder(input).reverse().toString();

		for (int i = 0; i < r.length(); i++) {
			final int charIndex = BASE.indexOf(r.charAt(i));
			id += charIndex * (long) Math.pow(srcBase, i);
		}

		return id;
	}

	public static void main(String args[]) {
		final long id = Idproduce.getIdwork().getId();
		System.out.println(id);
		final String base62 = Base62And10.toBase62(id);
		System.out.println(base62);
		final long base10 = Base62And10.toBase10(base62);
		System.out.println(base10);
	}

}

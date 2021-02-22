package com.hy.shortmessage.common.idcenter;

public class Idproduce {

	private static IdWorker idWorker = new IdWorker(System.currentTimeMillis() - 3600 * 1000L);

	private Idproduce() {
	}

	public static IdWorker getIdwork() {
		//return new IdWorker(System.currentTimeMillis() - 3600 * 1000L); 
		return idWorker;
	}

	public static void main(String args[]) {
		for (int i = 0; i < 10; i++) {
		long id=	Idproduce.getIdwork().getId();
		System.out.println(id);
		}

	}

}

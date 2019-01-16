package com.study.jvm.ieee;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/18 10:08]
 */
public class IEEEPro {

	public static void main(String[] args) {
		float numf = 0.5F;
		System.out.println("FLOAT_3.75  =" + Integer.toBinaryString(Float.floatToIntBits(numf)));

		int exp = 0B0_0000_0000_0000_0000_0000_0000_0000_000;
		System.out.println(Float.intBitsToFloat(exp) == 0.0F);

		System.out.println("DOUBLE_1.51 =" + Long.toBinaryString(Double.doubleToLongBits(1.51)));

		double price1 = 1.51, price2 = 1.38;
		System.out.println("DOUBLE_SUB = " + (price1 - price2));
	}

}

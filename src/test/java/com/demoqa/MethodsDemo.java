package com.demoqa;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodsDemo d = new MethodsDemo();
		String name = d.getData();
		String name1= getData1();
		System.out.println(name);
		System.out.println(name1);
		getData1();

		// Calling MethodsDemo2 class in this class MethodsDemo

		MethodsDemo2 d1 = new MethodsDemo2();
		System.out.println(d1.getUserData());

	}

	public String getData() {
		System.out.println("This is a method");
		return "Ram marshivane";

	}

	public static String getData1() {
		System.out.println("This is a static method");
		return "Ram marshivane from a static method";

	}
}

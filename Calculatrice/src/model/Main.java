package model;

public class Main {
	public static void main(String args[]) {
		System.out.println("Hello World");
		CalculatorModel Pile = new CalculatorModel();
		Pile.push(3.0);
		Pile.push(5.0);
		Pile.drop();
		Pile.opposite();
		Double c=Pile.pop();
		System.out.println(c);
		
	}

}

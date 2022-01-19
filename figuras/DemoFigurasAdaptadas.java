package figuras;

import java.util.ArrayList;

public class DemoFigurasAdaptadas {
	
	public static void main(String[] args) {
		
		ArrayList<Figura> l = new ArrayList<Figura>();
		Figura rectangulo = new FiguraAdaptador(new Rectangulo(-5.0, -5.0, 3.0, 2.0));
		Figura circulo = new FiguraAdaptador(new Circulo(5.0, 10.0, 2.0));
		Figura elipse = new FiguraAdaptador(new Elipse(1.5, 3.0, 10.0,5.0));
		
		l.add(elipse);
		l.add(rectangulo);
		l.add(circulo);
		
		System.out.println("AÅreas desordenadas");

		for (Figura f: l) {
			System.out.println(f.getArea());
		}
		System.out.println("Areas ordenadas");
		l.sort(null);
		for (Figura f: l) {
			System.out.println(f.getArea());
		}
		
		
		
		
		
		

	
	}
	
}

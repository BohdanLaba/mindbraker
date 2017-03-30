package com.ex.mindbraker;

import com.ex.mindbraker.models.Circle;
import com.ex.mindbraker.service.CircleConstructor;
import com.ex.mindbraker.service.Game;
import com.ex.mindbraker.service.Printer;
import com.ex.mindbraker.service.Util;

/**
 * З'явилась ідея - тупо захардкодити позиції всіх трикутників, разом з можливими
 * поворотами..
 * 
 * Ще одна ідея - розглядати трикутники у вигляді матриці цифр - квадратна 3х3 наприклад, при повороті кола, 
 * всіж трикутники теж поветраюься на 60 відносно точки перетину висот.
 * 
 * convex вигнутий 
 * concave ввігнутий
 */
public class App {
	public static void main(String[] args) {
		CircleConstructor constructor = new CircleConstructor();
		Circle circleA = constructor.getCircleA();
		Circle circleB = constructor.getCircleB();
		Circle circleC = constructor.getCircleC();
		Game game = new Game();

		if (Util.checkCircleConsistency(circleA, circleB, circleC))
			Printer.printAllCircles(circleA, circleB, circleC);

		System.out.println(game.rotateClockwise(circleB, circleA, circleC));
		System.out.println("--------------------");
		System.out.println(game.rotateClockwise(circleA, circleC, circleB));
		System.out.println("--------------------");
		System.out.println(game.rotateClockwise(circleC, circleB, circleA));
	}
}

package com.ex.mindbraker.service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.ex.mindbraker.models.Circle;
import com.ex.mindbraker.models.Rib;
import com.ex.mindbraker.models.Triangle;
import com.ex.mindbraker.models.Vertex;
import com.ex.mindbraker.models.Vertex.Importance;

public class Game {

	private static Logger logger = Logger.getLogger("GameLogger");
	
	/**
	 * change tringle position:
	 *  1st: move them to new spaces (dependending on pos. 
	 *  change "i" or both "i" & "j" index - check whether element is at array bounds) 
	 *  while doing that, update respective elements in other circles.
	 *  
	 * @param main
	 * @param neighbours
	 * @return
	 */
	public boolean rotateClockwise(Circle main, Circle... neighbours) {
		if (canRotate(main)) {
			Circle circleB = main;
			Circle circleA = neighbours[0];
			Circle circleC = neighbours[1];
			
			
		}
		return true;
	}

	public boolean rotate(Circle main, Circle... neighbours) {
		return canRotate(main);
	}

	private boolean canRotate(Circle circle) {
		for (int i = 0; i < circle.getArray().length; i++) {
			for (int j = 0; j < circle.getArray()[i].length; j++) {
				if (isBorderTriangle(circle.getMainVertex(), circle.getArray()[i][j])) {
					logger.info(String.format("border triangle #%s at : [%s, %s]", circle.getArray()[i][j].getName(), i,
							j));
					Rib[] ribs = circle.getArray()[i][j].getRibs();
					for (int k = 0; k < ribs.length; k++) {
						logger.info("Checking rib : " + ribs[i].toString());
						for (Vertex vertex : ribs[i].getVertexs()) {
							if (vertex.getImportance() == Importance.MAIN && !vertex.equals(circle.getMainVertex())
									&& ribs[i].getCurve().equals(Rib.RibCurve.CONCAVE)) {
								logger.info("found border collision !");
								return false;
							}
						}
					}
				}
			}

		}
		return true;
	}
	
	public boolean canRotate(Circle current, Circle... neighbours) {
		return false;
	}

	private void executeRotate(Circle mainCircle, Circle... neighbours) {

	}

	private boolean isBorderTriangle(Vertex mainVertex, Triangle triangle) {
		Set<Vertex> mainVertexSet = null;
		for (Rib rib : triangle.getRibs()) {
			for (Vertex vertex : rib.getVertexs()) {
				if (vertex.getImportance() == Importance.MAIN && !vertex.equals(mainVertex)) {
					if (mainVertexSet == null) {
						mainVertexSet = new HashSet<Vertex>();
					}
					mainVertexSet.add(vertex);
				}
			}
		}
		return mainVertexSet.size() > 1;
	}
}

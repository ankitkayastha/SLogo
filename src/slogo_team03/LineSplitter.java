package slogo_team03;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineSplitter {
	private double m; // slope
	private double b; // y-intercept
	private double angle;
	private Point2D pS, pE;

	public List<Line> split(Line line) {
		List<Line> lineList = new ArrayList<Line>();
		Color color = (Color) line.getFill();
		double penSize = line.getStrokeWidth();


//		double startX = line.getStartX();
//		double startY = line.getStartX();
//		double endX = line.getEndX();
//		double endY = line.getEndY();
		
		
		pS = new Point2D(line.getStartX(), line.getStartY());
		pE = new Point2D(line.getEndX(), line.getEndY());
		double length = distance(pS, pE);
//		System.out.println("Length = " + length);
		
		m = (pE.getY() - pS.getY()) / (pE.getX() - pS.getX());
		
		if (pE.getX() > pS.getX()) {
			angle = ((Math.toDegrees(Math.atan(m))) + 360) % 360;
		} else { 
			angle = ((Math.toDegrees(Math.atan(m))) + 180) % 360;
		}
		
		
		
//		angle = ((Math.toDegrees(Math.atan(m))) + 360) % 360;
		System.out.println("Angle = " + angle);
		updateYIntercept(pS);
//		System.out.println(angle);

		double bound = 250.0;
		while (pE.getX() > bound || pE.getY() > bound || pE.getX() < (bound * -1) || pE.getY() < (bound * -1)) {
			
			Point2D p1, p2;
			if (angle > 0 && angle <= 90) {

				p1 = new Point2D(bound, getYWhenXEquals(bound));		//x boundary
				p2 = new Point2D(getXWhenYEquals(bound), bound);		//y boundary
					
			} else if (angle > 90 && angle <= 180) {
				p1 = new Point2D(bound * -1, getYWhenXEquals(bound * -1));		//x boundary
				p2 = new Point2D(getXWhenYEquals(bound), bound);		//y boundary
			} else if (angle > 180 && angle <= 270) {
				p1 = new Point2D(bound * -1, getYWhenXEquals(bound * -1));		//x boundary
				p2 = new Point2D(getXWhenYEquals(bound * -1), bound * -1);		//y boundary
			} else {
				p1 = new Point2D(bound, getYWhenXEquals(bound));		//x boundary
				p2 = new Point2D(getXWhenYEquals(bound * -1), bound * -1);		//y boundary
			}
			

//			System.out.println(p1);
//			System.out.println(p2);
			
			
			double d1 = distance(pS, p1);
			double d2 = distance(pS, p2);
//			System.out.println(d1);
//			System.out.println(d2);
			
			if (d1 < d2){	//x		//d1 is smaller, pick this one
				//Choose d1/p1
				length -= d1;
//				System.out.println("Length = " + length);
				lineList.add(new Line(pS.getX(), pS.getY(), p1.getX(), p1.getY()));
				pS = new Point2D(p1.getX() * -1, p1.getY());
				pE = calculateNewEndPoint(pS, length);
//				System.out.println(pS);
//				System.out.println(pE);
			}
			else {	//y				//d2 is smaller, pick this one
				//Choose d2/p2
				length -= d2;
				lineList.add(new Line(pS.getX(), pS.getY(), p2.getX(), p2.getY()));
				pS = new Point2D(p2.getX(), p2.getY() * -1);
				pE = calculateNewEndPoint(pS, length);
			}
			
			updateYIntercept(pS);
		}
		
		pE = calculateNewEndPoint(pS, length);
//		System.out.println("Last line endpoint: " + pE);
		lineList.add(new Line(pS.getX(), pS.getY(), pE.getX(), pE.getY()));

		for (int i = 0; i < lineList.size(); i++) {
			System.out.println("X0 = " + line.getStartX() + ", Y0 = " + line.getStartY() + ", X1 = " + line.getEndX() + ", Y1 = " + line.getEndY());
			lineList.get(i).setFill(color);
			lineList.get(i).setStrokeWidth(penSize);
		}
		return lineList;
	}

	private Point2D calculateNewEndPoint(Point2D pS, double length) {
		double x1, y1;
		
//		System.out.println("Angle = " + angle);
		//
		// if (angle >= 90 && angle <= 270) {
		// x1 = pS.getX() + length * Math.cos(Math.toRadians(angle));
		// y1 = pS.getY() + length * Math.sin(Math.toRadians(angle));
		//
		// } else {
		// x1 = pS.getX() + length * Math.cos(Math.toRadians(angle));
		// y1 = pS.getY() + length * Math.sin(Math.toRadians(angle));
		// }
		//
		// System.out.println(x1);
		// System.out.println(y1);
		//
		
		x1 = pS.getX() + length * Math.cos(Math.toRadians(angle));
		y1 = pS.getY() + length * Math.sin(Math.toRadians(angle));

		return new Point2D(x1, y1);
	}

	private void updateYIntercept(Point2D pS) {
		b = pS.getY() - m * pS.getX();
	}

	public double getYWhenXEquals(double xValue) {
		return m * xValue + b;
	}

	public double getXWhenYEquals(double yValue) {
		return (yValue - b) / m;
	}
	
	public double distance(Point2D p1, Point2D p2) {
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
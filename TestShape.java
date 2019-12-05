public class TestShape{
	public static void main(String args[]){
		Point p = new Point(1,1);
		Shape[] arr = {
			new Rectangle(p,3,4),
			new Parallelogram(p,5,6,Math.PI/6.0),
			new Trapezoid(p,5,6,2)
		};
		System.out.println("SUM_AREA = " + sumArea(arr));
	}
	
	static double sumArea(Shape[] arr){
		double sum=0;
		
		for(int i=0; i<3; i++){
			sum = sum + arr[i].getArea();
		}
		
		return sum;
	}
}

class Point{
	double x, y;
	Point() { this(0,0); }
	Point(double x, double y) { this.x = x; this.y = y; }
	public String toString() { return "["+x+","+y+"]"; }
}

abstract class Shape{
	Point position;
	
	Shape(){
		position = new Point(0,0);
	}
	
	Shape(Point p){
		position = p;
	}
	
	Point getPosition(){ return position;}
	void setPosition(Point p){ position = p; }
	abstract double getArea();
}

abstract class Quadrangle extends Shape{
	protected double width, height;
	
	Quadrangle(Point p, double w, double h){
		setPosition(p);
		width = w;
		height = h;
	}
	
	double getWidth() { return width; }
	double getHeight() { return height; }
	void setWidth(double w) { width = w; }
	void setHeight(double h) { height = h; }
}

class Rectangle extends Quadrangle{
	Rectangle(Point p, double w, double h){
		super(p, w, h);
	}
	
	boolean isSquare(){
		if(getWidth() == getHeight()) return true;
		else return false;
	}
	
	double getArea(){ return getWidth() * getHeight(); }
}

class Parallelogram extends Quadrangle{
	double angle;
	
	Parallelogram(Point p, double w, double h, double a){
		super(p, w, h);
		angle = a;
	}
	
	double getAngle() { return angle; }
	void setAngle(double a) { angle = a; }
	
	double getArea(){ return getWidth() * getHeight(); }
}

class Trapezoid extends Quadrangle{
	double top_width;
	
	Trapezoid(Point p, double w, double h, double tw){
		super(p, w, h);
		top_width = tw;
	}
	
	double getTopWidth() { return top_width; }
	void setTopWidth(double tw) { top_width = tw; }
	double getArea() { return getHeight() * (getWidth()+getTopWidth())/2; }
}
package sourceafis.general;
/**
 * 
 * @{#} Point.java Create on 2012-9-14 下午03:37:40    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public class Point {
	public int X;
	public int Y;
	public Point() {
	}
	public Point(int x,int y) {
		this.X=x;
		this.Y=y;
	}
	@Override
	public int hashCode() {
		return X+Y;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point){
			Point other=(Point)obj;
			if(this.X==other.X&&this.Y==other.Y){
				return true;
			}
		}
		return false;
	}
	public Point add(Size size){
		return new Point(X+size.Width,Y+size.Height);
	}
	public Point minus(Size size){
		return new Point(X-size.Width,Y-size.Height);
	}


}

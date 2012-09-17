package sourceafis.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @{#} RectangleC.java Create on 2012-9-14 下午03:37:49    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public class RectangleC implements Iterable<Point>{
	public int X;
	public int Y;
	public int Width;
	public int Height;
	private List<Point> pointList=new ArrayList<Point>();
	public RectangleC(Size size) {
		X = Y = 0;
		Width = size.Width;
		Height = size.Height;
		initPoint();
	}
	 public RectangleC(Point begin, Point end)
     {
         X = begin.X;
         Y = begin.Y;
         Width = end.X - begin.X;
         Height = end.Y - begin.Y;
         initPoint();
     }
	private void initPoint(){
      for (int y = getBottom(); y < getTop(); ++y){
    	    for (int x =getLeft(); x<getRight(); ++x)
    	    {
    	    	pointList.add(new Point(x,y));
    	    }
      }
	}
	public int getLeft() {
		return X;
	}

	public void setLeft(int value) {
		Width += X - value;
		X = value;
	}

	public int getBottom() {
		return Y;
	}

	public void setBottom(int value) {
		Height += Y - value;
		Y = value;

	}

	public int getRight() {
		return X + Width;
	}

	public void setRight(int value) {
		Width = value - X;
	}

	public int getTop() {
		return Y + Height;
	}

	public void setTop(int value) {
		Height = value - Y;
	}
	public Point getCenter(){
	
		return new Point((getRight()+getLeft())/2,(getBottom()+getTop())/2);
	}
	
	  public boolean Contains(Point point)
      {
          return point.X>=getLeft()&&point.Y>=getBottom()&&point.X<getRight()&&point.Y<getTop();
      }

	@Override
	public Iterator<Point> iterator() {
       
		return pointList.iterator();
	}
}

package sourceafis.general;
/**
 * 
 * @{#} Calc.java Create on 2012-9-14 下午03:37:36    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public final class Calc {
	 public static int DivRoundUp(int input, int divider)
     {
         return (input + divider - 1) / divider;
     }
	 public static int Interpolate(int index, int count, int range)
     {
         return (index * range + count / 2) / count;
     }
	 public static Point Add(Point left, Point right)
     {
         return left.add(new Size(right.X,right.Y));
     }
     
}

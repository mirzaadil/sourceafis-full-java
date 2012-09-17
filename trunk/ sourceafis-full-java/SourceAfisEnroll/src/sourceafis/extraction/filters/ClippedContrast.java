package sourceafis.extraction.filters;

import sourceafis.general.BlockMap;
import sourceafis.general.Point;
import sourceafis.meta.ParameterAttribute;

/**
 * 
 * @{#} ClippedContrast.java Create on 2012-9-14 下午03:36:43    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public class ClippedContrast {
	 @ParameterAttribute(Upper=0.4)
	 public static float ClipFraction = 0.08f;
	 
	 public static byte[][] Compute(BlockMap blocks, short[][][] histogram)
     {
         byte[][] result=new byte[blocks.BlockCount.Height][blocks.BlockCount.Width];
         for (Point block : blocks.AllBlocks) {
        	 	
             int area = 0;
             for (int i = 0; i < 256; ++i){
            	 area += histogram[block.Y][ block.X][i];
             }
             int clipLimit=(int) (area*ClipFraction);
             int accumulator = 0;
             int lowerBound = 255;
             for (int i = 0; i < 256; ++i)
             {
                 accumulator += histogram[block.Y][ block.X][i];
                 if (accumulator > clipLimit)
                 {
                     lowerBound = i;
                     break;
                 }
             }

             accumulator = 0;
             int upperBound = 0;
             for (int i = 255; i >= 0; --i)
             {
                 accumulator += histogram[block.Y][ block.X][i];
                 if (accumulator > clipLimit)
                 {
                     upperBound = i;
                     break;
                 }
             }
             result[block.Y][ block.X] = (byte)(upperBound - lowerBound);
		}
		 return result;
     }
}

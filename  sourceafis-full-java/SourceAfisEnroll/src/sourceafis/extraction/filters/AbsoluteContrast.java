
package sourceafis.extraction.filters;

import sourceafis.general.BinaryMap;

import sourceafis.meta.ParameterAttribute;
/**
 * 
 * @{#} AbsoluteContrast.java Create on 2012-9-14 下午03:36:39    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public final class AbsoluteContrast {
	@ParameterAttribute(Upper=255)
     public static int Limit = 17;
	 public static BinaryMap DetectLowContrast(byte[][] contrast)
     {
         BinaryMap result = new BinaryMap(contrast.length, contrast[0].length);
         for (int y = 0; y < result.Height; ++y){
             for (int x = 0; x < result.Width; ++x){
                 if (contrast[y][ x] < Limit){
                	 result.SetBitOne(x, y);
                 }
             }
         }            
         return result;
         
     }
}

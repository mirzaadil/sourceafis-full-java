package sourceafis.extraction.filters;

import sourceafis.general.BinaryMap;
import sourceafis.general.BlockMap;
/**
 * 
 * @{#} SegmentationMask.java Create on 2012-9-14 下午03:37:14    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public final class SegmentationMask {

	public static BinaryMap ComputeMask(BlockMap blocks, short[][][] histogram)
	{
		byte[][] contrast = ClippedContrast.Compute(blocks, histogram);
		BinaryMap mask = new BinaryMap(AbsoluteContrast.DetectLowContrast(contrast));
		return null;
		
	}
}

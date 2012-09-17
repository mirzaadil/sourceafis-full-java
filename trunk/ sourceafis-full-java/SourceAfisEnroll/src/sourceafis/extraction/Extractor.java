package sourceafis.extraction;

import sourceafis.extraction.filters.ImageInverter;
import sourceafis.extraction.filters.LocalHistogram;
import sourceafis.extraction.filters.SegmentationMask;
import sourceafis.general.BinaryMap;
import sourceafis.general.BlockMap;
import sourceafis.general.Size;
import sourceafis.meta.DpiAdjuster;
import sourceafis.meta.DpiAdjuster.Action;
import sourceafis.meta.ParameterAttribute;
import sourceafis.templates.TemplateBuilder;
/**
 * 
 * @{#} Extractor.java Create on 2012-9-14 下午03:37:21    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public class Extractor {
	@ParameterAttribute(Lower=8,Upper=32)
	private int maxBlockSize = 15;//最大块大小
	
	public TemplateBuilder Extract(final byte[][] invertedImage,int dip){
		TemplateBuilder template = null;
		DpiAdjuster.Adjust(this, dip, new Action() {
			public void onEvent() {
				byte[][] image = ImageInverter.GetInverted(invertedImage);
				BlockMap blocks=new BlockMap(new Size(image.length, image[0].length), maxBlockSize);
				short[][][] histogram=LocalHistogram.Analyze(blocks, image);
			    short[][][] smoothHistogram = LocalHistogram.SmoothAroundCorners(blocks, histogram);
                BinaryMap mask = SegmentationMask.ComputeMask(blocks, histogram);

			}
		});
		return template;
	}
}

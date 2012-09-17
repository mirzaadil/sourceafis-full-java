package sourceafis.extraction.filters;

import sourceafis.general.BlockMap;
import sourceafis.general.Calc;
import sourceafis.general.Point;
import sourceafis.general.RectangleC;
/**
 * 
 * @{#} LocalHistogram.java Create on 2012-9-14 下午03:36:54    
 *    
 * Class Description:   
 *
 * 直方图平滑处理
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public final class LocalHistogram {
	/**
	 * 直方图分析
	 * @param blocks
	 * @param image
	 * @return
	 */
	public static short[][][] Analyze(BlockMap blocks,byte[][] image){
		short[][][] histogram=new short[blocks.BlockCount.Height][blocks.BlockCount.Width][256];
		for (Point block : blocks.AllBlocks) {
			RectangleC area = blocks.BlockAreas.getRectangle(block);
            for (int y = area.getBottom(); y < area.getTop(); ++y){
            	for (int x = area.getLeft(); x < area.getRight(); ++x){
            		++histogram[block.Y][block.X][image[y][x]];
            	}
                   
            }     
		}
		return histogram;
	}
	/**
	 *平滑 
	 * @param blocks
	 * @param input
	 * @return
	 */
	public static short[][][] SmoothAroundCorners(BlockMap blocks,
			short[][][] input) {
		
		Point[] blocksAround = new Point[] { new Point(0, 0), new Point(-1, 0), new Point(0, -1), new Point(-1, -1) };
        short[][][] output = new short[blocks.CornerCount.Height][blocks.CornerCount.Width][256];
        for (Point corner : blocks.AllCorners) {
        	for (Point relative : blocksAround) {
        		 Point block = Calc.Add(corner, relative);
        		 if(blocks.AllBlocks.Contains(block)){
        			 for (int i = 0; i < 256; ++i){
        				 output[corner.Y][corner.X][i]+=input[block.Y][block.X][i];
        			 } 			
        		 }
       
			}
		}
        return output;
	}
}

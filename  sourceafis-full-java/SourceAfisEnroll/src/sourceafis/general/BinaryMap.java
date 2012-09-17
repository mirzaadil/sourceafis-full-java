package sourceafis.general;

import java.io.Serializable;
/**
 * 
 * @{#} BinaryMap.java Create on 2012-9-14 下午03:37:27    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public final class BinaryMap implements Serializable {

	public int Width;
	public int Height;
	public int WordWidth;
	public int[][] Map;
	public static int WordShift = 5;
	public static int WordMask = 31;
	public static int WordSize = 32;
	public static int WordBytes = WordSize / 8;

	public BinaryMap(int width, int height) {
		this.Width = width;
		this.Height = height;
		WordWidth = (width + (int) WordMask) >> WordShift;
		Map = new int[height][WordWidth];
	}

	public BinaryMap(BinaryMap other) {
		Width = other.Width;
        Height = other.Height;
        WordWidth = other.WordWidth;
        Map = new int[other.Map.length][ other.Map[0].length];
        for (int y = 0; y < Map.length; ++y){
        	for (int x = 0; x < Map[0].length; ++x){
        		Map[y][ x] = other.Map[y][ x];
        	}   
        } 
	}

	public void SetBitOne(int x, int y) {
		Map[y][x >> WordShift] |= 1 << (int) (x & WordMask);
	}
}

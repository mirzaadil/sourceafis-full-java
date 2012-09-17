package sourceafis.extraction.filters;
/**
 * 
 * @{#} ImageInverter.java Create on 2012-9-14 下午03:36:48    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public final class ImageInverter {
	/**
	 * 翻转
	 * @param image
	 * @return
	 */
	public static byte[][] GetInverted(byte[][] image){
		byte[][] result=new byte[image.length][image[0].length];
		for (int y = 0; y < image.length; y++) {
			for (int x = 0; x < image[0].length; x++) {
				result[y][x]= (byte) (255-image[y][x]);
			}
		}
		return result;
	}
}

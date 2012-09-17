package sourceafis.general;


/**
 * 
 * @{#} BlockMap.java Create on 2012-9-14 下午03:37:32    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public class BlockMap {
	public class PointGrid{
		private int[] AllX;
		private int[] AllY;
		public PointGrid(Size size) {
			AllX=new int[size.Width];
			AllY=new int[size.Height];
		}
		public Point getPoint(int y,int x){
			return new Point(AllX[x],AllY[y]);
		}
		public Point getPoint(Point at){
			return new Point(AllX[at.X],AllY[at.Y]);
		}
	}
	public class RectangleGrid{
		private PointGrid pg;
		public RectangleGrid(PointGrid pg) {
			this.pg=pg;
		}
		public RectangleC getRectangle(int y,int x){
			return new RectangleC(pg.getPoint(y, x), pg.getPoint(y+1, x+1));
		}
		public RectangleC getRectangle(Point at){
			return new RectangleC(pg.getPoint(at),pg.getPoint(at.Y+1,at.X+1));
		}
	}
	public Size PixelCount;//像素大小
	public Size BlockCount;//块大小
	public Size CornerCount;//角点大
	public RectangleC AllBlocks;//区域块
	public RectangleC AllCorners;//角点
	public PointGrid Corners;
	public RectangleGrid BlockAreas;
	public PointGrid BlockCenters;
	public RectangleGrid CornerAreas;
	public BlockMap(Size pixelSize,int maxBlockSize) {
		this.PixelCount=pixelSize;
		this.BlockCount=new Size(
				Calc.DivRoundUp(pixelSize.Width, maxBlockSize),
				Calc.DivRoundUp(pixelSize.Height, maxBlockSize)		
		);
		CornerCount=blockToCornerCount(BlockCount);
		
		AllBlocks = new RectangleC(BlockCount);
		AllCorners = new RectangleC(CornerCount);
		
		Corners=initCorners(CornerCount);
		BlockAreas=new RectangleGrid(Corners);
		BlockCenters=initBlockCenters(BlockCount);
		CornerAreas=initCornerAreas(CornerCount,BlockCount);
	}


	private Size blockToCornerCount(Size blockCount2) {
		return new Size(BlockCount.Width + 1, BlockCount.Height + 1);
	}
	private PointGrid initCorners(Size cornerCount) {
		 PointGrid grid = new PointGrid(cornerCount);
        for (int y = 0; y < cornerCount.Height; ++y)
            grid.AllY[y] = y * PixelCount.Height / BlockCount.Height;
        for (int x = 0; x < cornerCount.Width; ++x)
            grid.AllX[x] = x * PixelCount.Width / BlockCount.Width;
        return grid;
	}
	
	private PointGrid initBlockCenters(Size blockCount){
		 PointGrid grid = new PointGrid(blockCount);
         for (int y = 0; y < blockCount.Height; ++y){
        	 grid.AllY[y] = BlockAreas.getRectangle(y, 0).getCenter().Y;
         }  
         for (int x = 0; x < blockCount.Width; ++x){
        	 grid.AllX[x] = BlockAreas.getRectangle(0, x).getCenter().X;
         }
         return grid;
	}
	private RectangleGrid initCornerAreas(Size cornerCount,Size blockCount) {
		PointGrid grid = new PointGrid(new Size(cornerCount.Width + 1, cornerCount.Height + 1));
        
        grid.AllY[0] = 0;
        for (int y = 0; y < blockCount.Height; ++y){
        	 grid.AllY[y + 1] = BlockCenters.getPoint(y, 0).Y;
        }
        grid.AllY[blockCount.Height] = PixelCount.Height;
        
        grid.AllX[0] = 0;
        for (int x = 0; x < blockCount.Width; ++x){
        	 grid.AllX[x + 1] =BlockCenters.getPoint(0, x).X;
        }
        grid.AllX[blockCount.Width]=PixelCount.Width;   
        return new RectangleGrid(grid);
	}

	
	
	






	

	


	
}

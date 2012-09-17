package sourceafis.meta;
/**
 * 
 * @{#} DpiAdjuster.java Create on 2012-9-14 下午03:38:07    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public class DpiAdjuster {
	
	public interface Action{
		public void onEvent();
	}

	public static void Initialize(ObjectTree tree)
    {

    }
	public static void Adjust(Object root,int dip,Action action){
		 ObjectTree tree = new ObjectTree();
         tree.Scan(root, "Dpi");
         Initialize(tree);
	}
}

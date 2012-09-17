package sourceafis.meta;

import java.lang.reflect.Field;
import java.util.HashMap;
/**
 * 
 * @{#} ObjectTree.java Create on 2012-9-14 下午03:38:56    
 *    
 * Class Description:   
 *
 * <p>Copyright (c) 2007-2012 Biocome </p> 
 * @Version 1.0
 * @author <a href="mailto:chengxw@biocome.com">ChengXuWei</a>
 *  
 *
 */
public class ObjectTree {
	public final class Item
    {
        public Object Reference;
        public String Path;
    }

	private HashMap<Object,Item> ByReference=new HashMap<Object,Item>();
	private HashMap<String,Item> ByPath=new HashMap<String,Item>();
	public void Scan(Object root,String path){
		if(path==null){
			path="";
		}
		if (!ByReference.containsKey(root) && !ByPath.containsKey(path)){
			 Item item=new Item();
			 item.Reference=root;
			 item.Path=path;
			 ByPath.put(path, item);
             ByReference.put(root, item);
            for (Field field : root.getClass().getFields()) {
				if(field.getAnnotation(NestedAttribute.class)!=null){
					Object fieldValue=null;
					try {
						fieldValue=field.get(root);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(null!=fieldValue){
						Scan(fieldValue, path + (path != "" ? "." : "") + field.getName());
					}
				}
			} 
		}

	}
}

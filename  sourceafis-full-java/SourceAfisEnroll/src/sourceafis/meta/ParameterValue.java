package sourceafis.meta;

import java.io.Serializable;
import java.lang.reflect.Field;

public class ParameterValue implements Serializable {

	public transient String ObjectPath;
	public transient Object ObjectReference;
	public transient String FieldPath;
	public transient Field Field;
	public transient ParameterAttribute Attribute;
	public class NumberConverter implements Serializable{
		
          public double val;
          public int Precision;
          public byte getByte(){
        	  return (byte)val ;
          }
          public void setByte(byte val){
        	  this.val=val;
          }
          public int getInt(){
        	  return (int)val;
          }
          public void setInt(int val){
        	  this.val=val;
          }
          public float getFloat(){
        	  return (float)val;
          }
          public void setFloat(float val){
        	  this.val=val;
          }
          public double getPrecisionMultiplier(){
        	  return Math.pow(10, Precision);
          }
          public int getNormalized(){
        	  return (int) (val * getPrecisionMultiplier());
          }
          public void setNormalized(int val){
        	  this.val=val/getPrecisionMultiplier();
          }
	}
	public NumberConverter value;

}

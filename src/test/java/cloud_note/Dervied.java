package cloud_note;

import java.util.Arrays;


public class Dervied{
	
	private Integer i=2;
	

	public void change(Integer a){
		a=1;
	}
	public static void main(String[] args) {
		Dervied d=new Dervied();
		System.out.println(d);
		Integer i=new Integer(100);
		d.change(100);
		System.out.println(i);
	}
}
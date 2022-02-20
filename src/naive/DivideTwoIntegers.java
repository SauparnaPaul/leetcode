package naive;

public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor) {
		boolean sign=false;
    	int noOfIteration = 0;

		if(dividend==0) return 0;
		if(dividend<divisor) return 0;
		if(dividend<0) sign=true;
		if(divisor<0) sign =true;
		if(dividend <0 & divisor<0) sign=false;
		
		int dv=divisor>0?divisor:-divisor;
	    int dd= dividend>0?dividend:-dividend;
	    
	     do {
	    	dd=dd-dv;
			noOfIteration++;
	    }while(dd-dv>0);
		return sign==false?noOfIteration:-noOfIteration;
	    }

	public static void main(String[] args) {
		DivideTwoIntegers dti=new DivideTwoIntegers();
		System.out.println(dti.divide(10, 3));;
		System.out.println(dti.divide(7, 3));
		System.out.println(dti.divide(7, -3));
		System.out.println(dti.divide(1, -1));

	}

}

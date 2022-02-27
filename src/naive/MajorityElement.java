package naive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {
	
	 public int majorityElement(int[] nums) {
	     int n = nums.length/2;
	     List<Integer> integerList= new ArrayList<Integer>();

		 Map<Integer, Long> res= Arrays.stream(nums)
				 .boxed()
				 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 //System.out.println(res);
		return res.entrySet().stream().filter(e->e.getValue()>n).map(i->i).collect(Collectors.toList()).get(0).getKey();
	    }

	public static void main(String[] args) {

		MajorityElement me=new MajorityElement();
	    System.out.println(me.majorityElement(new int []{ 1, 1, 2, 1, 3, 5, 1 }));
	    System.out.println(me.majorityElement(new int []{ 2,2,1,1,1,2,2 }));
	    

	}

}

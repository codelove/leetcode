// TWO SUM
// Given an array of integers, find two numbers such that they add up to 
// a specific target number.
// 
// The function twoSum should return indices of the two numbers such that 
// they add up to the target, where index1 must be less than index2. 
// Please note that your returned answers (both index1 and index2) are not zero-based.
// 
// You may assume that each input would have exactly one solution.
// 
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        HashMap<Integer, ArrayList<Integer> > table = new HashMap<Integer, ArrayList<Integer> >();
        
        // build the hashmap
        for ( int i = 0; i < numbers.length; ++i ) {
            if ( table.containsKey(numbers[i]) )
        	{
        		ArrayList<Integer> indexes = table.get(numbers[i]);
        		indexes.add(i+1);
        	}
        	else
        	{
        		ArrayList<Integer> indexes = new ArrayList<Integer>();
        		indexes.add(i+1);
        		table.put(numbers[i],indexes);
        	}
        }
        
        int index1 = 0;
        int index2 = 0;
        for ( int i = 0; i < numbers.length - 1; ++i )
        {
        	if ( table.containsKey(target-numbers[i]) )
        	{
        		ArrayList<Integer> indexes = table.get(target-numbers[i]);
        		if ( i + 1==indexes.get(0) ) {
        			if ( indexes.size() > 1 ) {
        				index1 = i + 1;
        				index2 = indexes.get(1);
        				break;
        			}
        		}
        		else
        		{
        			index1 = i + 1;
        			index2 = indexes.get(0);
        			break;
        		}
        	}
        }
        if ( index1 > index2 )
        {
        	int itmp = index1;
        	index1 = index2;
        	index2 = itmp;
        }
        
        int[] res = new int[2];
        res[0] = index1;
        res[1] = index2;
        
        return res;
    }
}

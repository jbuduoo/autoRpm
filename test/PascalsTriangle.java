package jb.com;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		System.out.println("hi");
		List<List<Integer>> tempList=new ArrayList<>();
		tempList= generate(6);
	}
  public static List<List<Integer>> generate(int numRows) {
		List<Integer> temp=new ArrayList<>();
		List<List<Integer>> res=new ArrayList<>();
		
        temp.add(1);
        res.add(temp);
        
        if(numRows == 1) { return res; }
        
        temp = new ArrayList<>();
        temp.add(1); temp.add(1);
            
        res.add(temp);

        if(numRows == 2) return res;
        
		for(int i=2;i<numRows;i++) {
			List<Integer> row=new ArrayList<>();
			row.add(1);
			for(int j=1;j<=i-1;j++) {
				row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
			}
			row.add(1);
			
			res.add(row);
		}
		
		System.out.println(res);
		return res;
  }
}

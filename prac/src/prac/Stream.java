package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {

	static class employee{
		int salary;
		int eid;
		employee(int s,int eid)
		{
			salary=s;
			this.eid=eid;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getEid() {
			return eid;
		}
		public void setEid(int eid) {
			this.eid = eid;
		}
	}
	private static List<employee> list=new ArrayList<>();
	static {
		list.add(new employee(5202,1));
		list.add(new employee(3232,2));
		list.add(new employee(52202,3));
		list.add(new employee(7890,3));
		list.add(new employee(223,4));
		list.add(new employee(11,5));
		list.add(new employee(5002,6));
	}
	public static void main(String[] args) {
		q1("hello bbbbbbbbbbbbbb world");
		q2();
	}
	
	public static void q1(String s)
	{
		Map<Character,Integer> map=new HashMap<>();
		List<Character>list=new ArrayList<>();
		char[] charArray = s.toCharArray();
		for(char c:charArray)
		{
			Character cc=(Character)c;
			list.add(cc);
		}
		int max[]= {0};
		Character c[]= {' '};
		list.stream().forEach(e->{
		map.put(e, map.getOrDefault(e,0)+1);});
	
		System.out.println(map);
		
		map.entrySet().forEach(e->{
		if(e.getValue()>max[0]) {
			max[0]=e.getValue();
			c[0]=e.getKey();
		}
		});
		
		System.out.println("max occouring character:"+c[0]+" occurance:"+max[0]);
		
	}
	
	
	public static void q2() {
		Map<Integer,Integer>map=list.stream().filter(e->
		e.salary>5000
		).collect(Collectors.toMap(employee::getSalary,employee::getEid));
		System.out.println(map);
	}
	
}

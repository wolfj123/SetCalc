package setCalc;

import java.util.Vector;
import java.util.List;
import java.util.StringTokenizer;

public class Set implements Element {
	
	private List<Element> _list;

	public Set (){
		_list= new Vector<Element>();
	}
	
	public Set (Element e){
		this ();
		_list.add(e);
	}
	

	public Set(String s){
		if(!isValidString(s))
			throw new IllegalArgumentException("Illegal List");
		
		_list = new Vector<Element>();
		String[] content = s.substring(1, s.length()-2) .split(",");
		
		if(content.length>0)
		for(String e : content){
			Element newElement = createElementFromString(e);
			if(newElement!=null)
				insert(newElement);
		}
	}
	
	private Element createElementFromString(String s){
		if(Rational.isValidString(s))
			return new Rational(s);
		
		if(Real.isValidString(s))
			return new Real(s);
		
		if(Set.isValidString(s))
			return new Set(s);
		
		return null;
	}
	
	/* I guess java doesn't support recursive regex :(
	static public String getRegEx(){
		return "(^[{][}]$)|(^[{](a)[}]$)";
	}
	*/
	
	static public  boolean isValidString(String s){
		
		if(s == null || s.length()==0) //is empty or null
			return false;
		
		if(s.contains(",,") | s.contains("{,") | s.contains(",}")) return false;
		
		if(s.charAt(0)!='{' || s.charAt(s.length()-1)!='}') //is enclosed in {}
			return false;
		
		String newS = s.substring(1, s.length()-1);
		if(newS.length()==0) return true;
		
		StringTokenizer t = new StringTokenizer(newS,",");
		if(!t.hasMoreTokens()) return false;
		
		while(t.hasMoreTokens()){
			String e = t.nextToken();
			if(!Set.isValidString(e) & !Real.isValidString(e) & !Rational.isValidString(e))
				return false;
		}
		
		return true;
	}

	
	public Set insert(Element e) {
		if (!_list.contains(e)) // check if an object already exists
			_list.add(e);
		return this;
	}
	
	public Set remove(Element e) {
		_list.remove(e);
		return this;
	}
	
	public int size() {
		return _list.size();
	}
	
	public Set union(Set s) {
		List<Element> otherList = s._list;
		for(Element e : otherList)
			insert(e);
		return this;
	}
	
	/*
	public Set intersect(Set s) {

		for (Element e : _list)
		{
			if (!s.member(e))
				_list.remove(e);
		}
		
		return this;
	}
	
	*/
	
	public Set intersect(Set s) {

		Set output = new Set();
		for(Element e : _list){
			if (s.member(e))
				output.insert(e);
		}
		return output;
	}
	
	public  Set difference(Set s) {
		List<Element> otherList = s._list;
		for(Element e : otherList)
			remove(e);
		return this;
	}
	
	public  Set power() {
		Set without = new Set(new Set());
		Set with = new Set(new Set (_list.get(0)));
		
		Set ans = Power(without, 1 );
		ans = ans.union(Power(with, 1));
		
		return ans;
	}
	
	private Set Power(Set s ,int index){
		if (index>=_list.size())
			return s;
		Set without = Power(s, index+1);
		Set add = new Set (new Set (_list.get(index)));
		Set with = new Set();
		// need to figure out which is right
		/*for (Element e : s._list){
			with.insert(e);
		}*/
		with =s ;
		for (Element e : with._list){
			with.insert((((Set)e).union(add)));
		}
		with.insert(add);
		
		Set ans = Power(with,index+1);
		ans = ans.union(without);
		return ans;
	}
	
	public boolean contains(Set s) {
		List<Element> otherList = s._list;
		for(Element e : otherList)
			if(!(_list.contains(e)))
				return false;
		return true;
	}
	
	public boolean member(Element e) {
		boolean ans= false;
		for (Element thisElements : _list)
		{
			if (thisElements.equals(e))
			{
				ans = true;
				break;
			}
		}
		
		return ans;
	}
	
	public boolean deepExistence(Element e) {
		for(Element el : _list){
			if(el.equals(e))
				return true;
			else if(el instanceof Set){
				Set elSet = (Set) el;
				if(elSet.deepExistence(e))
					return true;
			}
		}
		return false;
	}
	
	@Override
	public Set transformAdd(Numeric n) {
		for(int i=0; i<_list.size(); i=i+1){
			Element curr = _list.get(i);
			_list.set(i, curr.transformAdd(n));
		}
		return this;
	}

	@Override
	public Set transformMul(Numeric n) {
		Set ansSet = new Set();
		for (Element e : _list)
		{
			ansSet.insert(e.transformMul(n));
		}
		
		return ansSet;
	}
	
	@Override
	public String toString(){
		String output ="{";

		for(int i=0; i<_list.size(); i=i+1){
			Element e = _list.get(i);
			output+=e.toString();
			if(i<_list.size()-1)
				output+=",";
		}
		
		output+="}";
		return output;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Set))
			return false;
		List<Element> otherList = ((Set) other)._list;
		return _list.equals(otherList);
	}
}

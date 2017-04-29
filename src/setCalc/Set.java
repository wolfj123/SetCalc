package setCalc;
import java.lang.Cloneable;
import java.util.Vector;

import java.util.List;
import java.util.StringTokenizer;


public class Set implements Element,Cloneable {
	
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
		
		StringTokenizer t = new StringTokenizer(s.substring(1, s.length()-1), ",");
		
		while(t.hasMoreTokens()){
			String e = t.nextToken();
			Element el = createElementFromString(e);
			this.insert(el);	
		}
		/*
		String[] content = s.substring(1, s.length()-1) .split(",");
		
		if(content.length>0)
		for(String e : content){
			Element newElement = createElementFromString(e);
			if(newElement!=null)
				insert(newElement);
		}
		*/
	}
	
	public static Element createElementFromString(String s){
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
		//if((newS.charAt(0)=='{' || newS.charAt(newS.length()-1)=='}'))
		//	return isValidString(newS);
		
		if(newS.length()==0) return true;
		if(newS.charAt(0)=='{' & newS.charAt(newS.length()-1)=='}') 
			return isValidString(newS);
		
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
		if (!_list.contains(e)){ // check if an object already exists
			_list.add(e);
		}
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
		Set ans = new Set (new Set());
		Set ansClone = new Set (new Set());
		
		for (Element e : _list){
			ansClone = (Set)ans.Clone();
			for (Element ansE : ansClone._list){
				Element insert = ((Set)ansE).insert(e);
				ansClone.insert(insert);
			}
			ans = ans.union(ansClone);
		}


		return ans;
	}
	
	
	public Object Clone (){
		Set newSet = new Set();
		newSet._list = VectorClone();
		return newSet;
	}
	
	private Vector<Element> VectorClone(){
		//TODO - fix name convention with refractor
		Vector<Element> clonedVector = new Vector<Element>();
		for (Element e : _list){
			Element add = (Element)e.Clone();
			clonedVector.add(add);
		}
		return clonedVector;
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
		/*
		List<Element> otherList = ((Set) other)._list;
		return _list.equals(otherList);*/
		//two sets are empty
	
		boolean ans = true;
		for (Element e : _list){
			if (!(((Set)other)._list.contains(e))){
				ans=false;
				break;
			}
		}
		if (ans){
			for (Element e : ((Set)other)._list){
				if (!_list.contains(e)){
					ans=false;
					break;
				}
			}
		}
		
		return ans;
	}
	
	
}

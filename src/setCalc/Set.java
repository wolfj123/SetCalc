package setCalc;

import java.util.List;

class Set implements Element {
	
	private List<Element> list;
	
	public Set insert(Element e) {
		// TODO Auto-generated method stub
		//this method mustn't insert an element if it is already in the list
		return null;
	}
	
	public Set remove(Element e) {
		list.remove(e);
		return this;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return -1;
	}
	
	public Set union(Set s) {
		List<Element> otherList = s.list;
		for(Element e : otherList)
			insert(e);
		return this;
	}
	
	public Set intersect(Set s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  Set difference(Set s) {
		List<Element> otherList = s.list;
		for(Element e : otherList)
			remove(e);
		return this;
	}
	
	public  Set power() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean contains(Set s) {
		List<Element> otherList = s.list;
		for(Element e : otherList)
			if(!(list.contains(e)))
				return false;
		return true;
	}
	
	public boolean member(Element e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean deepExistence(Element e) {
		for(Element el : list){
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set transformMul(Numeric n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		String output ="{";
		for (Element e : list){
			output+=e.toString();
			output+=",";
		}
		output=output.substring(0,output.length());
		output+="}";
		return output;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Set))
			return false;
		List<Element> otherList = ((Set) other).list;
		return list.equals(otherList);
	}
}

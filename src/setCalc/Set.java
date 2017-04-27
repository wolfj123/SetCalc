package setCalc;

import java.util.List;

public class Set implements Element {
	
	private List<Element> _list;
	
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
	
	public Set intersect(Set s) {

		for (Element e : _list)
		{
			if (!s.member(e))
				_list.remove(e);
		}
		
		return this;
	}
	
	public  Set difference(Set s) {
		List<Element> otherList = s._list;
		for(Element e : otherList)
			remove(e);
		return this;
	}
	
	public  Set power() {
		// TODO Auto-generated method stub
		return null;
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
		for (Element e : _list){
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
		List<Element> otherList = ((Set) other)._list;
		return _list.equals(otherList);
	}
}

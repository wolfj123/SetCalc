package setCalc;

class Real implements Numeric {
	private double value;
	
	public Real(double value){
		this.value = value;
	}
	
	@Override
	public Real transformAdd(Numeric n) {
		return new Real(value + n.convertToDouble());
	}

	@Override
	public Real transformMul(Numeric n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double convertToDouble(){
		return getValue();
	}
	
	public double getValue(){
		return value;
	}
	
	public void setValue(double value){
		this.value = value;
	}
	
	
	@Override
	public String toString(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object other){
		// TODO Auto-generated method stub
		return false;
	}
}

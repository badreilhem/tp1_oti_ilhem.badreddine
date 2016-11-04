package  fr.ulille1.fil.odeva;

public class Money {
	private int value;
	private String currency;
	

	Money(int value, String currency)
	{
		this.value=value;
		this.currency=currency;
	}

	public int getValue()
	{
		return this.value;
	}

	public String getCurrency()
	{
		return this.currency;
	}

    public String toString() {
     	return this.getValue()+" ("+this.getCurrency()+")";
    }
    
    /**
     * La méthode _equals
     */
    public boolean _equals(Object o){
    	return this.getValue()==((Money)o).getValue() && this.getCurrency()==((Money)o).getCurrency(); 
    }
}

package fr.ulille1.fil.odeva;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
	import org.junit.Test;

	public class MoneySimpleAddTestCase {
	private Money f1EUR, f12EUR,  f14EUR;
    
    @Before
    public void init() throws UnexistingCurrencyException
    {
    	f1EUR = spy(new Money(1, "EUR"));
    	f12EUR = mock(Money.class);
    	f14EUR = mock(Money.class);
    	
    	doReturn(12).when(f12EUR).getValue();
    	doReturn(14).when(f14EUR).getValue();
  
    	doReturn("EUR").when(f12EUR).getCurrency();
    	doReturn("EUR").when(f14EUR).getCurrency();

    }

    /**
     * simpleAdd
     */
    @Test
    public void simpleAdd() throws UnexistingCurrencyException
    {
        Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);
        assertEquals(result.getValue(), 26);
        assertEquals(result.getCurrency(), "EUR");
    }
    
    
    /**
     * simpleAddVerify
     */
    @Test
    public void simpleAddVerify() throws UnexistingCurrencyException
    {
        f1EUR._equals(f1EUR);    
        verify(f1EUR, times(2)).getValue();
        verify(f1EUR, times(2)).getCurrency();
    }
}

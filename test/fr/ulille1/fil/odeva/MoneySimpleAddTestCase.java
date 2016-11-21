package fr.ulille1.fil.odeva;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.*;

import org.junit.Before;
	import org.junit.Test;

	public class MoneySimpleAddTestCase {
	private Money money1_spy, money12_stub,  money14_stub, moneym2_spy, moneym1_spy;
    private InOrder inOrder;
    
    /**
     * Initialisation
     * @throws UnexistingCurrencyException
     */
    @Before
    public void init() throws UnexistingCurrencyException
    {
    	money1_spy = spy(new Money(1, "EUR"));
    	moneym1_spy = spy(new Money(1, "EUR"));
    	moneym2_spy = spy(new Money(2, "EUR"));
    	money12_stub = mock(Money.class);
    	money14_stub = mock(Money.class);
    	
    	doReturn(12).when(money12_stub).getValue();
    	doReturn(14).when(money14_stub).getValue();
  
    	doReturn("EUR").when(money12_stub).getCurrency();
    	doReturn("EUR").when(money14_stub).getCurrency();
    	

    	inOrder=inOrder(moneym1_spy,moneym2_spy);

    }

    /**
     * simpleAdd
     */
    @Test
    public void simpleAdd() throws UnexistingCurrencyException
    {
        Money result=MoneyOps.simpleAdd(money12_stub,money14_stub);
        assertEquals(result.getValue(), 26);
        assertEquals(result.getCurrency(), "EUR");
    }
    
    
    /**
     * simpleAddVerifyMethodeCalled
     */
    @Test
    public void simpleAddVerifyMethodsCalled() throws UnexistingCurrencyException
    {
        money1_spy._equals(money1_spy);    
        verify(money1_spy, times(2)).getValue();
        verify(money1_spy, times(2)).getCurrency();
    }

    /**
     * simpleAddVerifyTheOrderOfTheMethodsCalled
     */
    @Test
    public void simpleAddVerifyTheOrderOfTheMethodsCalled() throws UnexistingCurrencyException
    {
        moneym1_spy._equals(moneym2_spy);    
        inOrder.verify(moneym1_spy).getValue();
        inOrder.verify(moneym2_spy).getValue();
        inOrder.verify(moneym1_spy).getCurrency();
    	inOrder.verify(moneym2_spy).getCurrency();
    }
    
   
    
    
	
}

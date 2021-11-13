package com.cz2002.ss10;

import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;

import java.util.*;

import org.junit.After;
import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class TableTest {
    /**
     * Set up test environment
     */
    private Staff staff;
    private ArrayList<MenuItem> orderList;
    private Table table;
    private Order order;
    

    @BeforeClass
    public void setUpRestaurant() {
        table = new Table(4, 1, true);
        for (int i=1; i <= 4; i++) {
            orderList.add(new MenuItem(i, "Test Food" + i, 1, "Test Food", 5.50, 20));
        }

        staff = new Staff("Test staff", 'M', 1, "Waiter");
        order = new Order(staff, null, 1, 1, orderList, false);
    }

    @After
    public void undoPayment(){
        table.setOccupancy(true);
        order.updatePaymentStatus(false);
    }

    /**
     * Should not release table on non payment
     */
    @Test
    public void orderNotPaid(){
        order.updatePaymentStatus(false);

        // check table occupancy for unpaid order
        Assert.assertEquals(true, table.getOccupancy());

    }

    /**
     * Should release table on payment and order invoice
     */
    @Test
    public void paidOrderInvoicePrinted(){
        order.updatePaymentStatus(true);

        // check table occupancy for unpaid order
        Assert.assertEquals(false, table.getOccupancy());
        
    }

    
}

package com.cz2002.ss10.objects.logistics;

<<<<<<< HEAD

import java.util.*;

=======
/** Table Class
 *
 * @author Neel Kumar 
 * @version 1.0
 * @since 2021-11-10
 */
>>>>>>> 159c734e73d5e490afcc801c4e04faad95d42612
public class Table {

	public enum tableState {TABLE_AVAIL, TABLE_OCCUPIED, TABLE_RESERVED}
	public enum tableSeats {ONE_SEATER(1), TWO_SEATER(2), THREE_SEATER(3), FOUR_SEATER(4)}	//restaurant can only sit 1-4 people ,COVID RESTRICTIONS

	
	private int tableNumber;
	private tableState state;
	private tableSeats noOfSeats;

	/**
	 * @param noOfSeats
	 * @param tableNumber
	 * @param state
	 */

    public Table(int seatingCapacity, int tableNumber){
        this.tableNumber = tableNumber;
        state=tableState.TABLE_OCCUPIED;

		if (seatingCapacity==1)
			noOfSeats = tableSeats.ONE_SEATER;
		else if(seatingCapacity==2)
			noOfSeats = tableSeats.TWO_SEATER;
		else if(seatingCapacity==3)
			noOfSeats = tableSeats.THREE_SEATER;
		else if(seatingCapacity==4)
			noOfSeats = tableSeats.FOUR_SEATER;
			
    }
	
	public tableState getTableState() {
		return this.state;
	}

	public void setTableState(tableState state) {
		this.state = state;
	}

    public int getTableNumber(){
        return this.tableNumber;
    }

	public void setTableSeats(tableNumber NoSeats) {
		this.noOfSeats = noOfSeats;
	}

	
}
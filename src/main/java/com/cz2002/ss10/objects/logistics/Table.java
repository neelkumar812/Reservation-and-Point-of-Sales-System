package com.cz2002.ss10.objects.logistics;

/** Table Class
 *
 * @author Neel Kumar 
 * @version 1.0
 * @since 2021-11-10
 */
public class Table {

	private int seatingCapacity;
	private int tableNumber;
	private Boolean isOccupied = false;

	/**
	 * @param seatingCapacity
	 * @param tableNumber
	 * @param isOccupied
	 */

    public Table(int seatingCapacity, int tableNumber, Boolean isOccupied){
        this.seatingCapacity = seatingCapacity;
        this.tableNumber = tableNumber;
        this.isOccupied = isOccupied;
    }
	//returns true for occupied, false for vacant
	public Boolean getOccupancy() {
		return this.isOccupied;
	}
    public int getTableNumber(){
        return this.tableNumber;
    }
	public int getSeatingCap(){
		return this.seatingCapacity;
	}
	/**
	 * 
	 * @param isOccupied
	 */
	public void setOccupancy(Boolean isOccupied) {
		this.isOccupied = true;
		throw new UnsupportedOperationException();
	}
}
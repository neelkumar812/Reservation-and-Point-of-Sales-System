package com.cz2002.ss10.objects.logistics;

public class Table {

	private int seatingCapacity;
	private int tableNumber;
	private Boolean isOccupied;

    public Table(int seatingCapacity, int tableNumber, Boolean isOccupied){
        this.seatingCapacity = seatingCapacity;
        this.tableNumber = tableNumber;
        this.isOccupied = isOccupied;
    }

	public Boolean getOccupancy() {
		// TODO - implement Table.getOccupancy
		throw new UnsupportedOperationException();
	}

    public int getTableNumber(){
        return this.tableNumber;
    }

	/**
	 * 
	 * @param isOccupied
	 */
	public void setOccupancy(Boolean isOccupied) {
		// TODO - implement Table.setOccupancy
		throw new UnsupportedOperationException();
	}

}
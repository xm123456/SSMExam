package com.hand.Entity;

import java.io.Serializable;

public abstract class EntityWithID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9118235625979848203L;
	protected long ID;

	public abstract void setID(long ID);

	public abstract long getID();
}

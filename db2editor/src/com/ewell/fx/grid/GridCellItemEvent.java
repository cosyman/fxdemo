/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.fx.grid;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 *
 * @author Administrator
 */
public class GridCellItemEvent extends Event {

    public static final EventType<GridCellItemEvent> ItemChange = new ItemChange();
    
    public GridCellItemEvent(EventType<? extends Event> et) {
        super(et);
    }

    public GridCellItemEvent(Object o, EventTarget et, EventType<? extends Event> et1) {
        super(o, et, et1);
    }
    
    
    
    public static class ItemChange extends EventType<GridCellItemEvent>{
        
    }
}

package com.vikhi.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Design Java method signatures for something similar to the observer pattern with these specific requirements

 * Listeners are registered for a specific event type (defined by a String, similar to e.g. addEventListener in the DOM API).
 * Listeners can be unregistered from within the listener itself or from the outside.
 * Events can be fired and the correct listeners are notified. 
 * 
 * @author Vignesh Durairaj
 *
 */

class Event {
	
	private String eventName; //onClick or onBlur
	private EventListener listener;

	public Event(String eventName) {
		super();
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public EventListener getListener() {
		return listener;
	}

	public void setListener(EventListener listener) {
		this.listener = listener;
	}
	
	// Any custom events like DOM events, message -events (TDE)
}

public class EventListener {
	
	private List<Event> allEvents = new ArrayList<>();

	public List<Event> getAllEvents() {
		return allEvents;
	}

	public void unregisterEvent(final Event event) {
		this.allEvents.remove(event);
	}
	
	public void addEvent(Event event) {
		this.allEvents.add(event);
	}
	
	public void addEvents(Collection<Event> events) {
		for (Event event : events) {
			this.allEvents.add(event);
		}
	}
	
	public void callEvents() {
		 for (Event event : this.allEvents) {
			 this.handleEvent(event);
		 }
	}
	
	void handleEvent(Event event) {
		
	}
}

package ca.mun.whodunnit.gui;

import javax.swing.JTextArea;

import ca.mun.whodunnit.api.WhoDunnitMediator;
import ca.mun.whodunnit.api.Subscriber;

public class EventLog extends JTextArea implements Subscriber {
	/**
	 * 
	 */
	private static final long serialVersionUID = 500347484926295571L;
	private WhoDunnitMediator mediator;

	public EventLog(WhoDunnitMediator mediator, int rows, int col) {
		super(rows, col);
		this.mediator = mediator;
		mediator.registerSubscriber("EventLog", this);
	}

	@Override
	public void notify(String event) {
		this.setText(mediator.getEventLog());
	}
}

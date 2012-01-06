package org.softlang.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;

public class ButtonPanel extends Grid {

	private GwtTree main;
	
	public ButtonPanel(GwtTree main) {
		super(1, 2);
		
		this.main = main;
		
		Button createDep = new Button("create Department");
		Button createEmp = new Button("create Employee");
		
		createDep.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ButtonPanel.this.main.showDepartment(null);
			}
		});
		
		createEmp.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ButtonPanel.this.main.showEmployee(null);
			}
		});
		
		setWidget(0, 0, createDep);
		setWidget(0, 1, createEmp);
	}
}

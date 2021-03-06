package com.piercey.app.framework;

import com.google.inject.Inject;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

public class ApplicationProvider extends UIProvider
{
	private static final long serialVersionUID = -7515940655980636234L;
	private static final ApplicationLogger logger = new ApplicationLogger(ApplicationProvider.class);
	
	@Inject
	private Class<? extends UI> applicationClass;

	@Override
	public UI createInstance(UICreateEvent event)
	{
		logger.executionTrace();
		return ApplicationFilter.getApplicationInjector().getProvider(applicationClass).get();
	}

	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event)
	{
		logger.executionTrace();
		return applicationClass;
	}
}

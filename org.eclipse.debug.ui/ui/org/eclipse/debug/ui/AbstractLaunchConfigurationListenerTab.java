/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.ui;

import java.util.Set;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationListener;
import org.eclipse.swt.widgets.Composite;

/**
 * Common function for a launch tab that edits a launch mode. 
 * <p>
 * This class is intended to be subclassed by clients contributing launch tabs
 * that modify launch modes on a launch configuration.
 * </p>
 * @since 3.3
 * 
 * <p>
 * <strong>EXPERIMENTAL</strong>. This class has been added as
 * part of a work in progress. There is no guarantee that this API will
 * remain unchanged during the 3.3 release cycle. Please do not use this API
 * without consulting with the Platform/Debug team.
 * </p>
 */
public abstract class AbstractLaunchConfigurationListenerTab extends AbstractLaunchConfigurationTab implements ILaunchConfigurationListener {
	
	/**
	 * Returns the set of the modes this tab modifies.
	 * 
	 * @return set of the modes this tab modifies
	 */
	public abstract Set getModes();
	
	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(this);
	}
	
	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#dispose()
	 */
	public void dispose() {
		DebugPlugin.getDefault().getLaunchManager().removeLaunchConfigurationListener(this);
		super.dispose();
	}

	/**
	 * @see org.eclipse.debug.core.ILaunchConfigurationListener#launchConfigurationAdded(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void launchConfigurationAdded(ILaunchConfiguration configuration) {}

	/**
	 * @see org.eclipse.debug.core.ILaunchConfigurationListener#launchConfigurationRemoved(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void launchConfigurationRemoved(ILaunchConfiguration configuration) {}

}
/**
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.mvp.client;

import com.gwtplatform.mvp.client.proxy.TabContentProxy;

/**
 * @param <V> The specific type of the {@link View}. Must implement
 *          {@link TabPanel}.
 * 
 * @author Philippe Beaudoin
 */
public interface TabContainerPresenter<V extends View & TabPanel> extends Presenter<V> {

  /**
   * Adds a new tab to this presenter.
   * 
   * @param tabProxy The {@link TabContentProxy} containing information on the
   *          tab to add.
   * @return The newly added tab.
   */
  Tab addTab(TabContentProxy<?> tabProxy);

}

/**
 * Copyright 2010 Gwt-Platform
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gwtplatform.mvp.client.proxy;

import com.google.gwt.event.shared.GwtEvent;
import com.gwtplatform.mvp.client.EventBus;
import com.gwtplatform.mvp.client.Presenter;

/**
 * This event should be handled by {@link Proxy} classes. Upon handling
 * this event, the proxy should <b>first</b> set the content appropriately 
 * in the presenter, and then reveal the presenter.
 * 
 * @author Philippe Beaudoin
 */
public final class RevealContentEvent extends GwtEvent<RevealContentHandler<?>> {

  private final Type<RevealContentHandler<?>> type;
  private final Presenter content;

  public static void fire(
      final EventBus source,
      final Type<RevealContentHandler<?>> type,
      final Presenter content ) {
    source.fireEvent( new RevealContentEvent(type, content) );
  }

  public RevealContentEvent( Type<RevealContentHandler<?>> type, Presenter content ) {
    this.type = type;
    this.content = content;   
  }
  
  @Override
  protected void dispatch(RevealContentHandler<?> handler) {
    handler.onRevealContent( this );
  }

  @Override
  public Type<RevealContentHandler<?>> getAssociatedType() {
    return type;
  }

  public Presenter getContent() {
    return content;
  }

}
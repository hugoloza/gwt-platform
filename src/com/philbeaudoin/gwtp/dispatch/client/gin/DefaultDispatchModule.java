/**
 * Copyright 2010 Philippe Beaudoin
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

package com.philbeaudoin.gwtp.dispatch.client.gin;

import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.philbeaudoin.gwtp.dispatch.client.CookieSessionAccessor;
import com.philbeaudoin.gwtp.dispatch.client.DefaultExceptionHandler;
import com.philbeaudoin.gwtp.dispatch.client.DefaultDispatchAsync;
import com.philbeaudoin.gwtp.dispatch.client.DispatchAsync;
import com.philbeaudoin.gwtp.dispatch.client.ExceptionHandler;
import com.philbeaudoin.gwtp.dispatch.client.SessionAccessor;

/**
 * This module binds the {@link DefaultDispatchAsync} to {@link DispatchAsync}.
 * For simple cases, just set this as a \@GinModule in your {@link Ginjector} instance.
 * <p/>
 * If you want to provide a custom {@link ExceptionHandler} just call
 * <code>install( new StandardDispatchModule( MyExceptionHandler.class )</code>
 * in another module.
 * <p/>
 * You must also provide another module which binds an implementation of
 * {@link SessionAccessor}, such as {@link CookieSessionAccessor}
 * or {@link AppEngineSecureSessionAccessor}.
 *
 * @author David Peterson
 */
public class DefaultDispatchModule extends AbstractDispatchModule {

    /**
     * Constructs a new GIN configuration module that sets up a secure {@link com.philbeaudoin.gwtp.dispatch.client.DefaultDispatchAsync}
     * implementation, using the {@link com.philbeaudoin.gwtp.dispatch.client.DefaultExceptionHandler}.
     */
    public DefaultDispatchModule() {
        this( DefaultExceptionHandler.class );
    }

    /**
     * Constructs a new GIN configuration module that sets up a secure {@link com.philbeaudoin.gwtp.dispatch.client.DefaultDispatchAsync}
     * implementation, using the provided {@link ExceptionHandler} implementation class.
     *
     * @param exceptionHandlerType The {@link ExceptionHandler} implementation class.
     */
    public DefaultDispatchModule( Class<? extends ExceptionHandler> exceptionHandlerType ) {
        super( exceptionHandlerType );
    }

    @Provides
    @Singleton
    protected DefaultDispatchAsync provideDispatchAsync( ExceptionHandler exceptionHandler, SessionAccessor secureSessionAccessor ) {
        return new DispatchAsync( exceptionHandler, secureSessionAccessor );
    }

}
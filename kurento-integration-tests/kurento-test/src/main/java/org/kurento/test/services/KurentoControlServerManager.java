/*
 * (C) Copyright 2014 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package org.kurento.test.services;

import org.kurento.control.server.KurentoControlServerApp;
import org.kurento.jsonrpc.client.JsonRpcClient;
import org.springframework.context.ConfigurableApplicationContext;

public class KurentoControlServerManager {

	private ConfigurableApplicationContext context;

	public KurentoControlServerManager(JsonRpcClient client, int httpPort) {

		KurentoControlServerApp.setJsonRpcClient(client);

		System.setProperty(KurentoControlServerApp.WEBSOCKET_PORT_PROPERTY,
				Integer.toString(httpPort));

		context = KurentoControlServerApp.start();
	}

	public void destroy() {
		context.close();
	}
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package c10n.tools.search;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import c10n.C10NMessages;
import c10n.tools.search.test1.Buttons;
import c10n.tools.search.test1.Window;
import c10n.tools.search.test1.labels.Labels;
import c10n.tools.search.test1.labels.Labels1;
import c10n.tools.search.test1.labels.Labels2;

public class C10NInterfaceSearchTest {
	private final C10NInterfaceSearch s = new DefaultC10NInterfaceSearch();

	@Test
	@SuppressWarnings("unchecked")
	public void retrieveAllInterfaceAndSubInterfaceMethodsAsKeys() {
		Set<Class<?>> c10nInterfaces = s.find("c10n.tools.search.test1", C10NMessages.class);
		assertThat(c10nInterfaces, is(set(Window.class,//
				Buttons.class,//
				Labels.class,//
				Labels1.class,//
				Labels2.class)));
	}

	private static <E> Set<E> set(E... args) {
		return new HashSet<E>(Arrays.asList(args));
	}
}

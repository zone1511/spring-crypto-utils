/*
 * Copyright 2012 Mirko Caserta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this software except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.springcryptoutils.core.keystore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.KeyStore;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class KeyStoreRegistryImplTest {

    @Autowired
    private KeyStoreRegistry keyStoreRegistry;

    @Test
    public void testKeyStoreRegistryIsProperlyConfigured() {
        assertNotNull(keyStoreRegistry);
        KeyStore keystoreOne = keyStoreRegistry.get(new KeyStoreChooser() {
            public String getKeyStoreName() {
                return "keystoreOne";
            }
        });
        KeyStore keystoreTwo = keyStoreRegistry.get(new KeyStoreChooser() {
            public String getKeyStoreName() {
                return "keystoreTwo";
            }
        });
        assertNotNull(keystoreOne);
        assertNotNull(keystoreTwo);
        assertEquals("JKS", keystoreOne.getType());
        assertEquals("JKS", keystoreTwo.getType());
        assertNotSame(keystoreOne, keystoreTwo);
    }

}
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jnosql.diana.api.reader;


import org.jnosql.diana.api.ValueReader;

/**
 * Class to reads and converts to {@link Long}, first it verify if is Double if yes return itself then verifies if is
 * {@link Number} and use {@link Number#longValue()} otherwise convert to {@link String} and then {@link Long}
 */
@SuppressWarnings("unchecked")
public final class LongValueReader implements ValueReader {

    @Override
    public <T> boolean isCompatible(Class<T> clazz) {
        return Long.class.equals(clazz) || long.class.equals(clazz);
    }

    @Override
    public <T> T read(Class<T> clazz, Object value) {

        if (Long.class.isInstance(value)) {
            return (T) value;
        }
        if (Number.class.isInstance(value)) {
            return (T) Long.valueOf(Number.class.cast(value).longValue());
        } else {
            return (T) Long.valueOf(value.toString());
        }
    }
}

/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.token.writer;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpHeaderValues;
import io.micronaut.http.HttpHeaders;
import io.micronaut.security.token.config.TokenConfigurationProperties;

/**
 *  HTTP Token Writer Configuration Properties.
 *
 * @author Sergio del Amo
 * @since 1.0
 */
@Requires(property = HttpHeaderTokenWriterConfigurationProperties.PREFIX + ".enabled", notEquals = StringUtils.FALSE)
@ConfigurationProperties(HttpHeaderTokenWriterConfigurationProperties.PREFIX)
public class HttpHeaderTokenWriterConfigurationProperties implements HttpHeaderTokenWriterConfiguration {
    public static final String PREFIX = TokenConfigurationProperties.PREFIX + ".writer.header";

    /**
     * The default enable value.
     */
    @SuppressWarnings("WeakerAccess")
    public static final boolean DEFAULT_ENABLED = true;
    private static final String DEFAULT_PREFIX = HttpHeaderValues.AUTHORIZATION_PREFIX_BEARER;
    private static final String DEFAULT_HEADER_NAME = HttpHeaders.AUTHORIZATION;

    private String prefix = DEFAULT_PREFIX;
    private String headerName = DEFAULT_HEADER_NAME;
    private boolean enabled = DEFAULT_ENABLED;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Enable {@link io.micronaut.security.token.writer.HttpHeaderTokenWriter}. Default value ({@value #DEFAULT_ENABLED}).
     * @param enabled enabled flag
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Value prefix for Http Header. Default value ({@value #DEFAULT_PREFIX}).
     * @param prefix preffix before the header value
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     *
     * @return a Prefix before the token in the header value. E.g. Bearer
     */
    @Override
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * Http Header to be used to propagate the token. Default value ({@value #DEFAULT_HEADER_NAME})
     * @param headerName HTTP header name
     */
    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    /**
     *
     * @return an HTTP Header name. e.g. Authorization
     */
    @Override
    public String getHeaderName() {
        return this.headerName;
    }
}

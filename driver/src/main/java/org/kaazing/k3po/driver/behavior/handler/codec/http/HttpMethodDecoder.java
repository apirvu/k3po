/*
 * Copyright (c) 2014 "Kaazing Corporation," (www.kaazing.com)
 *
 * This file is part of Robot.
 *
 * Robot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.kaazing.k3po.driver.behavior.handler.codec.http;

import static java.lang.String.format;
import static org.jboss.netty.buffer.ChannelBuffers.copiedBuffer;
import static org.jboss.netty.util.CharsetUtil.UTF_8;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.kaazing.k3po.driver.behavior.handler.codec.AbstractConfigDecoder;
import org.kaazing.k3po.driver.behavior.handler.codec.MessageDecoder;
import org.kaazing.k3po.driver.netty.bootstrap.http.HttpChannelConfig;

public class HttpMethodDecoder extends AbstractConfigDecoder {

    private final MessageDecoder methodDecoder;

    public HttpMethodDecoder(MessageDecoder methodValueDecoder) {
        this.methodDecoder = methodValueDecoder;
    }

    @Override
    public void decode(Channel channel) throws Exception {
        HttpChannelConfig httpConfig = (HttpChannelConfig) channel.getConfig();
        HttpMethod method = httpConfig.getMethod();
        String methodName = method.getName();
        ChannelBuffer buffer = copiedBuffer(methodName, UTF_8);
        methodDecoder.decode(buffer);
    }

    @Override
    public String toString() {
        return format("http:method %s", methodDecoder);
    }

}
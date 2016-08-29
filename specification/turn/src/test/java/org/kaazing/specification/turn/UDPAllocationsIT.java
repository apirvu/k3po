/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
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
package org.kaazing.specification.turn;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

/**
 * Test to validate behavior as specified in <a href="https://tools.ietf.org/html/rfc5766">RFC 5766: TURN</a> through TCP.
 */
public class AllocationsIT {

    private final K3poRule k3po = new K3poRule().setScriptRoot("org/kaazing/specification/turn/allocations");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.simple.allocate.method/request", "UDP.simple.allocate.method/response"})
    public void shouldSucceedWithGenericSTUNHeader() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.two.allocate.methods.with.no.credentials/request", "UDP.two.allocate.methods.with.no.credentials/response"})
    public void shouldRespondWithTwo401sWhenGivenAllocateMethodsWithNoCred() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.allocate.method.with.requested.transport.attribute/request",
            "UDP.allocate.method.with.requested.transport.attribute/response"})
    public void shouldSucceedWithOnlyTransportAttribute() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.correct.allocation.method/request", "UDP.correct.allocation.method/response"})
    public void shouldSucceedWithCorrectAllocation() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.attribute.length.over.message.length/request", "UDP.attribute.length.over.message.length/response"})
    public void shouldGive400WithIncorrectLength() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.incorrect.attribute.length.with.error.message.length/request",
            "UDP.incorrect.attribute.length.with.error.message.length/response"})
    public void shouldGive400WithIncorrectLength2() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.multiple.connections.with.same.credentials.responds.437/request",
            "UDP.multiple.connections.with.same.credentials.responds.437/response"})
    public void shouldRespond437ToMultipleConnectionsWithSameCredentials() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.wrong.credentials.responds.441/request", "UDP.wrong.credentials.responds.441/response"})
    public void shouldRespond441ToWrongCredentials() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.unknown.attribute.responds.420/request", "UDP.unknown.attribute.responds.420/response"})
    public void unknownAttributeShouldRespond420() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc5766#section-6">RFC 5766 section 6: Allocations</a>.
     */
    @Test
    @Specification({"UDP.no.requested.transport.attribute.responds.400/request",
            "UDP.no.requested.transport.attribute.responds.400/response"})
    public void shouldRespond400ToAllocateWithNoRequestedTransportAttribute() throws Exception {
        k3po.finish();
    }

}

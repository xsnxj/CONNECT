/*
 * Copyright (c) 2012, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.hhs.fha.nhinc.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommon.HomeCommunityType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetCommunitiesType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetCommunityType;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;

import org.hl7.v3.PRPAIN201305UV02;
import org.junit.Test;

/**
 * @author akong
 * 
 */
public class MessageGeneratorUtilsTest {

    private MessageGeneratorUtils msgUtils = MessageGeneratorUtils.getInstance();

    @Test
    public void convertFirstToNhinTargetSystemType() {

        assertNull(msgUtils.convertFirstToNhinTargetSystemType(null).getHomeCommunity());

        NhinTargetCommunitiesType targets = new NhinTargetCommunitiesType();
        assertNull(msgUtils.convertFirstToNhinTargetSystemType(targets).getHomeCommunity());

        NhinTargetCommunityType targetCommunity = new NhinTargetCommunityType();
        targetCommunity.setHomeCommunity(new HomeCommunityType());
        targetCommunity.getHomeCommunity().setHomeCommunityId("1.1");
        targets.getNhinTargetCommunity().add(targetCommunity);

        assertEquals("1.1", msgUtils.convertFirstToNhinTargetSystemType(targets).getHomeCommunity()
                .getHomeCommunityId());

        NhinTargetCommunityType targetCommunity2 = new NhinTargetCommunityType();
        targetCommunity2.setHomeCommunity(new HomeCommunityType());
        targetCommunity2.getHomeCommunity().setHomeCommunityId("2.2");
        targets.getNhinTargetCommunity().add(targetCommunity2);

        assertEquals(2, targets.getNhinTargetCommunity().size());
        assertEquals("1.1", msgUtils.convertFirstToNhinTargetSystemType(targets).getHomeCommunity()
                .getHomeCommunityId());
    }
    
    @Test
    public void cloneAssertion() {
        AssertionType assertion = new AssertionType();
        assertion.setMessageId("11111");
        
        AssertionType copyAssertion = msgUtils.clone(assertion);               
        assertion.setMessageId("22222");
        
        assertEquals("11111", copyAssertion.getMessageId());       
    }
    
    @Test
    public void cloneAssertionWithNewMsgId() {
        AssertionType assertion = new AssertionType();
        assertion.setMessageId("11111");
        
        AssertionType copyAssertion = msgUtils.cloneWithNewMsgId(assertion);               
                
        assertFalse(copyAssertion.getMessageId().equals("11111"));
    }
    
    @Test
    public void cloneAdhocQueryRequest() {
        AdhocQueryRequest request = new AdhocQueryRequest();
        request.setId("11111");
        
        AdhocQueryRequest clonedRequest = msgUtils.clone(request);
        request.setId("22222");
        
        assertEquals("11111", clonedRequest.getId());
    }
    
    @Test
    public void clonePRPAIN201305UV02() {
        PRPAIN201305UV02 request = new PRPAIN201305UV02();
        request.setITSVersion("11111");
        
        PRPAIN201305UV02 clonedRequest = msgUtils.clone(request);
        request.setITSVersion("22222");
        
        assertEquals("11111", clonedRequest.getITSVersion());
    }
}

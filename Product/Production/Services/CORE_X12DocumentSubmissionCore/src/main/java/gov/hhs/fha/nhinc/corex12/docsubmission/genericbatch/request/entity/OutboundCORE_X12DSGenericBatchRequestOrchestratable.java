/*
 * Copyright (c) 2014, United States Government, as represented by the Secretary of Health and Human Services.
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
package gov.hhs.fha.nhinc.corex12.docsubmission.genericbatch.request.entity;

import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetSystemType;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants;
import gov.hhs.fha.nhinc.orchestration.AuditTransformer;
import gov.hhs.fha.nhinc.orchestration.NhinAggregator;
import gov.hhs.fha.nhinc.orchestration.OutboundDelegate;
import gov.hhs.fha.nhinc.orchestration.OutboundOrchestratable;
import gov.hhs.fha.nhinc.orchestration.PolicyTransformer;
import org.caqh.soap.wsdl.corerule2_2_0.COREEnvelopeBatchSubmission;
import org.caqh.soap.wsdl.corerule2_2_0.COREEnvelopeBatchSubmissionResponse;

/**
 *
 * @author svalluripalli
 */
public class OutboundCORE_X12DSGenericBatchRequestOrchestratable implements OutboundOrchestratable {

    protected NhinTargetSystemType target = null;
    private AssertionType assertion = null;
    private OutboundDelegate nhinDelegate = null;
    private COREEnvelopeBatchSubmission request = null;
    private COREEnvelopeBatchSubmissionResponse response = null;

    /**
     * 
     * @return 
     */
    @Override
    public AssertionType getAssertion() {
        return assertion;
    }

    /**
     * 
     * @param assertion 
     */
    public void setAssertion(AssertionType assertion) {
        this.assertion = assertion;
    }

    /**
     *
     * @return NhinTargetSystemType
     */
    public NhinTargetSystemType getTarget() {
        return target;
    }

    /**
     *
     * @param target
     */
    public void setTarget(NhinTargetSystemType target) {
        this.target = target;
    }

    /**
     *
     * @return COREEnvelopeBatchSubmission
     */
    public COREEnvelopeBatchSubmission getRequest() {
        return request;
    }

    /**
     *
     * @param request
     */
    public void setRequest(COREEnvelopeBatchSubmission request) {
        this.request = request;
    }

    /**
     *
     * @return COREEnvelopeBatchSubmissionResponse
     */
    public COREEnvelopeBatchSubmissionResponse getResponse() {
        return response;
    }

    /**
     *
     * @param response
     */
    public void setResponse(COREEnvelopeBatchSubmissionResponse response) {
        this.response = response;
    }

    /**
     *
     * @param delegate
     */
    public OutboundCORE_X12DSGenericBatchRequestOrchestratable(OutboundDelegate delegate) {
        this.nhinDelegate = delegate;
    }

    /**
     *
     * @param delegate
     * @param request
     * @param target
     * @param assertion
     */
    public OutboundCORE_X12DSGenericBatchRequestOrchestratable(OutboundDelegate delegate,
        COREEnvelopeBatchSubmission request, NhinTargetSystemType target, AssertionType assertion) {
        this(delegate);
        this.assertion = assertion;
        this.request = request;
        this.target = target;
    }

    @Override
    public OutboundDelegate getDelegate() {
        return getNhinDelegate();
    }

    /**
     *
     * @return OutboundDelegate
     */
    public OutboundDelegate getNhinDelegate() {
        return nhinDelegate;
    }

    @Override
    public NhinAggregator getAggregator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPassthru() {
        return true;
    }

    @Override
    public AuditTransformer getAuditTransformer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PolicyTransformer getPolicyTransformer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getServiceName() {
        return NhincConstants.ENTITY_CORE_X12DS_GENERICBATCH_REQUEST_SERVICE_NAME;
    }
}

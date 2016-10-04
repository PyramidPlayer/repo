package me.jetmoney.rest;

import com.jetmoney.common.model.core.JetMoneyResponse;
import me.jetmoney.billing.request.BillingRequest;
import me.jetmoney.billing.rest.BillingClient;
import me.jetmoney.business.BillingBusiness;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by toroptsev on 21.09.16.
 */
@Path("/billing")
public class BillingResource implements BillingClient {

    @Inject
    private BillingBusiness billingBusiness;

    @Path("/info")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response info(BillingRequest request) {
        JetMoneyResponse response = billingBusiness.info(request);
        return Response.ok(response).build();
    }

    @Path("/pay")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response pay(BillingRequest request) {
        JetMoneyResponse response = billingBusiness.pay(request);
        return Response.ok(response).build();
    }
}

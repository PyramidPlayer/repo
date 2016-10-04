package me.jetmoney.billing.rest;

import me.jetmoney.billing.request.BillingRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by toroptsev on 21.09.16.
 */
@Path("/rest/billing")
public interface BillingClient {

    @Path("/info")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response info(BillingRequest request);

    @Path("/pay")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response pay(BillingRequest request);
}

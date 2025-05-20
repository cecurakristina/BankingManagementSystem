package bankingManagementSystem;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/WebCustomer")
public class WebCustomerResource {

    @GET
    @Produces(MediaType.TEXT_HTML)  
    public String getAllCustomersHTML() {
        List<Customer> customers = BankData.getInstance().getCustomerList();

        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<h2>Customer List</h2>");
        sb.append("<ul>");
        for (Customer c : customers) {
            sb.append("<li>")
              .append("ID: ").append(c.getCustId()).append(" - ")
              .append("Name: ").append(c.getCustName()).append(" - ")
              .append("Email: ").append(c.getEmail())
              .append("</li>");
        }
        sb.append("</ul>");
        sb.append("</body></html>");

        return sb.toString();
    }

    @GET
    @Path("/json")  
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomersJSON() {
        return BankData.getInstance().getCustomerList();
    }
    
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> searchCustomers(@QueryParam("name") String name) {
        List<Customer> all = BankData.getInstance().getCustomerList();
        List<Customer> result = new ArrayList<>();

        for (Customer c : all) {
            if (c.getCustName().toLowerCase().contains(name.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}

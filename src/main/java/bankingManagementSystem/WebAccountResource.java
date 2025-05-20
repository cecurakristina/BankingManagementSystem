package bankingManagementSystem;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/WebAccount")
public class WebAccountResource {

    @GET
    @Produces(MediaType.TEXT_HTML) 
    public String getAllAccountsHTML() {
        List<Account> accounts = BankData.getInstance().getAccountList();

        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<h2>Account List</h2>");
        sb.append("<ul>");
        for (Account a : accounts) {
            sb.append("<li>")
              .append("Account No: ").append(a.getAccountNumber()).append(" - ")
              .append("Type: ").append(a.getAccountType()).append(" - ")
              .append("Balance: $").append(a.getBalance()).append(" - ")
              .append("Customer: ").append(a.getCustomer().getCustName())
              .append("</li>");
        }
        sb.append("</ul>");
        sb.append("</body></html>");

        return sb.toString();
    }

    @GET
    @Path("/json")   
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAllAccountsJSON() {
        return BankData.getInstance().getAccountList();
    }
    
    @GET
    @Path("/search")
    @Produces (MediaType.APPLICATION_JSON)
    public List<Account> searchAccount(@QueryParam ("account") String account)
    {
    	List<Account> all = BankData.getInstance().getAccountList();
        List<Account> result = new ArrayList();
        
        for (Account a : all)
        {
        	if (a.getAccountType().equalsIgnoreCase(account))
        	{
        		result.add(a);
        	}
        }
        return result;
    }
    
    @GET
    @Path("/searchByBalance")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Account> searchByBalance(@QueryParam ("min") double min, @QueryParam("max") double max)
    {
    	List<Account> all = BankData.getInstance().getAccountList();
    	List<Account> result = new ArrayList();
    	
    	for (Account a : all)
    	{
    		if (a.getBalance() <= max && a.getBalance() >= min)
    		{
    			result.add(a);
    		}
    	}
    	return result;
    }
    
    @GET
    @Path("/searchByCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> searchByCustomer(@QueryParam("id") String id) {
        List<Account> all = BankData.getInstance().getAccountList();
        List<Account> result = new ArrayList<>();

        for (Account a : all) {
            if (a.getCustomer().getCustId().equalsIgnoreCase(id)) {
                result.add(a);
            }
        }
        return result;
    }
}


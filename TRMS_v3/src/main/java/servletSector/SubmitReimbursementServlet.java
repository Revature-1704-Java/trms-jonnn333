package servletSector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ReimburseDAO;
import the_beans.Reimburse;

/**
 * Servlet implementation class SubmitReimbursementServlet
 */
public class SubmitReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("Link.html").include(request, response);
		
		HttpSession session = request.getSession(false); // if session doesn't exist, create new session

		if(session != null){
			String name = (String) session.getAttribute("name");
			out.print("Hello, "+name+", Welcome to your Profile page!");
			
			//String reimburseID = request.getParameter("reimburseID");
			int employeeID = Integer.parseInt(request.getParameter("employeeID"));
			int reimburseID = Integer.parseInt(request.getParameter("reimburseID")); // PK
			int eventID = Integer.parseInt(request.getParameter("eventID")); 
			String eventDescription = request.getParameter("eventDescription");
			String address = request.getParameter("eventAddress");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country"); // US-only at the moment
			String zipCode = request.getParameter("zipCode");
			String eventJustification = request.getParameter("eventJustification");
			
			out.print("parameters received");
			java.util.Date event_timeStamp = null;
			String event_timeStamp_str = request.getParameter("event_timeStamp");			

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//surround below line with try catch block as below code throws checked exception
			try {
				event_timeStamp = sdf.parse(event_timeStamp_str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//do further processing with Date object
			out.println(sdf.format(event_timeStamp)); //this is what you want yyyy-MM-dd  
			
			// credit to: https://stackoverflow.com/questions/36613353/passing-date-from-jsp-to-servlet-using-getparametervalues
			/*
			String[] availableDate = request.getParameterValues("event_timeStamp");
			SimpleDateFormat availDate = new SimpleDateFormat("MM-dd-yyyy");
			
			Date event_timeStamp = null;
			try {
				event_timeStamp = (Date) availDate.parse(availableDate[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			*/

			int gradeFormatID = 1;// Integer.parseInt(request.getParameter("gradeFormatID"));
			double reimbursementCost = Double.parseDouble(request.getParameter("reimbursementCost"));
			int timeMissed = Integer.parseInt(request.getParameter("timeMissed"));
			
			// default values when initially submitting a request
			double reimburseAward = 0.0;
			double exceedsAmount = 0.0;
			int status = 0;
			String exceedsReason = null;
			String denyReason = null;
			Date supApprove = null;
			Date deptHeadApprove = null;
			Date benCoApprove = null;
			
			// all other attributes ie. submission time, status, exceeds/denied reason will be handled in DAO
			
			ReimburseDAO handleReimbursements = new ReimburseDAO();
			Date submissionTime = handleReimbursements.getTodaysDate();
			
			Reimburse ReimburseEntry = new Reimburse (reimburseID, employeeID, eventID, 
					eventDescription, address, city, state, country, zipCode, eventJustification, gradeFormatID,
					new java.sql.Date(event_timeStamp.getTime()), reimbursementCost, reimburseAward, submissionTime, timeMissed, status, exceedsAmount, 
					exceedsReason, denyReason, supApprove, deptHeadApprove, benCoApprove);
			
			out.print("<br/>Your reimbursement object is: <br/>"+ReimburseEntry.toString());
			
			handleReimbursements.insertReimbursement(ReimburseEntry);
			
		}
		else {
			out.print("Please login first");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

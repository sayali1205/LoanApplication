package com.loan.achintya.data.serviceImpl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.loan.achintya.data.model.BaseResponse;
import com.loan.achintya.data.model.Customer;
import com.loan.achintya.data.model.Transaction;
import com.loan.achintya.data.repository.CustomerRepository;
import com.loan.achintya.data.repository.SanctionRepo;
import com.loan.achintya.data.service.CustomerService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository cr;
	
	@Autowired
	SanctionRepo sr;
	
	@Autowired
	JavaMailSender jms;
	
	@Override

		public void getSanction(int sanctionId,String fromEmail) throws DocumentException

		{

		String title="Sanction Letter";

		String LoanName="Quick_Car_Loan";
		
		

		Date date=new Date();

		DateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");

		String formatedDate=dateformat.format(date);

		// String to="Date-:"+formatedDate+"\n Dear User, Thank You for choosing Quick Car Loan Based on the application and information we are delight to offer to you loan as per the preliminary terms and condition mentioned below";

		ByteArrayOutputStream bytearray=new ByteArrayOutputStream();

		Document document=new Document();

		PdfWriter.getInstance(document, bytearray);

		document.open();

		Font titlefont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);

		Paragraph titlepara=new Paragraph(title,titlefont);

		titlepara.setAlignment(Element.ALIGN_CENTER);

		document.add(titlepara);

		String nextline=" Thank You for choosing "+LoanName+" Based on the application and information we are delight to offer to you loan as per the preliminary terms and condition mentioned!!";

		
		
		Font loanFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);

		Paragraph loanPara=new Paragraph(LoanName,loanFont);

		document.add(loanPara);

		Optional<Customer> sanctionDetail=cr.findById(sanctionId);

		Customer sanctionData=sanctionDetail.get();

		String to="Date-:"+formatedDate+"\n Dear,\n "+sanctionData.getCustFirstName()+" "+sanctionData.getCustLastName();

		Paragraph topara=new Paragraph(to);

		topara.setSpacingBefore(10);

		topara.setSpacingAfter(10);

		document.add(topara);
		
		
		Paragraph tonextLine=new Paragraph(nextline);
		tonextLine.setSpacingBefore(10);
		tonextLine.setSpacingAfter(10);
		
		document.add(tonextLine);
		
		PdfPTable table=new PdfPTable(2);

		// table.setWidths(new int [] {1,3,3,3,3});

		table.setWidths(new int [] {5,5});

		table.setWidthPercentage(100);

		table.setSpacingBefore(20);

		PdfPCell headcell=new PdfPCell();

		headcell.setPadding(10);

		Font headCellFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);

		headcell.setPhrase(new Phrase("Applicant Name",headCellFont));

		table.addCell(headcell);

		headcell.setPhrase(new Phrase(String.valueOf(sanctionData.getCustFirstName()+" "+sanctionData.getCustLastName())));

		table.addCell(headcell);

		headcell.setPhrase(new Phrase("Applicant Mobile No",headCellFont));

		table.addCell(headcell);

		headcell.setPhrase(new Phrase(String.valueOf(sanctionData.getCustContactNo())));

		table.addCell(headcell);

		headcell.setPhrase(new Phrase("Applicant Email",headCellFont));

		table.addCell(headcell);

		headcell.setPhrase(new Phrase(String.valueOf(sanctionData.getCustEmailId())));

		table.addCell(headcell);

		PdfPCell headcell1=new PdfPCell();

		headcell1.setPadding(10);

		Font headCellFont1=FontFactory.getFont(FontFactory.HELVETICA_BOLD);

//		headcell1.setPhrase(new Phrase("Loan Type",headCellFont1));
//
//		table.addCell(headcell1);

		//headcell1.setPhrase(new Phrase(sanctionData.getSactiondetails().getLoanType()));

		//table.addCell(headcell1);

		headcell1.setPhrase(new Phrase("Sanctioned Ammount",headCellFont1));

		table.addCell(headcell1);

		headcell1.setPhrase(new Phrase(String.valueOf(sanctionData.getSactiondetails().getLoanAmountSanctioned())));

		table.addCell(headcell1);

		headcell1.setPhrase(new Phrase("Tennure Year",headCellFont1));

		table.addCell(headcell1);

		headcell1.setPhrase(new Phrase(String.valueOf(sanctionData.getSactiondetails().getTenureInYearSanctioned())));

		table.addCell(headcell1);

		headcell1.setPhrase(new Phrase("Monthly EMI",headCellFont1));

		table.addCell(headcell1);

		headcell1.setPhrase(new Phrase(String.valueOf(sanctionData.getSactiondetails().getMonthlyEmi())));

		table.addCell(headcell1);

//		headcell1.setPhrase(new Phrase("Disbursment Status",headCellFont1));
//
//		table.addCell(headcell1);

		//headcell1.setPhrase(new Phrase(sanctionData.getSactiondetails().getDisbursementStatus()));

		//table.addCell(headcell1);

		document.add(table);


		
		String thanks="Yours Faithfully\n"+"BRANCH MANAGER\n"+"Pratik N.";
		
		Paragraph thnx=new Paragraph(thanks);
		
		thnx.setAlignment(Element.ALIGN_RIGHT);
		
		thnx.setSpacingBefore(20);
		
		
		document.add(thnx);

		document.close();

		byte[] mailPdfbytes=bytearray.toByteArray();

		sanctionData.getSactiondetails().setSanctionPdf(bytearray.toByteArray());

		cr.save(sanctionData);

		MimeMessage mime=jms.createMimeMessage();

		try {

		File file=new File("Sanctionletter.pdf");

		file.createNewFile();

		OutputStream out=new FileOutputStream(file);

		out.write(mailPdfbytes);

		out.close();

		MimeMessageHelper helper=new MimeMessageHelper(mime,true);

		helper.setTo(sanctionData.getCustEmailId());

		helper.setFrom(fromEmail);

		helper.setText("Dear Customer, ");

		helper.setSubject("Sanction Letter has been provided to you please find the attachment");

		helper.addAttachment("pdf.pdf", file.getAbsoluteFile());

		jms.send(mime);

		}

		catch (Exception e) {

		System.out.println("mail sending problem");

		e.printStackTrace();

		}

		}

		
		
	
	
	
	@Override
	public Customer saveCustomer(Customer cust) {
		
		return cr.save(cust);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return cr.findAll();
		
	}

	@Override
	public Customer getByid(int custId) {
		
		Optional<Customer> op=cr.findById(custId);
		if(op.isPresent()) {
			Customer cus=op.get();
			cus.getLoanDetails().setLoanStatus("VERIFIED");
			return cr.save(cus);
		}
		else {
		
		return  null;
		}	}

	@Override
	public Optional<Customer> getByVerified(int custId) {
		//String loanstatus=c.getLoanDetails().getLoanStatus();;
		Optional<Customer> op=cr.findById(custId);
		if(op.isPresent()) {
			
			Customer cus=op.get();
			if(cus.getLoanDetails().getLoanStatus().equalsIgnoreCase("VERIFIED")) { 
			//cus.getLoanDetails().setLoanStatus("VERIFIED");
			return op;
			}else {
				return null;
			}

		}
		else {
		
		return  null;
		}
	}

	@Override
	public List<Customer> getAllVerifiedCustomer() {
		cr.findAll();
	List<Customer> l= cr.findAll();
	Iterator<Customer> itr=l.iterator();
	List<Customer> list=new ArrayList<>();
	while(itr.hasNext()) {
		Customer cus=itr.next();
		
		if(cus.getLoanDetails().getLoanStatus().equalsIgnoreCase("VERIFIED")) { 
			
			list.add(cus);
			
			}
	}

	System.out.println(l.size());
	
	System.out.println(list.size());
		
		return list;
	}

	@Override
	public Customer getCustByid(int custId) {
		Optional<Customer> op=cr.findById(custId);
		if(op.isPresent()) {
			Customer cus=op.get();
			return cus;
		}
		return null;
	}

	@Override
	public Customer saveSCust(Customer c) {
		
		return cr.save(c);
	}


//	Optional<Customer> op=cr.findById(userId);
//	if(op.isPresent()) {
//		
//		Customer c=op.get();
//		
//		double accBalance=c.getBankDetails().getAccountBalance();
//		
//		accBalance=accBalance+c.getSactiondetails().getLoanAmountSanctioned();
//		
//		c.getBankDetails().setAccountBalance(accBalance);
//		
//		cr.save(c);
//		
//		return new BaseResponse(201,"amount credited successfully");
//	}
//	else{
//           return new BaseResponse(201,"amount credited successfully");
//         }

	@Override
	public BaseResponse saveTransactionHistory( int userId) {
		
		Optional<Customer> op=cr.findById(userId);
		
		if(op.isPresent()) {
			
			Customer c=op.get();
			
			double accBalance=c.getBankDetails().getAccountBalance();
			
			accBalance=accBalance+c.getSactiondetails().getLoanAmountSanctioned();
			
			Transaction t=new Transaction();
			t.setTransactionAmount(c.getSactiondetails().getLoanAmountSanctioned());
			t.setRemainningAccountBalance(accBalance);
			
			c.getBankDetails().setAccountBalance(accBalance);
			
			c.getSactiondetails().setDisbursementStatus("Disbursed");
			
			cr.save(c);
			
			return new BaseResponse(201,"amount credited successfully");

		}
		else {
	           return new BaseResponse(404,"Customer Not Found");

		}
		
		
		
		
		
		

	}

}

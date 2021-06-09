package tn.esprit.spring.controller;



import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
//import org.primefaces.PrimeFaces;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;


//import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.service.MeubleService;
import tn.esprit.spring.service.MeubleServiceImpl;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.entity.Type_Meuble;
import tn.esprit.spring.helper.FileUploadUtil;
import tn.esprit.spring.repository.MeubleRepo;
@ManagedBean
@Scope
@Controller(value = "JsfController")
@ELBeanName(value = "JsfController")
@Join(path = "/Dari", to = "/DariTn/AdminMeuble.jsf")
public class JsfController {
	@Autowired
	MeubleService MeubleService;
	@Autowired
	MeubleRepo mr;
	@Autowired
	MeubleServiceImpl ms;
	@Autowired
	MeubleController mc;
	
	private String nom_meuble;
	private Type_Meuble typem;
    private Part file;
    private String folder = "c:\\files";
	private String picture;
	private String description_meuble;
	private float price;
	private List<Meubles> meuble;
	private List<Meubles> cmd_m;
	public List<Meubles> getCmd_m() {
		return cmd_m;
	}
	public void setCmd_m(List<Meubles> cmd_m) {
		this.cmd_m = cmd_m;
	}
	private long ref_meuble;
	private long update;
	private int qte;
	private Commande cmd;
	private Meubles m=new Meubles();
	private Client client;
	
	
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public MeubleRepo getMr() {
		return mr;
	}
	public void setMr(MeubleRepo mr) {
		this.mr = mr;
	}
	public MeubleService getMeubleService() {
		return MeubleService;
	}
	public void setMeubleService(MeubleService meubleService) {
		MeubleService = meubleService;
	}
	public MeubleServiceImpl getMs() {
		return ms;
	}
	public void setMs(MeubleServiceImpl ms) {
		this.ms = ms;
	}
	public MeubleController getMc() {
		return mc;
	}
	public void setMc(MeubleController mc) {
		this.mc = mc;
	}
	public String getNom_meuble() {
		return nom_meuble;
	}
	public void setNom_meuble(String nom_meuble) {
		this.nom_meuble = nom_meuble;
	}
	public String getDescription_meuble() {
		return description_meuble;
	}
	public void setDescription_meuble(String description_meuble) {
		description_meuble = description_meuble;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<Meubles> getMeuble() {
		meuble = MeubleService.retrieveAllMeubles();
		return meuble;
	}
	public void setMeuble(List<Meubles> meuble) {
		this.meuble = meuble;
	}
	public long getIdProduct() {
		return ref_meuble;
	}
	public void setIdProduct(long idProduct) {
		this.ref_meuble = idProduct;
	}
	
	public Type_Meuble[] getType() {
		return  Type_Meuble.values();
	}
	public void setType_meuble(Type_Meuble typem) {
		this.typem = typem;
	}
	
	public Type_Meuble getTypem() {
		return typem;
	}
	public void setTypem(Type_Meuble typem) {
		this.typem = typem;
	}
	public long getRef_meuble() {
		return ref_meuble;
	}
	public void setRef_meuble(long ref_meuble) {
		this.ref_meuble = ref_meuble;
	}
	public long getUpdate() {
		return update;
	}
	public void setUpdate(long update) {
		this.update = update;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Commande getCmd() {
		return cmd;
	}
	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}
	public Meubles getM() {
		return m;
	}
public void setM(Meubles m) {
		this.m = m;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void save()

		{
			
		mr.save(m);
        this.meuble.add(this.m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
//        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
//        return "/DariTn/Meuble.xhtml";
        
       	}
	 public void remove(String ref_meuble) {
		 mc.removeProduct(ref_meuble);
			getM();
	
	    }
	 
		
	public void displayMeuble(Meubles meuble)
	{
	this.setNom_meuble(meuble.getNom_meuble());
	this.setDescription_meuble(meuble.getDescription_meuble());
	this.setTypem(meuble.getType_meuble());
	this.setPrice(meuble.getPrix());
	this.setUpdate(meuble.getRef_meuble());
	}
	public void updateMeuble()
	
	{ ms.updateMeuble(new Meubles(update, nom_meuble, description_meuble, price, typem));
		 }
	public void openNew() {
        this.m = new Meubles();
    }
	
    
    
   
    boolean skip;
    public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
    public String onFlowProcess(FlowEvent event) {
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
    private String destination = "C:/Users/Sarra/Documents/workspace-sts-3.8.4.RELEASE/DariTn/images";
    public void upload(FileUploadEvent event) throws Exception {
//    	try{
//    		if(file != null){
//    		Class.forName("com.mysql.jdbc.Driver");
//    		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/DariTn?user=root&password=");
//    		PreparedStatement st= cn.prepareStatement("INSERT INTO Meubles(img) VALUES (?)");
//    		st.setBinaryStream(1,file.getInputStream());
//    		st.executeUpdate();
//    		cn.close();
//    		}
//    		}
//    		catch (Exception e){}
//    try {
//		FileUploadUtil.saveFile("/images", "xx", file);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
    	FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file
//        try {
//            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
//            String f=event.getFile().getFileName();
//            file.write("C:\\jsf-img\\"+f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
    }
    public String processUpload() {
    	System.err.println("xxxxxxxxx");
		FileUploadUtil uploadHelper = new FileUploadUtil();
		this.picture = uploadHelper.processUpload(this.file);
		return "Meuble";
	}
//
//    public void copyFile(String fileName, InputStream in) {
//        try {
//
//            // write the inputStream to a FileOutputStream
//            OutputStream out = new FileOutputStream(new File(destination + fileName));
//
//            int read = 0;
//            byte[] bytes = new byte[1024];
//
//            while ((read = in.read(bytes)) != -1) {
//                out.write(bytes, 0, read);
//            }
//
//            in.close();
//            out.flush();
//            out.close();
//
//            System.out.println("New file created!");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//	
    
   

  public List<Meubles> saveById(long ref_meuble){
	  List<Meubles> mm = new ArrayList<>();
	  m = new Meubles();
	String ref=Long.toString(ref_meuble);
	 m=ms.retrieveMeubles(ref);
	 System.err.println("m="+m.getNom_meuble());
	mm.add(m);
	return mm ;  
  }
	 public String redirecrxx(long ref_meuble){
    	
//    			m = new Meubles();
//   	 m=ms.retrieveMeubles(ref_meuble);
//   
//   	this.cmd_m.add(this.m);
	this.ref_meuble=ref_meuble;
//	m = new Meubles();
//	String ref= Long.toString(ref_meuble);
//m=ms.retrieveMeubles(ref);
//
//this.cmd_m.add(this.m);
  return "/panier.jsf";
    }
	
public void saveFile(){
		System.err.println("xxxxxxx");
		try (InputStream input = file.getInputStream()) {
			String fileName = file.getSubmittedFileName();
	        Files.copy(input, new File(folder, fileName).toPath());
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
   
//   public void RemovePanier(String ref_meuble){
//   	System.err.println("RemovePanier ID +"+ ref_meuble);
//   	long id_remove=Long.parseLong(ref_meuble);
//   	for (Meubles cmd_m : saveById) {
//           if (id_remove==saveById.get) {
//           	produitPanier.remove(produitPaniers);
//           	System.err.println("apres l remove ID +"+ id_produit);
//   	    	
//           }
//       }
//   
//   }
   
//   public float totalePanier(String ref_meuble){
//   	System.err.println("totalePanier ID +"+ ref_meuble);
//   	long id_totale=Long.parseLong(ref_meuble);
//   	float totale=0;
//   	for (Meubles cmd_m : produitPanier) {
//   		totale=totale+produitPaniers.getPrix();
//   	}
//   	System.err.println("totalePanier TOTALE= +"+ totale);
//   	return totale;
//   }
private Part uploadedFile;

private File savedFile;

String pathImg = "src//main//webapp//img//m_img" ;

public Part getUploadedFile() {
	return uploadedFile;
}

public void setUploadedFile(Part uploadedFile) {
	this.uploadedFile = uploadedFile;
}
//upload
public String upload() {
	   System.err.println("xxxxxxxx");
	   String fileName=  RandomString.make(8) +"_uplgonaded_"+ java.util.Calendar.getInstance().getTime().getDay() + "_" +java.util.Calendar.getInstance().getTime().getMonth() +".png" ;
	   File uploads = new File(pathImg);
	   
	   savedFile = new File(uploads,fileName);
	   System.err.println("path saveFile "+ savedFile.getAbsolutePath());
	   System.err.println("sub uploadfile name "+ uploadedFile.getSubmittedFileName());
	   InputStream input;
	try {
	input = uploadedFile.getInputStream();
	System.err.println(input.toString());
	Files.copy(input, savedFile.toPath());
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	uploadedFile =  null;
	   return fileName;    

	}




}

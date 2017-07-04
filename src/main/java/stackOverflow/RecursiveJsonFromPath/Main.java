package stackOverflow.RecursiveJsonFromPath;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Main {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Something s = new Something();
		s.setCurrentFolder("toto");
		Something s2 = new Something();
		s2.setCurrentFolder("tata");
		
		Something s2bis = new Something();
		s2bis.setCurrentFolder("tataBis");
		
		Something[] s2Group = {s2bis};
		s2.setContent(s2Group);
		Something s2bispic = new Something();
		s2bispic.getCurrentPicture().put("fileName", "ThatPictureOfMysSelfILikeSoMuch.jpg");
		s2bispic.getCurrentPicture().put("path", "toto/tata/tataBis/ThatPictureOfMysSelfILikeSoMuch.jpg");
		s2bispic.getCurrentPicture().put("mimeType", "image/jpeg");
		
		Something s2bispic2 = new Something();
		s2bispic2.getCurrentPicture().put("fileName", "ThatPictureOfMysSelfIDontLike.jpg");
		s2bispic2.getCurrentPicture().put("path", "toto/tata/tataBis/ThatPictureOfMysSelfIDontLike.jpg");
		s2bispic2.getCurrentPicture().put("mimeType", "image/jpeg");
		
		
		Something[] s2BisGroup = {s2bispic,s2bispic2};
		s2bis.setContent(s2BisGroup);
		Something s3 = new Something();
		
		s3.getCurrentPicture().put("fileName", "selfie.jpg");
		s3.getCurrentPicture().put("path", "toto/selfie.jpg");
		s3.getCurrentPicture().put("mimeType", "image/jpeg");
		
		Something[] sGroup = {s2,s3};
		s.setContent(sGroup);
		
		ObjectMapper mapper = new ObjectMapper();
		String temp = mapper.writeValueAsString(s);
		System.out.println(temp);
	}
}

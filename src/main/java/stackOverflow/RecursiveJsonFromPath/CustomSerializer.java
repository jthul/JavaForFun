package stackOverflow.RecursiveJsonFromPath;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class CustomSerializer extends JsonSerializer<Something>{

	@Override
	public void serialize(Something value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		// Adding the folder into the json, only if it exists
		if(value.getCurrentFolder()!=null){
			jgen.writeObjectField(value.getCurrentFolder(), value.getChilds());
		}
	    
		// Adding properties of the picture, only if they exist
	    if(value.getCurrentPicture()!= null){
	    	for(String k : value.getCurrentPicture().keySet()){
	    		jgen.writeObjectField(k,value.getCurrentPicture().get(k));
	    	}
	    }
	    jgen.writeEndObject();
	}
	
}

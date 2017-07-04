package stackOverflow.RecursiveJsonFromPath;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(using = CustomSerializer.class)
public class Something {
	
	private String currentFolder; // Name of the folder if this instance of something is a folder
	private Something[] childs;
	
	private Map<String,String> currentPicture; // Picture propoerties if this instance of something is a picture
	
	public Something() {currentPicture = new HashMap<String,String>();}
	
	public Something[] getChilds() {
		return childs;
	}
	
	public void setContent(Something[] _childs) {this.childs = _childs;}
	public String getCurrentFolder() {return currentFolder;}
	public void setCurrentFolder(String _currentFolder) {this.currentFolder = _currentFolder;}
	public Map<String,String> getCurrentPicture() {return currentPicture;}
	public void setCurrentPicture(Map<String,String> currentPicture) {this.currentPicture = currentPicture;}
}
